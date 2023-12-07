import javax.swing.*;
import java.awt.event.*;

public class Window6 extends JFrame implements ActionListener{
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton buttonCloseWindow;

    public Window6(){
         setLayout(null);
         
         textField1=new JTextField();
         textField1.setBounds(10, 10, 200, 30);
         add(textField1);

         textArea1=new JTextArea();
         textArea1.setBounds(10, 50, 300, 300);
         add(textArea1);

         buttonCloseWindow=new JButton("Salir");
        buttonCloseWindow.setBounds(200, 365, 100, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonCloseWindow){
            int respuesta=JOptionPane.showConfirmDialog
            (this,"¿Desea salir de la aplicacion?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }
    public static void main(String args[]){
        Window6 window=new Window6();
        window.setBounds(0, 0, 335, 450);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
}
