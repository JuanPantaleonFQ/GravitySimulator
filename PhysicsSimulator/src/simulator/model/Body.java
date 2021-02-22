package simulator.model;

import java.util.Vector;

import org.json.JSONObject;

import simulator.misc.Vector2D;

public class Body {

    protected String id = "";
    protected Vector2D vector_V;        //vector de velocidad   
    protected Vector2D vector_f;        //vector de fuerza
    protected Vector2D vector_p;        //vector de posicion
    protected double mass;

    //constructor
    public Body(String id,double masa, Vector2D vVelocidad, Vector2D vposicion){
        this.id = id;        
        this.mass =  masa;
        this.vector_V = vVelocidad;
        this.vector_p = vposicion;
        this.vector_f = new Vector2D();

    }

    //default getters for protected.    

    public String getId() {
        return id;
    }  
    public double getMass() {
        return this.mass;
    }
    public Vector2D getVelocity(){

        return this.vector_V;
    }
    public Vector2D getForce(){
        return this.vector_f;

    }

    public Vector2D getPosition(){
        return this.vector_p;
    }

    //methods

    public void addForce(Vector2D f){
        this.vector_f.plus(f);
    }
    public  void resetForce(){
        this.vector_f = new Vector2D();
    }

    public void move(Double t){        
        if(this.mass == 0.00 ){
            Vector2D aceleracion = new Vector2D();

        }else{
            Vector2D aceleracion = new Vector2D()
        }

    }

    public JSONObject getStage(){     // devuelve la informacion del cuerpo en formato de JSON
        return null;   
        //Por implementar              
    }

    public String toString(){
        return getStage().toString();
    }

   

    
}
