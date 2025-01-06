import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Nicholas Kowalski
 * COP 2805
 * This program allows the user to choose between 3 different combinations
 * of meats and breads, while only increasing the price depending on 
 * the chosen meat. 
 */

public class JSandwich extends JFrame implements ItemListener {
    FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
    JLabel companyName = new JLabel("Sublime Sandwich");
    JComboBox<String> mainBox = new JComboBox<>();
    JLabel mainList = new JLabel("Main ingredient");
    JComboBox<String> breadBox = new JComboBox<>();
    JLabel breadList = new JLabel("Breads");
    JTextField totPrice = new JTextField(12);
    
    // Prices for main ingredients
    double[] mainPrices = {6.99, 7.99, 8.99}; // Chicken, Beef, and Tuna
    double sumPrice = 0;
    
    public JSandwich() {
        // Create layout
        Box box = Box.createVerticalBox();
        setLayout(flow);
        add(box);
        companyName.setFont(new Font("SansSerif", Font.BOLD, 16));

        // Adds GUI comments
        box.add(companyName);
        box.add(mainList);
        box.add(mainBox);
        box.add(breadList);    
        box.add(breadBox);

        // Total price text field
        totPrice.setEditable(false);
        box.add(totPrice);

        // Add items to the combo boxes
        mainBox.addItem("Select Ingredient");
        mainBox.addItem("Chicken");
        mainBox.addItem("Beef");
        mainBox.addItem("Tuna");

        breadBox.addItem("Select Bread");
        breadBox.addItem("White");
        breadBox.addItem("Rye");
        breadBox.addItem("Whole Wheat");

        // Add item listeners
        mainBox.addItemListener(this);
        breadBox.addItemListener(this);
    }

    public static void main(String[] arguments) {
        JSandwich sandframe = new JSandwich();
        sandframe.setSize(240, 200);
        sandframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sandframe.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent list) {
        // Checks if an ingredient and a bread have been selected and are valid choices
        if (mainBox.getSelectedIndex() > 0 && breadBox.getSelectedIndex() > 0) { 
            // Gets the main price
            double mainPrice = mainPrices[mainBox.getSelectedIndex() - 1]; 

            // Bread cost
            double breadPrice = 0; 

            // Calculates total price
            sumPrice = mainPrice + breadPrice;
            totPrice.setText("Total Price: $" + String.format("%.2f", sumPrice));
        } else {
            // error message if no valid choices were made
            totPrice.setText("Please choose a meat and bread.");
        }
    }
}
