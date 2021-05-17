package simulator.control;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Builder<T> {
    
    //Atributes
    protected String type;
    protected JSONArray data;

    //Builder
    public Builder(String _type,JSONArray _data){
        this.type = _type;
        this.data = _data;
    }

    //Methods
    public T createInstance(JSONObject info){
        T obj = null;
        if (type != null && type.equals(info.getString("type"))) {
            obj =  createTheInstance(info.getJSONObject("data"));
            
        }       
        return obj;
    }
    protected abstract T createTheInstance(JSONObject obj);

    //metodos de informacion
    public JSONObject getBuilderInfo(){
        JSONObject j= new JSONObject();
        j.put("type", this.type);
        j.put("key", createData());
        j.put("desc", this.data);
        
        return j;
    }

    protected JSONObject createData() {
		return new JSONObject();
	}
}
