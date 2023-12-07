import javax.swing.*;
import java.awt.event.*;

public class Window7 extends JFrame implements ActionListener{
    private JTextField textField1;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    private JButton button1,buttonCloseWindow;

    String texto="";

    public Window7(){
        setLayout(null);
        
        textField1=new JTextField();
        textField1.setBounds(10, 10, 200, 30);
        add(textField1);
         
        textArea1=new JTextArea();
        scrollPane1=new JScrollPane(textArea1);
        scrollPane1.setBounds(10, 50, 310, 300);
        add(scrollPane1);

        buttonCloseWindow=new JButton("Salir");
        buttonCloseWindow.setBounds(220, 365, 100, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);

        button1=new JButton("Agregar");
        button1.setBounds(220, 10, 100, 30);
        add(button1);
        button1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            texto+=textField1.getText()+"\n";
            textArea1.setText(texto);
            textField1.setText("");
        }

        if(e.getSource()==buttonCloseWindow){
            int respuesta=JOptionPane.showConfirmDialog
            (this,"¿Desea salir de la aplicacion?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }
    public static void main(String args[]){
        Window7 window=new Window7();
        window.setBounds(0, 0, 345, 450);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
}