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
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import play.Play;
import play.db.jpa.JPASupport;
import play.modules.yml.models.YmlObject;

/**
 * Main class of logisima-yml module.
 * 
 * @author bsimard
 *
 */
public class YmlExtractor {
    
    /**
     * HashMap of all database object.
     */
    private static HashMap<String, YmlObject> ymlObjects = new HashMap();
    
    /**
     * Main method !
     * 
     * @param args
     * @throws Exception
     */
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
        
        // we search all entities classes
        List<Class> entities = Play.classloader.getAnnotatedClasses(Entity.class);
        for (Class entity : entities) {

            // we search all object for the specified class
            List<JPASupport> objects = (List<JPASupport>) em.createQuery("select e from " + entity.getCanonicalName() + " as e").getResultList();
            for (JPASupport jpaSupport : objects) {
                
                YmlObject ymlObject = YmlExtractorUtil.object2YmlObject(jpaSupport);
                ymlObjects.put(YmlExtractorUtil.getObjectId(jpaSupport), ymlObject);
            }
        }
        
        
        // write yml file.
        YmlExtractorUtil.writeYml(output, filename, ymlObjects);
    }

}
