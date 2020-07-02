package AllPages;
import Airline.Destination;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class ListDestinations extends JFrame {
    public static final Color Landing_COLOR = new Color(126, 11, 11, 65);

    private JList<String> countryList;
    public ListDestinations(ArrayList<Destination> destinationsArrayList) {

        JPanel panel = new JPanel();

        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (int i = 0; i <destinationsArrayList.size(); i++) {
            listModel.addElement(" Name : "+destinationsArrayList.get(i).getName() +"  Latitude : "+
                    destinationsArrayList.get(i).getLatitude() +" Longitude : "+destinationsArrayList.get(i).getLongitude());
        }

        //create the list
        countryList = new JList(listModel);
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