import java.awt.Color;
import javax.swing.JFrame;

public class Window1 extends JFrame{
    public static void main(String args[]){

        Window1 firstWindow=new Window1();
        firstWindow.setBounds(0, 0, 450, 450);
        firstWindow.setVisible(true);
        firstWindow.setResizable(false);
        firstWindow.setLocationRelativeTo(null);
        firstWindow.setTitle("First Window");
        firstWindow.getContentPane().setBackground(new Color(55,88,165));
    }
}