import javax.swing.*;

public class CharacterCounter {
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel countLabel;

    public CharacterCounter() {
        panel1.setName("panel1");
        messageTextArea.setName("messageTextArea");
        characterTextField.setName("characterTextField");
        countButton.setName("countButton");
        countLabel.setName("countLabel");

        messageTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);

        countButton.addActionListener(e -> {
            String text = messageTextArea.getText();
            String charInput = characterTextField.getText();

            if (charInput.isEmpty()) {
                countLabel.setText("(Enter a character)");
                return;
            }

            char targetChar = charInput.charAt(0);
            int count = 0;

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == targetChar) {
                    count++;
                }
            }

            countLabel.setText(String.valueOf(count));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Character Counter");
        frame.setContentPane(new CharacterCounter().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}