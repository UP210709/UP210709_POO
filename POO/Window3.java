import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window3 extends JFrame implements ActionListener{
    private JButton buttonCloseWindow;

    public Window3(){
        setBounds(0, 0, 450, 450);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Mi primera ventana");
        getContentPane().setBackground(new Color(0,0,0));

        setIconImage(new ImageIcon(getClass().getResource("Images/pngegg.png")).getImage());

        buttonCloseWindow=new JButton("Cerrar");
        buttonCloseWindow.setBounds(123,280,100,30);
        buttonCloseWindow.setBackground(new Color(0,0,0));
        buttonCloseWindow.setFont(new Font("Andale Mono",1,14));
        buttonCloseWindow.setForeground(new Color(255,255,255));
        buttonCloseWindow.addActionListener(this);
        add(buttonCloseWindow);    
    }

    public static void main(String args[]){
        Window3 firstWindow=new Window3();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonCloseWindow){
            int respuesta=JOptionPane.showConfirmDialog
            (this,"¿Desea salir de la aplicacion?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }
}