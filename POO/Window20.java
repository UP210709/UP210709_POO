import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Window20 extends JFrame{

    public Window20(){
        super("Dibujando arcos");
        setSize(750, 700);
        show();
    }
    
    public void paint(Graphics graph)
    {
        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, 750, 700);

        graph.setColor(new Color(0,0,255));
        graph.fillArc(50, 100, 200, 200, 283, 167);
        graph.fillRect(270, 150, 10, 10);
        graph.setColor(new Color(255,0,0));
        graph.fillArc(50, 100, 200, 200, 90, 193);
        graph.fillRect(270, 180 , 10, 10);

        graph.setColor(new Color(0,0,255));
        graph.fillArc(400, 100, 200, 200, 32, 58);
        graph.fillRect(620, 150, 10, 10);
        graph.setColor(new Color(255,0,0));
        graph.fillArc(400, 100, 200, 200, 306, 86);
        graph.fillRect(620, 180, 10, 10);
        graph.setColor(Color.green);
        graph.fillArc(400, 100, 200, 200, 237, 69);
        graph.fillRect(620, 210, 10, 10);
        graph.setColor(Color.magenta);
        graph.fillArc(400, 100, 200, 200, 175, 62);
        graph.fillRect(620, 240, 10, 10);
        graph.setColor(Color.cyan);
        graph.fillArc(400, 100, 200, 200, 90, 86);
        graph.fillRect(620, 270, 10, 10);

        graph.setColor(Color.blue);
        graph.fillArc(400, 400, 200, 200, 3, 87);
        graph.fillRect(620, 420, 10, 10);
        graph.setColor(Color.red);
        graph.fillArc(400, 400, 200, 200, 230, 133);
        graph.fillRect(620, 450, 10, 10);        
        graph.setColor(Color.green);
        graph.fillArc(400, 400, 200, 200, 157, 73); 
        graph.fillRect(620, 480, 10, 10);
        graph.setColor(Color.magenta);
        graph.fillArc(400, 400, 200, 200, 90, 67); 
        graph.fillRect(620, 510, 10, 10);

        graph.setColor(Color.blue);
        graph.fillArc(50, 400, 200, 200, 37, 53);
        graph.fillRect(270, 420, 10, 10);
        graph.setColor(Color.red);
        graph.fillArc(50, 400, 200, 200, 277, 120);
        graph.fillRect(270, 450, 10, 10);
        graph.setColor(Color.green);
        graph.fillArc(50, 400, 200, 200, 161, 116);
        graph.fillRect(270, 480, 10, 10);
        graph.setColor(Color.magenta);
        graph.fillArc(50, 400, 200, 200, 116, 45);
        graph.fillRect(270, 510, 10, 10);
        graph.setColor(Color.cyan);
        graph.fillArc(50, 400, 200, 200, 100, 16);
        graph.fillRect(270, 540, 10, 10);
        graph.setColor(Color.ORANGE);
        graph.fillArc(50, 400, 200, 200, 90, 10);
        graph.fillRect(270, 570, 10, 10);
        
        graph.setColor(Color.black);

        graph.setFont(new Font("Arial", Font.PLAIN,20));
        String label1="Distribución por sexo",label5="Hombre",label6="Mujer";
        String label10[]={"53.59%","46.41%"};
        graph.drawString(label1, 60, 80);
        graph.setFont(new Font("Arial", Font.PLAIN,14));
        graph.drawString(label5, 285, 160);
        graph.drawString(label6, 285, 190);
        graph.drawString(label10[0], 80, 200);
        graph.drawString(label10[1], 180, 200);

        graph.setFont(new Font("Arial", Font.PLAIN,20));
        String label2="Distribución por edad",label7[]={"18-24","25-34","35-44","45-54","55+"};
        String label11[]={"16.22%","23.87%","19.09%","17.09%","23.73%"};
        graph.drawString(label2, 410, 80);
        graph.setFont(new Font("Arial", Font.PLAIN,14));
        graph.drawString(label7[0], 635, 160);
        graph.drawString(label7[1], 635, 190);
        graph.drawString(label7[2], 635, 220);
        graph.drawString(label7[3], 635, 250);
        graph.drawString(label7[4], 635, 280);
        graph.drawString(label11[0], 510, 150);
        graph.drawString(label11[1], 535, 220);
        graph.drawString(label11[2], 480, 265);
        graph.drawString(label11[3], 420, 230);
        graph.drawString(label11[4], 440, 170);

        graph.setFont(new Font("Arial", Font.PLAIN,20));
        String label3="Distribución por estrato",label8[]={"1","2","3","4","5","6"};
        String label12[]={"14.80%","33.27%","32.26%","12.43%","4.45%","2.79%"};
        graph.drawString(label3, 60, 380);
        graph.setFont(new Font("Arial", Font.PLAIN,14));
        graph.drawString(label8[0], 285, 430);
        graph.drawString(label8[1], 285, 460);
        graph.drawString(label8[2], 285, 490);
        graph.drawString(label8[3], 285, 520);
        graph.drawString(label8[4], 285, 550);
        graph.drawString(label8[5], 285, 580);
        graph.drawString(label12[0], 155, 450);
        graph.drawString(label12[1], 180, 525);
        graph.drawString(label12[2], 80, 540);
        graph.drawString(label12[3], 75, 465);
        graph.drawString(label12[4], 80, 405);
        graph.drawString(label12[5], 130, 395);
        
        graph.setFont(new Font("Arial", Font.PLAIN,20));
        String label4="Distribución por nivel educativo",label9[]={"Sin bachillerato","Bachi/Téc.inc.","Téc/Univ.inc","Univ"};
        String label13[]={"24.07%","37.01%","20.28%","18.43%"};
        graph.drawString(label4, 375, 380);
        graph.setFont(new Font("Arial", Font.PLAIN,14));
        graph.drawString(label9[0], 635, 430);
        graph.drawString(label9[1], 635, 460);
        graph.drawString(label9[2], 635, 490);
        graph.drawString(label9[3], 635, 520);
        graph.drawString(label13[0], 520, 460);
        graph.drawString(label13[1], 500, 550);
        graph.drawString(label13[2], 420, 520);
        graph.drawString(label13[3], 440, 460);

    }

    public static void main (String args[])
    {
        Window20 app=new Window20();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        }); 
    }
}
