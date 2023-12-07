import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;

public class Window10 extends JFrame implements ActionListener{

    private JTextField textFieldScreen;
    private JButton buttonAC, buttonDeleteLast;
    private JButton buttonAdd, buttonSubstract, buttonMultiply, buttonDivision, buttonPoint, buttonResult, buttonPorcent, buttonPotential, buttonPi;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JMenuBar menuBar;
    private JMenu menu,menu2;
    private JMenuItem menuItemOut ,menuItemBlue ,menuItemRed, menuItemBlack, menuItemWhite;

    String texto="";

    public Window10(){
        
        Font fontTextField= new Font("Bahnschrift Condensed", 1, 32);
        Font fontButtons= new Font("Arial", 1, 28);
        Color fonrColorTextField= new Color(255,255,255);
        Color colorButtons=new Color(160,221,249);

        setLayout(null);

        menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        menu=new JMenu("Opciones");
        menuBar.add(menu);

        menu2=new  JMenu("Color");
        menuBar.add(menu2);

        menuItemOut= new JMenuItem("Salir");
        menuItemOut.addActionListener(this);
        menu.add(menuItemOut);

        menuItemBlue= new JMenuItem("Azul");
        menuItemBlue.addActionListener(this);
        menu2.add(menuItemBlue);

        menuItemRed= new JMenuItem("Rojo");
        menuItemRed.addActionListener(this);
        menu2.add(menuItemRed);

        menuItemWhite= new JMenuItem("Blanco");
        menuItemWhite.addActionListener(this);
        menu2.add(menuItemWhite);

        menuItemBlack= new JMenuItem("Negro");
        menuItemBlack.addActionListener(this);
        menu2.add(menuItemBlack);

        textFieldScreen=new JTextField();
        textFieldScreen.setBounds(5, 5, 350, 50);
        textFieldScreen.setFont(fontTextField);
        textFieldScreen.setEditable(false);
        textFieldScreen.setForeground(fonrColorTextField);
        textFieldScreen.setBackground(new Color(37,88,138));
        textFieldScreen.setHorizontalAlignment(4);
        add(textFieldScreen);

        buttonAC= new JButton("AC");
        buttonAC.setFont(new Font("Arial",1,16));
        buttonAC.setBounds(10, 70, 60, 50);
        buttonAC.setBackground(new Color(255,0,0));
        buttonAC.setForeground(fonrColorTextField);
        add(buttonAC);
        buttonAC.addActionListener(this);

        buttonDeleteLast= new JButton("<x");
        buttonDeleteLast.setFont(new Font("Arial",1,16));
        buttonDeleteLast.setBounds(80, 70, 60, 50);
        buttonDeleteLast.setBackground(colorButtons);
        add(buttonDeleteLast);
        buttonDeleteLast.addActionListener(this);
        
        buttonPi= new JButton("π");
        buttonPi.setFont(fontButtons);
        buttonPi.setBounds(290, 70, 60, 50);
        buttonPi.setBackground(colorButtons);
        add(buttonPi);
        buttonPi.addActionListener(this);

        buttonDivision= new JButton("/");
        buttonDivision.setFont(fontButtons);
        buttonDivision.setBounds(220, 70, 60, 50);
        buttonDivision.setBackground(colorButtons);
        add(buttonDivision);
        buttonDivision.addActionListener(this);

        buttonPotential= new JButton("^");
        buttonPotential.setFont(fontButtons);
        buttonPotential.setBounds(150, 70, 60, 50);
        buttonPotential.setBackground(colorButtons);
        add(buttonPotential);
        buttonPotential.addActionListener(this);

        buttonPorcent= new JButton("%");
        buttonPorcent.setFont(fontButtons);
        buttonPorcent.setBounds(290, 140, 60, 50);
        buttonPorcent.setBackground(colorButtons);
        add(buttonPorcent);
        buttonPorcent.addActionListener(this);
        
        buttonMultiply= new JButton("x");
        buttonMultiply.setFont(fontButtons);
        buttonMultiply.setBounds(220, 140, 60, 50);
        buttonMultiply.setBackground(colorButtons);
        add(buttonMultiply);
        buttonMultiply.addActionListener(this);

        button9= new JButton("9");
        button9.setFont(fontButtons);
        button9.setBounds(150, 140, 60, 50);
        button9.setBackground(colorButtons);
        add(button9);
        button9.addActionListener(this);

        button8= new JButton("8");
        button8.setFont(fontButtons);
        button8.setBounds(80, 140, 60, 50);
        button8.setBackground(colorButtons);
        add(button8);
        button8.addActionListener(this);

        button7= new JButton("7");
        button7.setFont(fontButtons);
        button7.setBounds(10, 140, 60, 50);
        button7.setBackground(colorButtons);
        add(button7);
        button7.addActionListener(this);

        buttonSubstract= new JButton("-");
        buttonSubstract.setFont(fontButtons);
        buttonSubstract.setBounds(220, 210, 60, 50);
        buttonSubstract.setBackground(colorButtons);
        add(buttonSubstract);
        buttonSubstract.addActionListener(this);

        button6= new JButton("6");
        button6.setFont(fontButtons);
        button6.setBounds(150, 210, 60, 50);
        button6.setBackground(colorButtons);
        add(button6);
        button6.addActionListener(this);

        button5= new JButton("5");
        button5.setFont(fontButtons);
        button5.setBounds(80, 210, 60, 50);
        button5.setBackground(colorButtons);
        add(button5);
        button5.addActionListener(this);

        button4= new JButton("4");
        button4.setFont(fontButtons);
        button4.setBounds(10, 210, 60, 50);
        button4.setBackground(colorButtons);
        add(button4);
        button4.addActionListener(this);

        buttonAdd= new JButton("+");
        buttonAdd.setFont(fontButtons);
        buttonAdd.setBounds(220, 280, 60, 120);
        buttonAdd.setBackground(colorButtons);
        add(buttonAdd);
        buttonAdd.addActionListener(this);

        button3= new JButton("3");
        button3.setFont(fontButtons);
        button3.setBounds(150, 280, 60, 50);
        button3.setBackground(colorButtons);
        add(button3);
        button3.addActionListener(this);

        button2= new JButton("2");
        button2.setFont(fontButtons);
        button2.setBounds(80, 280, 60, 50);
        button2.setBackground(colorButtons);
        add(button2);
        button2.addActionListener(this);

        button1= new JButton("1");
        button1.setFont(fontButtons);
        button1.setBounds(10, 280, 60, 50);
        button1.setBackground(colorButtons);
        add(button1);
        button1.addActionListener(this);

        buttonResult= new JButton("=");
        buttonResult.setFont(fontButtons);
        buttonResult.setBounds(150, 350, 60, 50);
        buttonResult.setBackground(colorButtons);
        add(buttonResult);
        buttonResult.addActionListener(this);

        buttonPoint= new JButton(".");
        buttonPoint.setFont(fontButtons);
        buttonPoint.setBounds(80, 350, 60, 50);
        buttonPoint.setBackground(colorButtons);
        add(buttonPoint);
        buttonPoint.addActionListener(this);

        button0= new JButton("0");
        button0.setFont(fontButtons);
        button0.setBounds(10, 350, 60, 50);
        button0.setBackground(colorButtons);
        add(button0);
        button0.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonAC){
            textFieldScreen.setText("");
        }

        if(e.getSource()==buttonDeleteLast){
            int lastToDelete=textFieldScreen.getText().length();
            textFieldScreen.setText(textFieldScreen.getText().substring(0, lastToDelete-1));
        }

        if(e.getSource()==buttonPotential){
            textFieldScreen.setText(textFieldScreen.getText()+"^");
        }

        if(e.getSource()==buttonPi){
            textFieldScreen.setText(textFieldScreen.getText()+"3.1416");
        }

        if(e.getSource()==buttonPorcent){
            textFieldScreen.setText(textFieldScreen.getText()+"%");
        }
        //π
        if(e.getSource()==buttonAdd){
            textFieldScreen.setText(textFieldScreen.getText()+"+");
        }

        if(e.getSource()==buttonSubstract){
            textFieldScreen.setText(textFieldScreen.getText()+"-");
        }

        if(e.getSource()==buttonMultiply){
            textFieldScreen.setText(textFieldScreen.getText()+"*");
        }

        if(e.getSource()==buttonPoint){
            textFieldScreen.setText(textFieldScreen.getText()+".");
        }

        if(e.getSource()==buttonDivision){
            textFieldScreen.setText(textFieldScreen.getText()+"/");
        }

        if(e.getSource()==button9){
            textFieldScreen.setText(textFieldScreen.getText()+"9");
        }

        if(e.getSource()==button8){
            textFieldScreen.setText(textFieldScreen.getText()+"8");
        }

        if(e.getSource()==button7){
            textFieldScreen.setText(textFieldScreen.getText()+"7");
        }

        if(e.getSource()==button6){
            textFieldScreen.setText(textFieldScreen.getText()+"6");
        }

        if(e.getSource()==button5){
            textFieldScreen.setText(textFieldScreen.getText()+"5");
        }

        if(e.getSource()==button4){
            textFieldScreen.setText(textFieldScreen.getText()+"4");
        }

        if(e.getSource()==button3){
            textFieldScreen.setText(textFieldScreen.getText()+"3");
        }

        if(e.getSource()==button2){
            textFieldScreen.setText(textFieldScreen.getText()+"2");
        }

        if(e.getSource()==button1){
            textFieldScreen.setText(textFieldScreen.getText()+"1");
        }

        if(e.getSource()==button0){
            textFieldScreen.setText(textFieldScreen.getText()+"0");
        }

        if(e.getSource()==buttonResult){
            textFieldScreen.setText(Operations(textFieldScreen.getText()));
        }

        if(e.getSource()==menuItemBlack){
            getContentPane().setBackground(new Color(0,0,0));
        }

        if(e.getSource()==menuItemBlue){
            getContentPane().setBackground(new Color(0,0,255));
        }

        if(e.getSource()==menuItemRed){
            getContentPane().setBackground(new Color(200,0,0));
        }

        if(e.getSource()==menuItemWhite){
            getContentPane().setBackground(new Color(255,255,255));
        }

        if(e.getSource()==menuItemOut){
            int respuesta=JOptionPane.showConfirmDialog
            (this,"¿Desea salir de la aplicacion?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(respuesta==JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }  

    public String Operations(String operations){
        String finalResult="",operationOption="";
        float value1=0f,value2=0f;
        char operator;
        int operationSize=operations.length();
        for(int i=0;i<operationSize;i++){
            
            operator=operations.charAt(i);

            if((operator=='+' || operator=='-' || operator=='*' || operator=='/' || operator=='%' || operator=='^') && i!=0){
                value1=Float.parseFloat(operations.substring(0, i));
                value2=Float.parseFloat(operations.substring(i+1, operationSize));
                operationOption=operations.substring(i, i+1);
                break;
            }
        }
         switch(operationOption){
            case "+":{finalResult=Float.toString(value1+value2);break;}
            case "-":{finalResult=Float.toString(value1-value2);break;}
            case "*":{finalResult=Float.toString(value1*value2);break;}
            case "/":{finalResult=Float.toString(value1/value2);break;}
            case "%":{finalResult=Float.toString(value1*value2/100);break;}
            case "^":{finalResult=Double.toString(Math.pow(value1,value2));break;}
            default:finalResult="Syntax Error";
         }

        return finalResult;
    }

    public static void main(String args[]){
        Window10 basicCalculator=new Window10();
        basicCalculator.setBounds(0,0,375,470);
        basicCalculator.setVisible(true);
        basicCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        basicCalculator.setResizable(false);
        basicCalculator.setLocationRelativeTo(null);
        basicCalculator.getContentPane().setBackground(new Color(0,0,0));
    }
}