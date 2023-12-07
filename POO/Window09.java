import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Window09 extends JFrame implements ActionListener{
    
    private static JTextField textfieldScreen;
    private JButton buttonAC, buttonDeleteLast;
    private JButton buttonAdd, buttonSubstract, buttonMultiply, buttonDivision, buttonPoint, buttonResult;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemOut;

    String texto= " ";

    public Window09(){
        Font fontTextField= new Font ("Bahnschrift Condensed", 1, 32);
        Font fontButtons =new Font ("Arial", 1, 28);
        Color fontColorTextField= new Color (255,255,255);
        Color colorbuttons= new Color (160,221,249);

        setLayout(null);
        //setIconImage(new ImageIcon(getClass().getResource("E:/POO_2023_CMMR/images/R.png")).getImage());

        menuBar= new JMenuBar();
        setJMenuBar(menuBar);

        menu=new JMenu("Opciones");
        menuBar.add(menu);
        menuItemOut=new JMenuItem("Salir");
        menuItemOut.addActionListener(this);
        menu.add(menuItemOut);

        textfieldScreen=new JTextField();
        textfieldScreen.setBounds(5,5,280,50);
        textfieldScreen.setFont(fontTextField);
        textfieldScreen.setForeground(fontColorTextField);
        textfieldScreen.setBackground(new Color(37,88,138));
        textfieldScreen.setHorizontalAlignment(4);
        add(textfieldScreen);

        buttonAC= new JButton("AC");
        buttonAC.setFont(new Font("Arial", 1, 16));
        buttonAC.setBounds(10,70,60,50);
        buttonAC.setBackground(new Color(255,0,0));
        buttonAC.setForeground(fontColorTextField);
        add(buttonAC);
        buttonAC.addActionListener(this);

        buttonDeleteLast= new JButton("<x");
        buttonDeleteLast.setFont(new Font("Arial", 1, 16));
        buttonDeleteLast.setBounds(80,70,60,50);
        buttonDeleteLast.setBackground(new Color(255,0,0));
        buttonDeleteLast.setForeground(fontColorTextField);
        add(buttonDeleteLast);
        buttonDeleteLast.addActionListener(this);

        button9= new JButton("9");
        button9.setFont(fontButtons);
        button9.setBounds(150,140,60,50);
        button9.setBackground(colorbuttons);
        add(button9);
        button9.addActionListener(this);

        button8= new JButton("8");
        button8.setFont(fontButtons);
        button8.setBounds(80,140,60,50);
        button8.setBackground(colorbuttons);
        add(button8);
        button8.addActionListener(this);

        button7= new JButton("7");
        button7.setFont(fontButtons);
        button7.setBounds(10,140,60,50);
        button7.setBackground(colorbuttons);
        add(button7);
        button7.addActionListener(this);

        button6= new JButton("6");
        button6.setFont(fontButtons);
        button6.setBounds(150,210,60,50);
        button6.setBackground(colorbuttons);
        add(button6);
        button6.addActionListener(this);

        button5= new JButton("5");
        button5.setFont(fontButtons);
        button5.setBounds(80,210,60,50);
        button5.setBackground(colorbuttons);
        add(button5);
        button5.addActionListener(this);

        button4= new JButton("4");
        button4.setFont(fontButtons);
        button4.setBounds(10,210,60,50);
        button4.setBackground(colorbuttons);
        add(button4);
        button4.addActionListener(this);

        button3= new JButton("3");
        button3.setFont(fontButtons);
        button3.setBounds(150,280,60,50);
        button3.setBackground(colorbuttons);
        add(button3);
        button3.addActionListener(this);

        button2= new JButton("2");
        button2.setFont(fontButtons);
        button2.setBounds(80,280,60,50);
        button2.setBackground(colorbuttons);
        add(button2);
        button2.addActionListener(this);
        
        button1= new JButton("1");
        button1.setFont(fontButtons);
        button1.setBounds(10,280,60,50);
        button1.setBackground(colorbuttons);
        add(button1);
        button1.addActionListener(this);

        buttonResult= new JButton("=");
        buttonResult.setFont(fontButtons);
        buttonResult.setBounds(150,350,60,50);
        buttonResult.setBackground(colorbuttons);
        add(buttonResult);
        buttonResult.addActionListener(this);

        buttonPoint= new JButton(".");
        buttonPoint.setFont(fontButtons);
        buttonPoint.setBounds(80,350,60,50);
        buttonPoint.setBackground(colorbuttons);
        add(buttonPoint);
        buttonPoint.addActionListener(this);

        button0= new JButton("0");
        button0.setFont(fontButtons);
        button0.setBounds(10,350,60,50);
        button0.setBackground(colorbuttons);
        add(button0);
        button0.addActionListener(this);

        buttonMultiply= new JButton("x");
        buttonMultiply.setFont(fontButtons);
        buttonMultiply.setBounds(220,140,60,50);
        buttonMultiply.setBackground(colorbuttons);
        add(buttonMultiply);
        buttonMultiply.addActionListener(this);

        buttonSubstract= new JButton("-");
        buttonSubstract.setFont(fontButtons);
        buttonSubstract.setBounds(220,210,60,50);
        buttonSubstract.setBackground(colorbuttons);
        add(buttonSubstract);
        buttonSubstract.addActionListener(this);

        buttonAdd= new JButton("+");
        buttonAdd.setFont(fontButtons);
        buttonAdd.setBounds(220,280,60,50);
        buttonAdd.setBackground(colorbuttons);
        add(buttonAdd);
        buttonAdd.addActionListener(this);

        buttonDivision= new JButton("/");
        buttonDivision.setFont(fontButtons);
        buttonDivision.setBounds(220,350,60,50);
        buttonDivision.setBackground(colorbuttons);
        add(buttonDivision);
        buttonDivision.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonAC){
            textfieldScreen.setText(" ");
        }
        if (e.getSource()==buttonDeleteLast){
            int lastToDelete=textfieldScreen.getText().length();
            textfieldScreen.setText(textfieldScreen.getText().substring(0,lastToDelete));
        }
        if(e.getSource()==buttonAdd){
            textfieldScreen.setText(textfieldScreen.getText() + "+");
        }
        if(e.getSource()==buttonSubstract){
            textfieldScreen.setText(textfieldScreen.getText() + "-");
        }
        if(e.getSource()==buttonMultiply){
            textfieldScreen.setText(textfieldScreen.getText() + "*");
        }
        if(e.getSource()==buttonDivision){
            textfieldScreen.setText(textfieldScreen.getText() + "/");
        }
        if(e.getSource()==buttonPoint){
            textfieldScreen.setText(textfieldScreen.getText() + ".");
        }
        if(e.getSource()==button0){
            textfieldScreen.setText(textfieldScreen.getText() + "0");
        }
        if(e.getSource()==button1){
            textfieldScreen.setText(textfieldScreen.getText() + "1");
        }
        if(e.getSource()==button2){
            textfieldScreen.setText(textfieldScreen.getText() + "2");
        }
        if(e.getSource()==button3){
            textfieldScreen.setText(textfieldScreen.getText() + "3");
        }
        if(e.getSource()==button4){
            textfieldScreen.setText(textfieldScreen.getText() + "4");
        }
        if(e.getSource()==button5){
            textfieldScreen.setText(textfieldScreen.getText() + "5");
        }
        if(e.getSource()==button6){
            textfieldScreen.setText(textfieldScreen.getText() + "6");
        }
        if(e.getSource()==button7){
            textfieldScreen.setText(textfieldScreen.getText() + "7");
        }
        if(e.getSource()==button8){
            textfieldScreen.setText(textfieldScreen.getText() + "8");
        }
        if(e.getSource()==button9){
            textfieldScreen.setText(textfieldScreen.getText() + "9");
        }
        if(e.getSource()==buttonResult){
             textfieldScreen.setText(Operations(textfieldScreen.getText()) );
  
        }
        if(e.getSource()==menuItemOut){
            int answer=JOptionPane.showConfirmDialog(this,"¿Desea salir de la aplicación?","confirmar salida", JOptionPane.YES_NO_OPTION);
            if(answer==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }

    public static String Operations (String operations){
        String finalResult=" ", operatorOption=" ";
        float value1=0f, value2=0f;
        char operator;
        int operationSize= operations.length();
        for (int i=0; i<operationSize; i++){
            operator= operations.charAt(i);
            if(operator=='+'|| operator=='-'||operator=='*'|| operator=='/')
            {
                value1=Float.parseFloat(operations.substring(0, i));
                value2=Float.parseFloat(operations.substring(i+1, operationSize));
                operatorOption= operations.substring(i, i+1);
                break;
            }
        }
        switch(operatorOption){
        case "+":{finalResult=Float.toString(value1+value2);break;}
        case "-":{finalResult=Float.toString(value1-value2);break;}
        case "*":{finalResult=Float.toString(value1*value2);break;}
        case "/":{finalResult=Float.toString(value1/value2);break;}
        
        default:finalResult="error";
        }
        return finalResult;
    }

    public static void main(String args[]){
        Window09 basicCalculator= new Window09();
        basicCalculator.setBounds(0,0,305,470);
        basicCalculator.setVisible(true);
        basicCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        basicCalculator.setResizable(false);
        basicCalculator.setLocationRelativeTo(null);
        basicCalculator.getContentPane().setBackground(new Color (0,0,0));
    }
}
