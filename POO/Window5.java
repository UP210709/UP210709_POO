import javax.swing.*;
import java.awt.event.*;

public class Window5 extends JFrame implements ActionListener{
    private JTextField textField1;
    private JLabel label1;
    private JButton buttonAddText, buttonCloseWindow;

    public Window5(){

        setLayout(null);
        label1=new JLabel("Usuario");
        label1.setBounds(10, 10, 100, 30);
        add(label1);

        textField1=new JTextField();
        textField1.setBounds(120, 17, 150, 20);
        add(textField1);
        
        buttonAddText=new JButton("Aceptar");
        buttonAddText.setBounds(10, 70, 100, 30);
        add(buttonAddText);
        buttonAddText.addActionListener(this);

        buttonCloseWindow=new JButton("Salir");
        buttonCloseWindow.setBounds(180, 70, 100, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonAddText){
            String texto=textField1.getText();
            setTitle(texto);
        }

        if(e.getSource()==buttonCloseWindow){
            label1.setText("Has presionado salir");
            int respuesta=JOptionPane.showConfirmDialog
            (this,"¿Desea salir de la aplicacion?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }

    public static void main(String args[]){
        Window5 window=new Window5();
        window.setBounds(0, 0, 300, 150);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
}
