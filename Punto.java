
public class Punto{
    
    private int x;
    private int y;
    
    public Punto(int x, int y){
       this.x = x;
       this.y = y;
    }
    
    public int getX(){
       return x;
    }
    
    public int getY(){
       return y;
    }
    
    public void seX(int nuevaX){
       this.x = nuevaX;
    }
    
    public void setY(int nuevaY){
       this.y = nuevaY;
    }
}
