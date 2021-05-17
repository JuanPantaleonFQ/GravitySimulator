package simulator.control;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import simulator.factories.Factory;

public class BuilderBasedFactory<T> implements Factory<T> {

    protected List<Builder<T>> listBuilders;
    protected List<JSONObject> factoryElements;


    public BuilderBasedFactory(List<Builder<T>> builders){
        factoryElements = new ArrayList<JSONObject>();
		builders = new ArrayList<>(builders);
		for(Builder<T> b : builders) {
			factoryElements.add(b.getBuilderInfo());
		}
    }

    @Override
    public T createInstance(JSONObject info) {
        T a = null;        
        if(info == null) {
			throw new IllegalArgumentException("Invalid value for createInstance: null");
		}else{
            
            int i = 0;
		    while (i < listBuilders.size() && (a == null)) {
			a = listBuilders.get(i).createInstance(info);
			i++;
		    }
		    if (a != null){
			    return a;
		    }
		    else {
		    	throw new IllegalArgumentException();
		    }

        }
       
        
    }

    @Override
    public List<JSONObject> getInfo() {
        
        return factoryElements;
    }


    
}
