package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NoForce;

public class NoForceBuilder extends Builder<ForceLaws> {

    public NoForceBuilder(String _type, JSONArray _data) {
        super(_type, _data);
        
    }

    @Override
    protected ForceLaws createTheInstance(JSONObject obj) {
        return new NoForce();
    }

    protected JSONObject createData(){
        return new JSONObject();
        
    }
    
    
}
