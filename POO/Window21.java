import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class Window21 extends JFrame{

    public Window21(){
        super("Dibujando Gráficos");
        setSize(800, 800);
        show();
    }

    public void paint(Graphics graph){

        Graphics2D g2d=(Graphics2D)graph;

        int Values1[]={265,179,196,204,169,146,227,196,172,287,244,168};
        int Values2[]={128,186,168,240,263,127,298,115,137,263,266,237};
        int Values3[]={272,271,292,192,105,217,269,293,125,258,264,292};

        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, 800, 800);

        graph.setColor(Color.black);
        for(int i=0;i<10;i++)
        graph.drawLine(70, (i*50)+150, 730, (i*50)+150);

        for(int i=0;i<=12;i++)
        graph.drawLine(75+(i*54),600,75+(i*54),605);

        graph.drawRect(25, 50, 750, 700);

        graph.setColor(Color.blue);
        for(int i=0;i<12;i++)
        graph.fillRect(81+(i*54),(600-Math.round(Values1[i]/2)),44,Math.round(Values1[i]/2));

        graph.fillRect(200, 700, 10, 10);

        graph.setColor(Color.red);
        for(int i=0;i<12;i++)
        graph.fillRect(81+(i*54),(600-Math.round(Values1[i]/2)-Math.round(Values2[i]/2)),44,Math.round(Values2[i]/2));

        graph.fillRect(350, 700, 10, 10);

        graph.setColor(Color.green);
        for(int i=0;i<12;i++)
        graph.fillRect(81+(i*54),(600-Math.round(Values1[i]/2)-Math.round(Values2[i]/2)-Math.round(Values3[i]/2)),44,Math.round(Values3[i]/2));

        graph.fillRect(500, 700, 10, 10);

        graph.setColor(Color.black);

        String Title="Ventas del año - en miles";
        String Place[]={"Sucursal 1","Sucursal 2","Sucursal 3"};
        String Months[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        graph.setFont(new Font("Arial", Font.PLAIN,20));
        graph.drawString(Title, 290, 110);

        graph.setFont(new Font("Arial", Font.PLAIN,16));
        graph.drawString(Place[0], 220, 710);
        graph.drawString(Place[1], 370, 710);
        graph.drawString(Place[2], 520, 710);

        for(int i=0;i<12;i++)
        graph.drawString(Integer.toString(Values1[i]),89+(i*54), (600-Math.round(Values1[i]/4)));
        
        for(int i=0;i<12;i++)
        graph.drawString(Integer.toString(Values2[i]),89+(i*54), (600-Math.round(Values1[i]/2)-Math.round(Values2[i]/4)));

        for(int i=0;i<12;i++)
        graph.drawString(Integer.toString(Values3[i]),89+(i*54), (600-Math.round(Values1[i]/2)-Math.round(Values2[i]/2)-Math.round(Values3[i]/4)));
        
        AffineTransform old=g2d.getTransform();
        
        g2d.rotate(Math.toRadians(310));
        for(int i=0;i<12;i++){
            g2d.drawString(Months[i],-395+(i*36)-(Months[i].length()*11), 470+(i*41));
        }
        g2d.setTransform(old);
    }

    public static void main (String args[])
    {
        Window21 app=new Window21();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        }); 
    }
}