package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws {

    //atributes:
    private Double g;
    private Vector2D c;

    //Constructor:
    public MovingTowardsFixedPoint(){
        c = new Vector2D();
        g = 9.81;
        
    }
    public MovingTowardsFixedPoint(Vector2D vector_, double gforce ){
        c = new Vector2D(vector_);
        g = gforce;
    }

    //metodos_
    @Override
    public void apply(List<Body> bs) {
        for (Body bi : bs) {
            bi.addForce(bi.getPosition().direction().scale(-g));
            
        }
        
    }
    
    
}
