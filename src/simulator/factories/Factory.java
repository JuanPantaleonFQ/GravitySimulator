package simulator.factories;

import java.util.List;

import org.json.JSONObject;

public interface Factory<T> {
	public T createInstance(JSONObject info);	//La estructura JSON que se pasa como parámetro al método createInstance incluye dos
												//claves: type, que describe el tipo de objeto que se va a crear y; data, que es una estructura
												//JSON que incluye toda la información necesaria para crear el objeto

	public List<JSONObject> getInfo();
}
