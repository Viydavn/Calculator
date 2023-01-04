import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton [] numberButtons = new JButton[10];
    JButton [] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton,equButton,decButton, delButton, clrButton,negButton;
    JPanel panel;

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setEditable(false);
        textfield.setBackground(Color.lightGray);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        clrButton = new JButton("clr");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = clrButton;
        functionButtons[5] = decButton;
        functionButtons[6] = equButton;
        functionButtons[7] = delButton;
        functionButtons[8] = negButton;

        functionButtons[0] = addButton;

        for(int i = 0;i<9;i++) {
            functionButtons[i].addActionListener(this);

        }

        for(int i = 0;i<10;i++) {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);

        }

        delButton.setBounds(50,410,90,50);
        clrButton.setBounds(155,410,90,50);
        negButton.setBounds(260,410,90,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(mulButton);



        panel.add(functionButtons[2]);



        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textfield);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    public static void main(String[] args) {
        Calculator Cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i<10;i++) {
            if(e.getSource()== numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource()== addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource()== subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource()== mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource()== divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()== equButton) {
            num2 = Double.parseDouble(textfield.getText());
            switch(operator) {
                case '+': result = num1+num2;
                    break;
                case '-': result = num1-num2;
                    break;
                case '*': result = num1*num2;
                    break;
                case '/': result = num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()== clrButton) {
            textfield.setText("");
        }
        if(e.getSource()== delButton) {
            String temp = textfield.getText();
            textfield.setText("");
            String temp2 = "";
            for(int i =0;i<temp.length()-1;i++) {
                temp2 = temp2+temp.charAt(i);
            }
            textfield.setText(temp2);
        }
        if(e.getSource()== negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp = -1 * temp;
            textfield.setText(String.valueOf(temp));

        }

    }
}
