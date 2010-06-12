/**
 *  This file is part of LogiSima.
 *
 *  LogiSima is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  LogiSima is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with LogiSima.  If not, see <http://www.gnu.org/licenses/>.
 */
package play.modules.yml;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import play.Logger;
import play.Play;
import play.db.jpa.JPASupport;

public class YmlExtractor {
    
    private static final String TAB = "    ";

    public static void main(String[] args) throws Exception {
        
        // we initiate play! framework
        File root = new File(System.getProperty("application.path"));
        Play.init(root, System.getProperty("play.id", ""));

        // we retrieve parameters
        String filename = "data";
        String output = "conf/";
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("--")) {
                if (args[i].startsWith("--filename=")) {
                    filename = args[i].substring(11);
                }
                if (args[i].startsWith("--output=")) {
                    output = args[i].substring(9);
                }
            }
        }

        // get an entityManager to acces play DB
        EntityManager em = YmlExtractorUtil.iniateJPA();

        // Init YAML 
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(options);
        
        // initiate Map that will contain all object
        HashMap<String, String> mapObject = new HashMap();
        
        // we search all entities classes
        List<Class> entities = Play.classloader.getAnnotatedClasses(Entity.class);
        for (Class entity : entities) {
            Logger.info("Generate YML for class :" + entity.getCanonicalName());

            // we search all object for the specified class
            List<JPASupport> objects = (List<JPASupport>) em.createQuery("select e from " + entity.getCanonicalName() + " as e").getResultList();
            for (JPASupport jpaSupport : objects) {
                
                String stringObject = "\n" + jpaSupport.getClass().getCanonicalName() + "(" + YmlExtractorUtil.getObjectId(jpaSupport) + "):\n";
                
                Logger.info("Generate YML for class id :" + YmlExtractorUtil.getObjectId(jpaSupport));

                for (java.lang.reflect.Field field : jpaSupport.getClass().getFields()) {
                    Map<String, Object> data = new HashMap<String, Object>();
                    String name = field.getName();
                    if (!name.equals("id") && !name.equals("willBeSaved")) {
                        // if field is a List
                        if (List.class.isInstance(field.get(jpaSupport))) {
                            List myList = (List) field.get(jpaSupport);
                            String[] tmpValues = new String[myList.size()];
                            for (int i = 0; i < myList.size(); i++) {
                                tmpValues[i] = YmlExtractorUtil.getObjectId(myList.get(i));
                                
                            }
                            data.put(name, tmpValues);
                        } else {
                            // if field is a Map
                            if (Map.class.isInstance(field.get(jpaSupport))) {
                                Map myMap = (Map) field.get(jpaSupport);
                                String[] tmpValues = new String[myMap.size()];
                                Iterator it = myMap.entrySet().iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                    Object myObj = it.next();
                                    tmpValues[i] = YmlExtractorUtil.getObjectId(myObj);
                                    i++;
                                }
                                data.put(name, tmpValues);
                            }
                            else {
                                // if field is a Set
                                if(Set.class.isInstance(field.get(jpaSupport))){
                                    Set mySet = (Set) field.get(jpaSupport);
                                    String[] tmpValues = new String[mySet.size()];
                                    Iterator it = mySet.iterator();
                                    int i = 0;
                                    while (it.hasNext()) {
                                        Object myObj = it.next();
                                        tmpValues[i] = YmlExtractorUtil.getObjectId(myObj);
                                        i++;
                                    }
                                    data.put(name, tmpValues);
                                }
                                // otherwise, it's normal field
                                else{
                                    String tmpValue = YmlExtractorUtil.field2Yml(jpaSupport, field);
                                    data.put(name, tmpValue);
                                }
                            }
                        }
                        String value = yaml.dump(data).replaceAll("^", TAB);
                        // a little hack for scalar ... I have to find a better solution
                        value = value.replaceAll("- ", TAB + "- ");
                        
                        stringObject += value;
                    }
                }
                
                mapObject.put(YmlExtractorUtil.getObjectId(jpaSupport), stringObject);
            }
        }
        YmlExtractorUtil.writeYml(output, filename, mapObject);
    }

}
