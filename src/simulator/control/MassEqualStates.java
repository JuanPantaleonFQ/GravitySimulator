package simulator.control;

import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONObject;

public class MassEqualStates implements StateComparator {

    //metodo sobreescrito clase StateComparator.
    @Override
    public boolean equal(JSONObject s1, JSONObject s2) {
        boolean notequals = true;
        if (s1.getDouble("Time") == s2.getDouble("Time")) {
            JSONArray ss1 = s1.getJSONArray("Bodies");
            JSONArray ss2 = s2.getJSONArray("Bodies");
            if (ss1.length()== ss2.length()) {
                int i = 0 ;
                while(i < ss1.length() && notequals){
                    if (comparatorBody(ss1.getJSONObject(i), ss2.getJSONObject(i))) {
                        notequals = false;
                    }

                    i++;
                }                
            }else{
                notequals = false;
            }
        }else{
            notequals = false;
        }


        
        return notequals;
    }

    private boolean comparatorBody(JSONObject jsonObject, JSONObject jsonObject2) {
        boolean same= false;
        if (jsonObject.getString("id").equals(jsonObject2.getString("id")) && jsonObject.getDouble("mass") == jsonObject2.getDouble("mass")) {
            same = true;
        }

        return same;
    }
    
    
}
