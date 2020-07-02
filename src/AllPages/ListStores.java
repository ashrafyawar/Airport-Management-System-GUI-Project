package AllPages;
import Airline.Airline;
import Airport.ShopManager;

import javax.swing.*;
import java.awt.*;
import java.util.PriorityQueue;

public class ListStores extends JFrame{
    public static final Color Landing_COLOR = new Color(126, 11, 11, 65);

    private JList<String> countryList;
    public ListStores(PriorityQueue<ShopManager> shops) {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        JPanel panel = new JPanel();
        listModel.addElement("Shop Name : Duracell");
        listModel.addElement("Shop Name : turk telecom");
        listModel.addElement("Shop Name : wind shop");
        listModel.addElement("Shop Name : burger king");
        listModel.addElement("Shop Name : macdonald's");
        listModel.addElement("Shop Name : KFG");
        listModel.addElement("Shop Name : ZARA");
        listModel.addElement("Shop Name : SJD restaurant");
        listModel.addElement("Shop Name : desert shop");
        listModel.addElement("Shop Name : jewelery");

        //create the list
        countryList = new JList(listModel);
        panel.setLayout(new BorderLayout());
        panel.add(countryList);
        add(panel);
        panel.setVisible(true);

        JButton adminInfo=new JButton("Landing Pages");
        adminInfo.setBounds(1700,5,200,40);
        panel.add(adminInfo);
        Font t = new Font("arial", Font.BOLD, 13);
        adminInfo.setFont(t);
        panel.add(adminInfo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);
        panel.add(new JScrollPane(countryList));
        panel.setBounds(100,100,100,100);
        add(panel);

        this.setVisible(true);

        adminInfo.addActionListener(e->{
            new GUI();
        });
    }
}