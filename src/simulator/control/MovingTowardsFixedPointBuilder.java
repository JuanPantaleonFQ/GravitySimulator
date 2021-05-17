package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.ForceLaws;
import simulator.model.MovingTowardsFixedPoint;

public class MovingTowardsFixedPointBuilder extends Builder<ForceLaws> {

    

    public MovingTowardsFixedPointBuilder(String _type, JSONArray _data) {
        super(_type, _data);
        
    }

    @Override
    protected ForceLaws createTheInstance(JSONObject obj) {
        ForceLaws l = null;
        if(obj.has("g") && obj.has("c")) {
			JSONArray cc = obj.getJSONArray("c");
			Vector2D c = new Vector2D(cc.getDouble(0), cc.getDouble(1));
			l = new MovingTowardsFixedPoint(c, obj.getDouble("g"));
		}
		else if(!obj.has("g") && !obj.has("c")){
			l = new MovingTowardsFixedPoint();
		}
		else {
			throw new IllegalArgumentException();
		}
        return l;
    }

    protected JSONObject createData() {
		JSONObject j = new JSONObject();
        JSONArray ar = new JSONArray();
        ar.put("Double value 1");
        ar.put("Double value 2");
        j.put("c",ar );
        j.put("g", "Double for the G factor (could exist or not)");
        return j;

	}
    
    
    
}
