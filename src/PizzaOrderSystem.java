import javax.swing.*;

public class PizzaOrderSystem extends JFrame {

    private JPanel panel1;
    private JComboBox<String> pizzaSizeChoice;
    private JComboBox<String> pizzaToppingsChoice;
    private JComboBox<String> extraCheeseChoice;
    private JLabel totalLabel;
    private JButton calculateButton;

    public PizzaOrderSystem() {
        setTitle("Pizza Order System");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setName() for each component
        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaToppingsChoice.setName("pizzaToppingsChoice");
        extraCheeseChoice.setName("extraCheeseChoice");
        totalLabel.setName("totalLabel");
        calculateButton.setName("calculateButton");

        // Options
        pizzaSizeChoice.addItem("Small");
        pizzaSizeChoice.addItem("Medium");
        pizzaSizeChoice.addItem("Large");

        pizzaToppingsChoice.addItem("Mushrooms");
        pizzaToppingsChoice.addItem("Pepperoni");
        pizzaToppingsChoice.addItem("Onions");

        extraCheeseChoice.addItem("Yes");
        extraCheeseChoice.addItem("No");

        calculateButton.addActionListener(e -> calculateTotal());

        setSize(500, 450);
        setLocationRelativeTo(null);
    }

    private void calculateTotal() {
        int total = 0;

        String size = (String) pizzaSizeChoice.getSelectedItem();
        if (size.equals("Small")) {
            total += 10;
        } else if (size.equals("Medium")) {
            total += 15;
        } else if (size.equals("Large")) {
            total += 20;
        }

        total += 2; // topping

        if (extraCheeseChoice.getSelectedItem().equals("Yes")) {
            total += 3;
        }

        totalLabel.setText(String.valueOf(total));
    }

    public static void main(String[] args) {
        new PizzaOrderSystem().setVisible(true);
    }
}