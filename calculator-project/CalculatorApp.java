import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp extends JFrame implements ActionListener {
    JTextField textField;
    double num1, num2, result;
    String operator;

    public CalculatorApp() {
        // Create frame
        setTitle("Java Calculator");
        setSize(350, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        // Button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        // Buttons
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If digit or dot
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            textField.setText(textField.getText() + command);
        }
        // If operator
        else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        }
        // If equals
        else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
            }
            textField.setText("" + result);
        }
        // If clear
        else if (command.equals("C")) {
            textField.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
