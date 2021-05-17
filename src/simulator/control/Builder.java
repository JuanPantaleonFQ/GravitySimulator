package simulator.control;

import org.json.JSONObject;

public abstract class Builder<T> {


    public T createInstance(JSONObject info){
        T obj = null;
        
        return obj;

    }

    public abstract JSONObject createTheInstance(JSONObject obj);

    public JSONObject getBuilderInfo(){
        JSONObject jObject= null;



        return jObject;
    }
    
}
