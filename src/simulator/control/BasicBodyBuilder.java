package simulator.control;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.Body;

public class BasicBodyBuilder extends Builder<Body> {

    
    public BasicBodyBuilder(String _type, JSONArray _data) {
        super(_type, _data);
        
    }

    protected Body createTheInstance(JSONObject obj) {
        Body b = null;
        if (obj.has("id") && obj.has("mass") && obj.has("vector_p") && obj.has("vector_v") && obj.has("vector_f")) {
            String id = obj.getString("id");//el id 
            Double m = obj.getDouble("mass");//la masa
            //vector posicion
            JSONArray j1 = obj.getJSONArray("vector_p");
            Vector2D p = new Vector2D(j1.getDouble(0),j1.getDouble(1));
            //vector velocidad
            JSONArray j2 = obj.getJSONArray("vector_v");
            Vector2D v = new Vector2D(j2.getDouble(0),j2.getDouble(1));
            b = new Body(id, p, v, m);       
            
            
            
        }else{
            throw new IllegalArgumentException();
        }
        return b;
    }

    
    



    
}
