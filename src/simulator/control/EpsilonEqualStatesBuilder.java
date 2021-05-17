package simulator.control;

import javax.lang.model.util.ElementScanner6;

import org.json.JSONArray;
import org.json.JSONObject;

public class EpsilonEqualStatesBuilder extends Builder<StateComparator> {

    public EpsilonEqualStatesBuilder(String _type, JSONArray _data) {
        super(_type, _data);
       
    }

    @Override
    protected StateComparator createTheInstance(JSONObject obj) {
        StateComparator e= null;
        if (obj.has("eps")) {   //Obligamos a indicar a eps que tenga un valor, aunque sea 0.00.
            if (obj.getDouble("eps") != 0) {
                Double d1= obj.getDouble("eps");
                e = new EpsilonEqualStates(d1);
            }else{
                e = new EpsilonEqualStates(0.00);
            }
           
        }else{
            throw new IllegalArgumentException();
        }


        return e;
    }

    protected JSONObject createData(){
        JSONObject j = new JSONObject();
        j.put("eps", "Double epsilon data determines de maximun value for vectors");
        return j;
    }
    
    
}
