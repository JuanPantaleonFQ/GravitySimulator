package simulator.control;

import org.json.JSONObject;

public class EpsilonEqualStates implements StateComparator  {

    private double eps;
    //constructor:
    public EpsilonEqualStates(double eps){
        this.eps = eps;

    }

    @Override
    public boolean equal(JSONObject s1, JSONObject s2) {
        boolean equal = false;
        double n1,n2;
         
         
        if (s1.getDouble("Time") == s2.getDouble("Time")) {
            if (equal) {
                
            }
            
        }
        return equal;
    }
    
    
}
