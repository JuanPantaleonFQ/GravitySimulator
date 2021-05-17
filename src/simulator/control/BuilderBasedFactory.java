package simulator.control;

import java.util.List;

import org.json.JSONObject;

import simulator.factories.Factory;

public class BuilderBasedFactory<T> implements Factory<T> {

    public BuilderBasedFactory(List<Builder<T>> builders){
        
    }

    @Override
    public T createInstance(JSONObject info) {
        
        return null;
    }

    @Override
    public List<JSONObject> getInfo() {
        
        return null;
    }


    
}
