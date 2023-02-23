import java.util.ArrayList;
import java.awt.Point;

public class Algoritmo{
    
    Point p1 = new Point();
    
    Point p2 = new Point();
    

    public ArrayList<Punto> calcularPuntosX(int radio){
        ArrayList <Punto> puntos = new ArrayList<>();
        for(int x = 0; x <= radio; x++){
            int y = (int)((Math.sqrt((Math.pow(radio, 2)) - (Math.pow((- x), 2))))); 
            Punto punto1 = new Punto(x,y);
            Punto punto2 = new Punto((x * -1), y);
            Punto punto3 = new Punto((x * -1), (y * -1));
            Punto punto4 = new Punto(x, (y * -1));
            puntos.add(punto1);
            puntos.add(punto2);
            puntos.add(punto3);
            puntos.add(punto4);
        } 
        return puntos;
    }

    public ArrayList<Punto> calcularPuntosY(int radio){
        ArrayList <Punto> puntos = new ArrayList<>();
        for(int y = 0; y <= radio; y++){
            int x = (int)((Math.sqrt((Math.pow(radio, 2)) - (Math.pow((- y), 2))))); 
            Punto punto1 = new Punto(x,y);
            Punto punto2 = new Punto((x * -1), y);
            Punto punto3 = new Punto((x * -1), (y * -1));
            Punto punto4 = new Punto(x, (y * -1));
            puntos.add(punto1);
            puntos.add(punto2);
            puntos.add(punto3);
            puntos.add(punto4);
        } 
        return puntos;
    }

    public ArrayList<Point> calPuntosOficial(int xrad, int yrad, int xp, int yp){
        p1.setLocation(xrad, yrad);
        p2.setLocation(xp,yp);
        ArrayList <Point> puntos = new ArrayList();
        double xCentro = p1.getX();
        double yCentro = p1.getY();
        double radio = p2.getY() - p1.getY();
        double pk = 3 - 2 * radio;
        double x1 = 0;
        double y1 = radio;
        puntos.add(p2);
        while (x1 <= y1){
            if(pk < 0){
                x1 = x1 + 1;
                y1 = y1;
                pk = pk + 4 * x1 + 6;
            }else{
                x1 = x1 + 1;
                y1 = y1 - 1;
                pk = pk + 4 * (x1 - y1) + 10;
            }
            Point paux = new Point();
            paux.setLocation(x1, y1);
            puntos.add(paux);
        }
        puntos = Octantes(puntos);
        return puntos;
    }

    public ArrayList<Point> Octantes(ArrayList <Point> puntos){
        ArrayList<Point> puntosFinal = new ArrayList<>();
        for(int i = 0; i < puntos.size(); i++){
            puntosFinal.add(puntos.get(i));
            double x = puntos.get(i).getX();
            double y = puntos.get(i).getY();
            Point paux2 = new Point();
            paux2.setLocation(-x, y);
            Point paux3 = new Point();
            paux3.setLocation(-x, -y);
            Point paux4 = new Point();
            paux4.setLocation(x, -y);
            Point paux5 = new Point();
            paux5.setLocation(y, x);
            Point paux6 = new Point();
            paux6.setLocation(-y, x);
            Point paux7 = new Point();
            paux7.setLocation(-y, -x);
            Point paux8 = new Point();
            paux8.setLocation(y, -x);
            puntosFinal.add(paux2);
            puntosFinal.add(paux3);
            puntosFinal.add(paux4);
            puntosFinal.add(paux5);
            puntosFinal.add(paux6);
            puntosFinal.add(paux7);
            puntosFinal.add(paux8);
        }
        return puntosFinal;
    }

    public ArrayList<Punto> graficandoConPolar(int r){
        ArrayList<Punto> puntos = new ArrayList<>();
        double alpha = Math.toRadians(0);
        int x = r;
        int y = 0;
        int cont = 0;
        while(alpha <= (Math.PI / 4)){
            alpha = alpha + Math.toRadians(1);
            double xd = r * Math.cos(alpha);
            x = (int) Math.round(xd);
            double yd = r * Math.sin(alpha);
            y = (int) yd;
            Punto punto1 = new Punto(x,y);
            Punto punto2 = new Punto((x * -1), y);
            Punto punto3 = new Punto((x * -1), (y * -1));
            Punto punto4 = new Punto(x, (y * -1));
            Punto punto5 = new Punto(y,x);
            Punto punto6 = new Punto((y * -1), x);
            Punto punto7 = new Punto((y * -1),(x * -1));
            Punto punto8 = new Punto(y,(x * -1));
            puntos.add(punto1);
            puntos.add(punto2);
            puntos.add(punto3);
            puntos.add(punto4);
            puntos.add(punto5);
            puntos.add(punto6);
            puntos.add(punto7);
            puntos.add(punto8);
            cont ++;
        }
        return puntos;
    }
}
