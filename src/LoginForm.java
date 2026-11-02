import javax.swing.*;

public class LoginForm {
    private JPanel panel1;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginForm() {
        panel1.setName("panel1");
        usernameTextField.setName("usernameTextField");
        passwordTextField.setName("passwordTextField");
        loginButton.setName("loginButton");
        messageLabel.setName("messageLabel");

        loginButton.addActionListener(e -> {
            String username = usernameTextField.getText().trim();
            String password = new String(passwordTextField.getPassword());

            if ("admin".equals(username) && "admin".equals(password)) {
                messageLabel.setText("Login Successful!");

                JDialog statusDialog = new JOptionPane(
                        "Login Successful!",
                        JOptionPane.INFORMATION_MESSAGE
                ).createDialog(panel1, "Status");
                statusDialog.setName("statusDialog");
                statusDialog.setVisible(true);
            } else {
                messageLabel.setText("Login Failed!");

                JDialog statusDialog = new JOptionPane(
                        "Login Failed!",
                        JOptionPane.ERROR_MESSAGE
                ).createDialog(panel1, "Status");
                statusDialog.setName("statusDialog");
                statusDialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setContentPane(new LoginForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}