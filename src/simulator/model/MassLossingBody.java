package simulator.model;

import simulator.misc.Vector2D;

public class MassLossingBody extends Body {

    //Atributtes:
    protected Double lossFactor;        //valor entre 0 y 1 factor de perdida
    protected Double lossFrecuency;     //valor > 0 . Indica el intervalo de tiempo a partir del cual el objeto pierde masa.
    protected Double cnt;               //Contador para saber si ha pasado x tiempo desde la creacion del objeto
    
    //Constructor:
    public MassLossingBody(String id, Vector2D p, Vector2D v, double mass,Double lFactor,Double lFrecuenci) {
        super(id, p, v, mass);
        this.lossFactor = lFactor;
        this.lossFrecuency = lFrecuenci;
        this.cnt = 0.00;
        
    }

    //methods:
    public void move(double t){
        
        if (this.mass == 0 ) {
            Vector2D vector_a = new Vector2D();
            this.vector_p= this.vector_p.plus((this.vector_f.scale(t)).plus(vector_a.scale(t*t*0.5)));
            this.vector_v = this.vector_v.plus(vector_a.scale(t));
        }else{

            Vector2D vector_a = new Vector2D(vector_f.scale(1/this.mass));
            this.vector_p= this.vector_p.plus((this.vector_f.scale(t)).plus(vector_a.scale(t*t*0.5)));
            this.vector_v = this.vector_v.plus(vector_a.scale(t));
        }
        if (this.cnt >= lossFrecuency) {
            this.mass = this.mass*(1 - lossFactor);
            this.cnt = 0.00;
        }
    }
    
}
