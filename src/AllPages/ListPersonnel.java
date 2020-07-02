package AllPages;
import Airport.AirportPersonnel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class ListPersonnel extends JFrame {
    public static final Color Landing_COLOR = new Color(126, 11, 11, 65);

    private JList<String> countryList;
    public ListPersonnel(ArrayList<AirportPersonnel> personnelArrayList) {


        JPanel panel = new JPanel();

        //create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (int i = 0; i <personnelArrayList.size(); i++) {
            listModel.addElement(" Name : "+personnelArrayList.get(i).getName() +"  SureName : "+personnelArrayList.get(i).getSurname()+
                    "  SSN : "+personnelArrayList.get(i).getSSN()+"  Password : "+personnelArrayList.get(i).getPassword());
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
