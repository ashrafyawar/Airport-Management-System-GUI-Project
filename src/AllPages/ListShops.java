package AllPages;

import Airline.Airline;
import Airport.ShopManager;

import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ListShops extends JFrame {
    public static final Color Landing_COLOR = new Color(126, 11, 11, 65);

    private JList<String> countryList;
    public ListShops(PriorityQueue<ShopManager> airlines) {


        JPanel panel = new JPanel();

        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");

        //create the list
        countryList = new JList((ListModel) airlines);
        panel.setLayout(new BorderLayout());
        panel.add(countryList);
        add(panel);
        panel.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        panel.add(new JScrollPane(countryList));
        panel.setBounds(100,100,100,100);
        add(panel,BorderLayout.CENTER);

        this.setVisible(true);
    }
}
