import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Window4 extends JFrame implements ActionListener{

    private JButton button1, button2, buttonCloseWindow;
    private JLabel label1;

    public Window4(){
        setLayout(null);
        setBounds(0, 0, 450, 200);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Mi primera ventana");
        getContentPane().setBackground(new Color(0,200,240));
        setIconImage(new ImageIcon(getClass().getResource("Images/pngegg.png")).getImage());

        button1=new JButton("Boton 1");
        button1.setBounds(10, 100, 90, 30);
        add(button1);
        button1.addActionListener(this);

        button2=new JButton("Boton 2");
        button2.setBounds(110, 100, 90, 30);
        add(button2);
        button2.addActionListener(this);

        buttonCloseWindow=new JButton("Salir");
        buttonCloseWindow.setBounds(280, 100, 90, 30);
        add(buttonCloseWindow);
        buttonCloseWindow.addActionListener(this);

        label1=new JLabel("En espera...");
        label1.setBounds(10,10,300,30);
        add(label1);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            label1.setText("Has presionado el boton 1 ");
        }
        if(e.getSource()==button2){
            label1.setText("Has presionado el boton 2 ");
        }
        if(e.getSource()==buttonCloseWindow){
            label1.setText("Has presionado Salir ");
            int respuesta=JOptionPane.showConfirmDialog
            (this,"¿Desea salir de la aplicacion?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }

    public static void main(String args[]){
        Window4 firstWindow4=new Window4();
    }
}