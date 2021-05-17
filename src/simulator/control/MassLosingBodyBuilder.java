package simulator.control;

import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Vector2D;
import simulator.model.MassLossingBody;

public class MassLosingBodyBuilder extends Builder<MassLossingBody> {

    public MassLosingBodyBuilder(String _type, JSONArray _data) {
        super(_type, _data);
        
    }

    @Override
    protected MassLossingBody createTheInstance(JSONObject obj) {
        MassLossingBody b = null;
        if (obj.has("id") && obj.has("vector_p") && obj.has("vector_v") && obj.has("mass") && obj.has("lossFactor") && obj.has("lossFrecuency")) {
            String id =obj.getString("id");
            Double d1 = obj.getDouble("lossFactor");
            Double d2 = obj.getDouble("lossFrecuency");
            Double d3 = obj.getDouble("mass");

            //vector p
            JSONArray j1 = obj.getJSONArray("vector_p");
            if (j1.length() != 2) {
                throw new IllegalArgumentException();
            }
            Vector2D p = new Vector2D(j1.getDouble(0),j1.getDouble(1));
            //vector v
            JSONArray j2 = obj.getJSONArray("vector_v");
            if (j2.length() != 2) {
                throw new IllegalArgumentException();
            }
            Vector2D v = new Vector2D(j2.getDouble(0), j2.getDouble(1));
            b = new MassLossingBody(id, p, v, d3, d1, d2);
        }else{
            throw new IllegalArgumentException();
        }

        return b;
    }

    protected JSONObject createData() {
		JSONObject j = new JSONObject();
        JSONArray ar1 = new JSONArray();
        ar1.put("Double value 1");
        ar1.put("Double value 2");

        JSONArray ar2 = new JSONArray();
        ar2.put("Double value 1");
        ar2.put("Double value 2");




        j.put("id","String identifier" );        
        j.put("p", ar1);        
        j.put("v",ar2 );        
        j.put("m","Double mass factor" );        
        j.put("freq","Double factor indicates time during wich the object loses mass." );        
        j.put("factor","Double value lose factor betwen (0,1)." );

        return j;

	}
    
}
