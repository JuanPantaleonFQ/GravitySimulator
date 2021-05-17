package simulator.model;

import java.util.List;

import simulator.misc.Vector2D;

public class NewtonUniversalGravitation implements ForceLaws {

    //Atributtes:
    private double G;


    //Constructor:  
    public NewtonUniversalGravitation(){
        G = 6.67E-11;
    }

    public NewtonUniversalGravitation(Double g){
        this.G = g;
    }
    
    
    
    //Overrited methods:
    @Override
    public void apply(List<Body> bs) {  //este metodo recorre la lista aplicando las fuerzas de NewtonUniversalGravitation
        for (Body bi : bs) {
            for (Body bj : bs) {
                bi.addForce(force(bi, bj));
            }  
        }       
    }

    public Vector2D force(Body a,Body b){
        double fuerzanumeral;
        Vector2D out = new Vector2D();
        if (!a.getId().equals(b.getId())) {
                    
            if (a.getMass() != 0) {
                Vector2D auxiliarDireccion = new Vector2D(b.getPosition().minus(a.getPosition()));
                if (auxiliarDireccion.magnitude()>0) {
                    fuerzanumeral = (G*(a.getMass()*b.getMass())/(a.vector_p.distanceTo(b.vector_p)));
                   
                    
                }else{
                    fuerzanumeral = 0.00;
                }
                
                 out = new Vector2D(auxiliarDireccion.scale(fuerzanumeral));
                              
            }
            
        
        }
        
        return out;
    
    }

    //metodos de informacion:

    public String toString(){
        return "Universal Gravitation with gravitational constant " + G;
    }
}