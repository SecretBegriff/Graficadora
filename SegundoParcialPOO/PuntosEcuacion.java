package SegundoParcialPOO;
import java.util.Vector;
import java.awt.*;
import java.awt.geom.*;

public class PuntosEcuacion extends Frame{
    private static Vector<Punto<Double>> puntos;
    private Punto<Double> punto;
    private Polinomio poli;
    private static String ecuacion;

    public PuntosEcuacion(){
        super("Grafica");
    }
    
    public boolean handleEvent(Event e){  //Event es una clase de awt no se necesita declarar
        if (e.id == Event.WINDOW_DESTROY) {  //Esta es una funcion de Event
            hide(); //oculta ventana
            dispose();  //libera memoria cerrando la ventana
            return true;
        }
        return super.handleEvent(e);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        int x1 =50;
        int y1=50;
        //g2d.translate(0, 0);
        g2d.setColor(Color.LIGHT_GRAY);
        for(int i=0;i<30;i++){
            g2d.draw(new Line2D.Float(x1,0,x1,600));
            x1+=50;
        }
        for(int i=0;i<30;i++){
            g2d.draw(new Line2D.Float(0,y1,600,y1));
            y1+=50;
        }
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.draw(new Line2D.Float(0, 300, 600, 300));
        g2d.draw(new Line2D.Float(300, 0, 300, 600));
        g2d.setColor(Color.GREEN);
        g2d.setColor(Color.RED);
        g2d.translate(300, 300);
        for(int i = 1; i < 10000; i++){
            g2d.draw(new Line2D.Double(puntos.get(i-1).getX(), puntos.get(i-1).getY(), puntos.get(i).getX(), puntos.get(i).getY()));
        }
        
        Font font = new Font("Arial", Font.BOLD + Font.ITALIC, 15);
        g2d.setFont(font);

        g2d.drawString(ecuacion ,60,100);



    } 

    public PuntosEcuacion(Polinomio poli, double linf, double lsup, double inc){
        this.poli = poli;
        puntos = new Vector<>();
        for(double i=linf; i < lsup; i+=inc){
            double y = poli.evalua_p(i);
            Punto<Double> nuevoPunto = new Punto<>(i,y);
            puntos.add(nuevoPunto);
        }
    }

    public Vector<Punto<Double>> getPuntosEcuacion(){ 
        return puntos;
    }

    public Punto<Double> getPunto(int num){
        double aux = poli.evalua_p(num);
        Punto<Double> punto = new Punto<Double>(Double.valueOf(num), Double.valueOf(aux));
        return punto;
    } 


    public static void main(String[] arg){
        Termino t1 = new Termino(2, 1);
        Termino t2 = new Termino(0.1, 2);
        Termino t3 = new Termino(0.001, 3);
        Polinomio p1 = new Polinomio(6);
        p1.agregarTermino(0,t1);
        p1.agregarTermino(1,t2);
        p1.agregarTermino(2,t3);
        PuntosEcuacion pe1 = new PuntosEcuacion(p1, -5000, 5000, 1);
        puntos = pe1.getPuntosEcuacion();
        ecuacion = p1.toString();
        System.out.println();
        System.out.println("Polinomio: "+p1.toString());
        System.out.println();
        System.out.println("Puntos evaludados en 3: ");
        System.out.println("(" + pe1.getPunto(3).getX().toString() + ", " + pe1.getPunto(3).getX().toString() + ")");

        System.out.println();
        System.out.println("\nPolinomio evaluado desde -2 hasta 2: ");
        for(Punto<Double> punto : puntos){
            System.out.println(punto.getX() + ", " + punto.getY())  ;
        }

        

        System.out.println();
        System.out.println("Termino 1: "+t1.toString());

        PuntosEcuacion dibujo = new PuntosEcuacion();
        dibujo.resize(600, 600);
        dibujo.show();
    }

}
