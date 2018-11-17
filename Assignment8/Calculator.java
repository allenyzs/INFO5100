import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
    boolean fNum = true;
    String operator = "=";
    JTextField textField;
    double res = 0;
    JPanel cur;

    public Calculator(){
        super("Calculator");
        setLayout(new BorderLayout());
        textField = new JTextField(10);
        cur = new JPanel(new GridLayout(5, 5));

        String[] name= {"7","8","9","+","4","5","6","-","1","2","3","*","0","C","=","/"};
        for(int i = 0; i < 16; i++){
            JButton button = new JButton(name[i]);
            button.addActionListener(new ButtonListener());
            cur.add(button);
        }

        getContentPane().add(BorderLayout.NORTH, textField);
        getContentPane().add(BorderLayout.CENTER, cur);

        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            if(action.equals("C")){
                textField.setText("0");
                operator = "=";
                fNum = true;
            } else if("1234567890".contains(action)){
                if (!fNum) {
                    textField.setText(textField.getText() + action);
                } else {
                    textField.setText(action);
                }
                fNum = false;
            } else{
                operation(action);
            }
        }

        public void operation(String action){
            if(operator.equals("+")){
                res += Double.parseDouble(textField.getText());
            } else if(operator.equals("-")){
                res -= Double.parseDouble(textField.getText());
            } else if(operator.equals("*")){
                res *= Double.parseDouble(textField.getText());
            } else if(operator.equals("/")){
                res /= Double.parseDouble(textField.getText());
            } else if(operator.equals("=")){
                res = Double.parseDouble(textField.getText());
            }

            textField.setText(String.valueOf(res));
            operator = action;
            fNum = true;
        }
    }
    public static void main(String[] args){
        Calculator c = new Calculator();
    }
}
