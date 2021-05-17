package simulator.control;

import org.json.JSONObject;

import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {

    @Override
    public JSONObject createTheInstance(JSONObject obj) {
        Body b = null;
        if (obj.has("id") && obj.has("mass") && obj.has("vector_p") && obj.has("vector_v") && obj.has("vector_f")) {
            String id = obj.getString("id");
            
        }else{
            throw new IllegalArgumentException();
        }
        return null;
    }

    
    



    
}
