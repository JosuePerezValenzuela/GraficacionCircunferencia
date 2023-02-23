import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Point;


public class MyPanel extends JPanel{
    
    Algoritmo algoritmo;
    int cenX;
    int cenY;
    int radio;
    
    BufferedImage canvas = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
    
    public MyPanel(int centroX, int centroY, int radio){
        cenX = centroX;
        cenY = centroY;
        this.radio = radio;
    }
    
    public MyPanel(){
    
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        
        //Ejes
        g.drawLine(30, 250, 470, 250);
        g.drawLine(250, 30, 250, 470);
        
        
        int xCentro = 250;
        int yCentro = 250;
        
        algoritmo = new Algoritmo();
        ArrayList<Point> puntosX = algoritmo.calPuntosOficial(250,250,250,279);
        ArrayList<Point> puntosY = algoritmo.calPuntosOficial(250,250,250,281);
        ArrayList<Point> puntosOf = algoritmo.calPuntosOficial(250,250,250,280);
        
        ArrayList<Punto> puntosPolar = algoritmo.graficandoConPolar(radio);
        
        // cenX y cenY son los centro de la circunferencia respecto al sistema de coordenadas
        
        int xCal = xCentro + cenX; 
        int yCal = yCentro - cenY;
        
        g.setColor(Color.RED);
        for(int i = 0; i < puntosX.size(); i++){
           //g.drawLine(xCal + (int)puntosX.get(i).getX(), yCal + (int)puntosX.get(i).getY(), xCal + (int)puntosX.get(i).getX(), yCal + (int)puntosX.get(i).getY());
        }
        
        for(int i = 0; i < puntosY.size(); i++){
           //g.drawLine(xCal + (int)puntosY.get(i).getX(), yCal + (int)puntosY.get(i).getY(), xCal + (int)puntosY.get(i).getX(), yCal + (int)puntosY.get(i).getY());
        }
        
        for(int i = 0; i < puntosOf.size(); i++){
           g.drawLine(xCal + (int)puntosOf.get(i).getX(), yCal + (int)puntosOf.get(i).getY(), xCal + (int)puntosOf.get(i).getX(), yCal + (int)puntosOf.get(i).getY());
        }
        
        for(int i = 0; i < puntosPolar.size(); i++){
           //g.drawLine(xCal + puntosPolar.get(i).getX(), yCal + puntosPolar.get(i).getY(), xCal + puntosPolar.get(i).getX(), yCal + puntosPolar.get(i).getY());
           //canvas.setRGB(xCal + puntosPolar.get(i).getX(), yCal + puntosPolar.get(i).getY(),130);
        }
        
        g.setColor(Color.GREEN);
        g.drawLine(250, 250, 250, 250);
        g.drawLine(225, 225, 225, 225);
        g.drawLine(275, 225, 275, 225);
        g.drawLine(275, 275, 275, 275);
        g.setColor(Color.RED);
        g.drawLine(225, 275, 225, 275);
        
        g.setColor(Color.BLUE);
        g.drawLine(225,175 ,225, 175);
        g.drawLine(325, 275, 325, 275);
        g.drawLine(225, 375, 225, 375);
        g.drawLine(125, 275, 125, 275);
        
    }
    
    public static void main(int centroX, int centroY, int radio){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Dibujo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.WHITE);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
                
        MyPanel panel = new MyPanel(centroX, centroY, radio);
        ventana.add(panel);
        
        ventana.setVisible(true);
    }
}
