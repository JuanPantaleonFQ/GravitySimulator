package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

public class MassEqualStatesBuilder extends Builder<StateComparator> {

    public MassEqualStatesBuilder(String _type, JSONArray _data) {
        super(_type, _data);
        
    }

    @Override
    protected StateComparator createTheInstance(JSONObject obj) {
        StateComparator s = null;
		s = new MassEqualStates();
		
		return s;
    }

    protected JSONObject createData() {
		JSONObject data = new JSONObject();		
		return data;
	}
    
    
}
