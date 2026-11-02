import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class PasswordValidation {
    private JPanel panel1;
    private JPasswordField passwordTextField;
    private JLabel statusLabel;

    public PasswordValidation() {
        panel1.setName("panel1");
        passwordTextField.setName("passwordTextField");
        statusLabel.setName("statusLabel");

        statusLabel.setText("Password must be 8 characters long");
        statusLabel.setForeground(Color.RED);

        passwordTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validatePassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validatePassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validatePassword();
            }
        });
    }

    private void validatePassword() {
        String password = new String(passwordTextField.getPassword());

        if (password.length() < 8) {
            statusLabel.setText("Password must be 8 characters long");
            statusLabel.setForeground(Color.RED);
            return;
        }

        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        if (!hasDigit) {
            statusLabel.setText("Password must contain at least one digit");
            statusLabel.setForeground(Color.RED);
            return;
        }

        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
                break;
            }
        }

        if (!hasSpecial) {
            statusLabel.setText("Password must contain at least one special character");
            statusLabel.setForeground(Color.RED);
            return;
        }

        statusLabel.setText("Password is valid");
        statusLabel.setForeground(new Color(0, 150, 0));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Validation");
        frame.setContentPane(new PasswordValidation().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}