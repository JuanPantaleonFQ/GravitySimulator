package simulator.model;


import org.json.JSONObject;
import simulator.misc.Vector2D;


public class Body {

    //Atributtes:
    protected String id;
    protected Vector2D vector_p;    //vector posicion
    protected Vector2D vector_f;    //vector fuerza 
    protected Vector2D vector_v;    //vector velocidad
    protected double mass;          //masa del cuerpo

    //Constructor:
    public Body(String id,Vector2D p,Vector2D v,double m){
        this.id = id;
        this.vector_p = p;
        this.vector_v = v;
        this.mass = m;
        this.vector_f = new Vector2D();

    }
    //getters y setters
    public String getId(){
        return this.id;
    }
    public Vector2D getVelocity(){
        return this.vector_v;
    }
    public Vector2D getForce(){
        return this.vector_f;
    }
    public Vector2D getPosition(){
        return this.vector_p;
    }
    public double getMass(){
        return this.mass;
    }

    //metodos:
    void addForce(Vector2D f){
        vector_f.plus(f);
    }
    void resetForce(){
        vector_f = new Vector2D();
    }
    void move(double t){
        
        if (this.mass == 0 ) {
            Vector2D vector_a = new Vector2D();
            this.vector_p= this.vector_p.plus((this.vector_f.scale(t)).plus(vector_a.scale(t*t*0.5)));
            this.vector_v = this.vector_v.plus(vector_a.scale(t));
        }else{

            Vector2D vector_a = new Vector2D(vector_f.scale(1/this.mass));
            this.vector_p= this.vector_p.plus((this.vector_f.scale(t)).plus(vector_a.scale(t*t*0.5)));
            this.vector_v = this.vector_v.plus(vector_a.scale(t));
        }
    }
    //metodo equals:

    public boolean equals(Object obj){
        return false;        
    }
    
    //metodos de informacion:
    
    public JSONObject getState(){
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("mass", this.mass);
        json.put("vector_p", this.vector_p);
        json.put("vector_f", this.vector_f);
        json.put("vector_v", this.vector_v);
        
        return json;
    }
    public String toString(){
        return getState().toString();
    }


}
