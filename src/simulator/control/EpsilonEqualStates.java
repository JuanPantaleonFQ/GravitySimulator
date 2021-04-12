package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;

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
            if (moduleEpsilon(j1.getDouble("mass"), j2.getDouble("mass"))){
                Vector2D f1 = new Vector2D(j1.getJSONArray("f").getDouble(0), j1.getJSONArray("f").getDouble(1)); 
                Vector2D f2 = new Vector2D(j2.getJSONArray("f").getDouble(0), j2.getJSONArray("f").getDouble(1)); 
                Vector2D v1 = new Vector2D(j1.getJSONArray("v").getDouble(0), j1.getJSONArray("v").getDouble(1)); 
                Vector2D v2 = new Vector2D(j2.getJSONArray("v").getDouble(0), j2.getJSONArray("v").getDouble(1)); 
                Vector2D p1 = new Vector2D(j1.getJSONArray("p").getDouble(0), j1.getJSONArray("p").getDouble(1)); 
                Vector2D p2 = new Vector2D(j2.getJSONArray("p").getDouble(0), j2.getJSONArray("p").getDouble(1)); 
                if (moduleEpsilon(f1, f2) && moduleEpsilon(v1, v2) && moduleEpsilon(p1, p2)) {
                    igual = true;
                }               
                
            }
            
        }
        
        return igual;     
    }
    private boolean moduleEpsilon (double a, double b) {
		return Math.abs(a-b) <= eps;
	}
	
	private boolean moduleEpsilon (Vector2D v1, Vector2D v2) {
		return v1.distanceTo(v2) <= eps;
	}
    
}
