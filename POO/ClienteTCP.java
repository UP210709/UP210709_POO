import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class ClienteTCP extends Frame implements ActionListener {

    Panel panel;
    Socket conexion;
    TextField textsal, textent, puertoField;
    Button enviar, conectar, desconectar;
    DataOutputStream salida;
    DataInputStream entrada;

    ClienteTCP(String nombre) {
        super(nombre);
        setSize(350, 200);
        panel = new Panel();
        textent = new TextField(40);
        textsal = new TextField(40); // Corregido: Usar textsal en lugar de textent
        puertoField = new TextField(5);
        panel.add(new Label("Puerto del servidor"));
        panel.add(puertoField);
        textent.setText("Pulsa el botón \"Conectar\" para conectarte");
        textent.setEditable(false);
        enviar = new Button("Enviar");
        enviar.setEnabled(false);
        conectar = new Button("Conectar");
        desconectar = new Button("Desconectar");
        desconectar.setEnabled(false);
        panel.add(new Label("Datos a enviar"));
        panel.add(textsal);
        panel.add(new Label("Datos recibidos"));
        panel.add(textent);
        panel.add(enviar);
        panel.add(conectar);
        panel.add(desconectar);
        enviar.addActionListener(this);
        conectar.addActionListener(this);
        desconectar.addActionListener(this);
        addWindowListener(new Cerrar());
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();

        if (com.equals("Conectar")) {
            try {
                String host = "localhost";
                int puerto = Integer.parseInt(puertoField.getText());
                conexion = new Socket(host, puerto);
                salida = new DataOutputStream(conexion.getOutputStream());
                entrada = new DataInputStream(conexion.getInputStream());

                conectar.setEnabled(false);
                desconectar.setEnabled(true);
                enviar.setEnabled(true);
                textent.setText("Conectado al servidor");
            } catch (IOException exception) {
                textent.setText("Error al conectar con el servidor");
            }
        } else if (com.equals("Enviar")) {
            try {
                String mensajeEnviado = textsal.getText();
                salida.writeUTF(mensajeEnviado);
                textent.setText("Mensaje enviado: " + mensajeEnviado);

                String mensajeRecibido = entrada.readUTF();
                textent.setText(textent.getText() + "\nMensaje recibido: " + mensajeRecibido);
            } catch (IOException exception) {
                textent.setText("Error al enviar o recibir mensajes");
            }
        } else if (com.equals("Desconectar")) {
            try {
                salida.writeUTF("Salir");
                conexion.close();
                conectar.setEnabled(true);
                desconectar.setEnabled(false);
                enviar.setEnabled(false);
                textent.setText("Pulsa el botón \"Conectar\" para conectarte");
            } catch (IOException exception) {
                textent.setText("Error al desconectar del servidor");
            }
        }
    }

    class Cerrar extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            dispose();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ClienteTCP("Cliente Angel");
        new ClienteTCP("Cliente Pepe");
    }
}
