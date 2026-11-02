import javax.swing.*;

public class NumberCounter {
    private JPanel panel1;
    private JButton decreaseButton;
    private JButton increaseButton;
    private JLabel countLabel;

    public NumberCounter() {

        countLabel.setName("countLabel");
        increaseButton.setName("increaseButton");
        decreaseButton.setName("decreaseButton");

        increaseButton.addActionListener(e -> {
            int val = Integer.parseInt(countLabel.getText()) + 1;
            countLabel.setText(String.valueOf(val));
        });

        decreaseButton.addActionListener(e -> {
            int val = Integer.parseInt(countLabel.getText()) - 1;
            countLabel.setText(String.valueOf(val));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Counter");
        frame.setContentPane(new NumberCounter().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
