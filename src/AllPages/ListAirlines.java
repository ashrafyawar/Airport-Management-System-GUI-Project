package AllPages;
import Airline.Airline;
import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.TreeMap;

public class ListAirlines extends JFrame{
    public static final Color Landing_COLOR = new Color(126, 11, 11, 65);

    private JList<String> countryList;
    public ListAirlines(TreeMap<String, Airline> airlines) {

        DefaultListModel<String> listModel = new DefaultListModel<>();

        JPanel panel = new JPanel();
//        Collection<Airline> keys = airlines.values();
//        for(Airline key : keys){
//            listModel.addElement(String.valueOf(key));
//        }

        //create the model and add elements
        listModel.addElement("1. Istanbul Airport  " + airlines.get("123").getUAID_KEY());
        listModel.addElement("2. Ankara Airport    " + airlines.get("456").getUAID_KEY());
        listModel.addElement("3. London Airport    " + airlines.get("131").getUAID_KEY());
        listModel.addElement("4. Melbourne Airport    " + airlines.get("299").getUAID_KEY());

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
