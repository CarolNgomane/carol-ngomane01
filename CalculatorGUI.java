
import javax.swing .*;
import java.awt .*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class CalculatorGUI extends JFrame implements ActionListener {

        private final JTextField txtNum1;
        private final JTextField txtNum2;
        private final JTextField txtResult;
        private final JButton btnAdd;
        private final JButton btnSubtract;
        private final JButton btnMultiply;
        private final JButton btnDivide;


        public CalculatorGUI() {
            setTitle("Basic Calculator");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(5, 2, 10, 10));


            add(new JLabel("Enter Number 1:"));
            txtNum1 = new JTextField();
            add(txtNum1);

            add(new JLabel("Enter Number 2:"));
            txtNum2 = new JTextField();
            add(txtNum2);

            btnAdd = new JButton("+");
            btnSubtract = new JButton("-");
            btnMultiply = new JButton("*");
            btnDivide = new JButton("/");


            btnAdd.addActionListener(this);
            btnSubtract.addActionListener(this);
            btnMultiply.addActionListener(this);
            btnDivide.addActionListener(this);


            add(btnAdd);
            add(btnSubtract);
            add(btnMultiply);
            add(btnDivide);

            add(new JLabel("Result:"));
            txtResult = new JTextField();
            txtResult.setEditable(false);
            add(txtResult);

            setVisible(true);
        }

        // Handling Button Clicks
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(txtNum1.getText());
                double num2 = Double.parseDouble(txtNum2.getText());
                double result = 0;

                if (e.getSource() == btnAdd) {
                    result = num1 + num2;
                } else if (e.getSource() == btnSubtract) {
                    result = num1 - num2;
                } else if (e.getSource() == btnMultiply) {
                    result = num1 * num2;
                } else if (e.getSource() == btnDivide) {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error: Division by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                // Display Result
                txtResult.setText(String.valueOf(result));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Main Method

        public static void main(String[] args) {
            new CalculatorGUI();
        }
    }

