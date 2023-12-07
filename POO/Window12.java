import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Window12 extends JFrame implements ActionListener{

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemOut ,menuItemRestart,menuItemAbout;
    private JButton[][] buttons;
    private char currentPlayer;
    private JLabel statusLabel;
    public Color fontColorButton=new Color(255,255,255);
    public Color fontColorButtonWin=new Color(255,0,0);
    public String match;

    public Window12(){

        menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        menu=new JMenu("Opciones");
        menuBar.add(menu);

        menuItemRestart= new JMenuItem("Reiniciar");
        menuItemRestart.addActionListener(this);
        menu.add(menuItemRestart);

        menuItemOut= new JMenuItem("Salir");
        menuItemOut.addActionListener(this);
        menu.add(menuItemOut);

        menuItemAbout= new JMenuItem("Acerca de:");
        menuItemAbout.addActionListener(this);
        menu.add(menuItemAbout);

        setLayout(null);

        Color fontColorButton=new Color(255,255,255);

        buttons=new JButton[7][7];
        currentPlayer='X';

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        statusLabel=new JLabel("Turno del jugador "+currentPlayer);
        statusLabel.setBounds(5, 5, 760, 20);
        statusLabel.setFont(new Font("Arial",Font.PLAIN,18));
        statusLabel.setForeground(fontColorButton);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        add(statusLabel);

        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                buttons[i][j]=new JButton("");
                buttons[i][j].setBounds((i*105)+10, (j*105)+30, 100, 100);
                buttons[i][j].setFont(new Font("Arial",Font.BOLD,48));
                buttons[i][j].setForeground(fontColorButton);
                buttons[i][j].setBackground(new Color(50,50,50));
                buttons[i][j].setEnabled(false);
                if(j==0){
                    buttons[i][j].setEnabled(true);
                    buttons[i][j].addActionListener(this);
                }
                add(buttons[i][j]);
            }
        }
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==menuItemOut){
            int respuesta=JOptionPane.showConfirmDialog
            (this,"¿Desea salir de la aplicacion?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }

        if(e.getSource()==menuItemRestart){
            for(int i=0;i<7;i++){
                for(int j=0;j<7;j++){
                    buttons[i][j].setText("");
                    buttons[i][j].setFont(new Font("Arial",Font.BOLD,48));
                    buttons[i][j].setForeground(fontColorButton);
                    buttons[i][j].setBackground(new Color(50,50,50));
                    buttons[i][j].setEnabled(false);
                    if(j==0){
                        buttons[i][j].setEnabled(true);
                    }
                }
            }
            currentPlayer='X';
            statusLabel.setText("Turno del jugador "+currentPlayer);
            return;
        }

        if(e.getSource()==menuItemAbout){
            JOptionPane.showMessageDialog(null,"Elaborado por: \nAarón Quiñones Martínez\nCarolina Magdiel Moran Requenes");
            return;
        }

        JButton buttonClicked=(JButton) e.getSource();
        int positionX=(buttonClicked.getX()-10)/105;
        int positionY=0;

        if(!buttons[positionX][(positionY+1)%7].getText().equals("")){
            return;
        }

        while(positionY<=6){
            if(!buttons[positionX][(positionY+1)%7].getText().equals("")||positionY==6){
                if(currentPlayer=='X'){
                    buttons[positionX][positionY].setText(String.valueOf(currentPlayer));
                    buttons[positionX][positionY].setBackground(new Color(0,0,255));
                    break;
                } else{
                    buttons[positionX][positionY].setText(String.valueOf(currentPlayer));
                    buttons[positionX][positionY].setBackground(new Color(255,0,0));
                    break;
                }
                
            };
            positionY+=1;
        }


        if(checkWin()){
            statusLabel.setText("Jugador "+currentPlayer+" gana!");
            disableButtons();
        } else if(isBoardFull()){

            statusLabel.setText("¡Empate!");
            for (int i=0;i<7;i++){
                for(int j=0;j<7;j++){
                    buttons[i][j].setBackground(new Color(255,255,255));
                }
            }

        } else{
            currentPlayer=(currentPlayer=='X')?'O':'X';
            statusLabel.setText("Turno del jugador "+currentPlayer);
        }
    }

    private boolean checkWin(){
        for(int i=0;i<4;i++){
            for(int j=1;j<=3;j++){
                String player=buttons[i][j].getText();
                if((buttons[i][j].getText().equals(buttons[i+1][j+1].getText())&&buttons[i+1][j+1].getText().equals(buttons[i+2][j+2].getText()))
                &&buttons[i+2][j+2].getText().equals(buttons[i+3][j+3].getText())&&player!="O"){
                    return true;
                }
            }
        }

        for(int i=6;i>=3;i--){
            for(int j=1;j<=3;j++){
                String player=buttons[i][j].getText();
                if((buttons[i][j].getText().equals(buttons[i-1][j+1].getText())&&buttons[i-1][j+1].getText().equals(buttons[i-2][j+2].getText()))
                &&buttons[i-2][j+2].getText().equals(buttons[i-3][j+3].getText())&&player!=""){
                    return true;
                }
            }
        }

        // Comprueba en horizontal
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                if (!buttons[i][j].getText().equals("") &&
                    buttons[i][j].getText().equals(buttons[i][j + 1].getText()) &&
                    buttons[i][j].getText().equals(buttons[i][j + 2].getText()) &&
                    buttons[i][j].getText().equals(buttons[i][j + 3].getText())) {
                    statusLabel.setText("Jugador " + currentPlayer + " gana!");
                    return true;
                }
            }
        }

        // Comprueba en vertical
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (!buttons[i][j].getText().equals("") &&
                        buttons[i][j].getText().equals(buttons[i + 1][j].getText()) &&
                        buttons[i][j].getText().equals(buttons[i + 2][j].getText()) &&
                        buttons[i][j].getText().equals(buttons[i + 3][j].getText())) {
                    statusLabel.setText("Jugador " + currentPlayer + " gana!");
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isBoardFull(){
        for (int i=0;i<7;i++){
            for(int j=1;j<6;j++){
                if(buttons[i][j].getText().equals("")){
                    return false;
                }
            }
        }
        return true;
    }

    private void disableButtons(){
        for(int i=0;i<7;i++){
            buttons[i][0].setEnabled(false);
        }
    }

    public static void main(String arg[]){
        Window12 connect4=new Window12();
        connect4.setBounds(0, 0, 765, 835);
        connect4.setVisible(true);
        connect4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        connect4.setResizable(false);
        connect4.setTitle("Connect 4");
        connect4.setLocationRelativeTo(null);
        connect4.getContentPane().setBackground(new Color(0, 0, 0));
    }
}