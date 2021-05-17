package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.model.ForceLaws;
import simulator.model.NewtonUniversalGravitation;

public class NewtonUniversalGravitationBuilder extends Builder<ForceLaws> {

    public NewtonUniversalGravitationBuilder(String _type, JSONArray _data) {
        super(_type, _data);
        
    }

    @Override
    protected ForceLaws createTheInstance(JSONObject obj) {
        NewtonUniversalGravitation n =  null;
        if(obj.has("G")) {
			n = new NewtonUniversalGravitation(obj.getDouble("G"));
		}
		else {
			n = new NewtonUniversalGravitation();
		}
        return n;
    }
    
    protected JSONObject createData() {
		JSONObject data = new JSONObject();
		data.put("G", "G force (can be exist or not)");
		return data;
	}
    
    
}
