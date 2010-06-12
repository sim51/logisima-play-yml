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
package play.modules.yml.models;

import java.util.ArrayList;

public class YmlObject {

    private String id;
    private String ymlValue;
    private ArrayList<String> children = new ArrayList();
    
    public YmlObject() {
        super();
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getYmlValue() {
        return ymlValue;
    }
    
    public void setYmlValue(String ymlValue) {
        this.ymlValue = ymlValue;
    }
    
    public ArrayList<String> getChildren() {
        return children;
    }
    
    public void setChildren(ArrayList<String> children) {
        this.children = children;
    } 
    
    
}
