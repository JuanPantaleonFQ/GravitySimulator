package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class MovingTowardsFixedPoint implements ForceLaws {

    //atributes:
    private static final double g = 9.81;
    private Vector2D aux;

    //Constructor:
    public MovingTowardsFixedPoint(){
        aux = new Vector2D();

    }

    //metodos_
    @Override
    public void apply(List<Body> bs) {
        for (Body bi : bs) {
            bi.addForce(bi.getPosition().direction().scale(-g));
            
        }
        
    }
    
    
}
