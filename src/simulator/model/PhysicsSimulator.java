package simulator.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PhysicsSimulator {

    //Atributos:
    private double tiempoActual;              //representa el tiempo normal que transcurre en el programa
    private double dt;                       //representa el tiempo que corresponde a un paso de simulacion, se le pasara a los metodos move() de los cuerpos
    private ForceLaws forcelaws;             //representa las leyes de fuerza que el simulador aplicara
    private List<Body> bs;                   //lista de los cueros que va a usar el sistema

    //constructura
    public PhysicsSimulator(double t,ForceLaws f){
        if (t < 0.00 || f == null) {
            throw new IllegalArgumentException();
            
        }else{
            this.forcelaws = f;
            this.dt = t;
            this.tiempoActual = 0.00;
            this.bs = new ArrayList<Body>();
        }
        
    }


    //metodos:

    public void advance(){  //Done @JuanPantaleonFQ

        for (Body body : bs) {
            body.resetForce();
        }
        forcelaws.apply(bs);        //este metodo llama a todos los metodos apply de las distintas
                                    // leyes con el array de cuerpos(a cada cuerpo)
        for (Body body: bs){
            body.move(dt);
            
        }
        this.tiempoActual+= this.dt;

    }
    public void addBody(Body b){
        if (bs.contains(b)) {
            throw new IllegalArgumentException();

        }else{
            bs.add(b);
        }
    }

    //metodos de informacion:
    public JSONObject getState(){
        JSONObject json = new JSONObject();
        
        
       ;
        json.put("Time", this.tiempoActual);
        json.put("Bodies", this.getArrayStateBody());
        return json;
    }


    private JSONArray getArrayStateBody() {
        JSONArray jarray = new JSONArray();
        for (Body body : bs) {
            jarray.put(body.getState());
        }
        return jarray;
    }

    public String toString(){
        return getState().toString();
    }
}
