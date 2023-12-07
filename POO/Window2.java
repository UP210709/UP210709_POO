import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
public class Window2 extends JFrame{

    public Window2(){

        setBounds(0, 0, 450,450);
        setVisible(true);
        setResizable(true);

        setLocationRelativeTo(null);

        setTitle("My first Window");
        getContentPane().setBackground(new Color(0,0,0));

        setIconImage(new ImageIcon(getClass().getResource("Images/pngegg.png")).getImage());
    }
    public static void main(String args[]){
        Window2 firstWindow=new Window2();
    }
}