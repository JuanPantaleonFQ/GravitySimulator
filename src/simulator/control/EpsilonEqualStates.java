package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

public class EpsilonEqualStates implements StateComparator  {

    private double eps;
    //constructor:
    public EpsilonEqualStates(double eps){
        this.eps = eps;

    }

    @Override
    public boolean equal(JSONObject s1, JSONObject s2) {
        boolean equal = true;
        if(s1.getDouble("Time") == s2.getDouble("Time") ){
            JSONArray jsonarray1 = s1.getJSONArray("Bodies");
            JSONArray jsonarray2 = s2.getJSONArray("Bodies");
            if (jsonarray1.length() == jsonarray2.length()) {
                int i = 0 ;
                while (i < jsonarray1.length() && !equal) {
                    if (!comparatorScale(jsonarray1.getJSONObject(i), jsonarray2.getJSONObject(i))) {
                        equal = false;
                    }else{
                        equal = true;
                    }
                    i++;
                }
                
            }else{
                equal = false;
            }
        }else{
            equal = false;
        }
        return equal;
    }
    
    //metodo personal:

    private boolean comparatorScale(JSONObject j1, JSONObject j2){
        boolean igual = false;
        if (j1.getString("id").equals(j2.getString("id"))){
            double mass1 = j1.getDouble("mass");
            double mass2 = j2.getDouble("mass");
            if (Math.abs(mass1-mass2) <= this.eps) {
                if () {
                    
                }
                
            }
            
        }
        
        return false;     
    }
    
}
