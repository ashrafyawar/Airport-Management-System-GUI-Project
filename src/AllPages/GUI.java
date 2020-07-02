package AllPages;
import Airline.Airline;
import Airport.*;
import Airline.Destination;
import Airline.AirlineAdmin;
import Airline.AirlineSystemStorage;
import javax.swing.*;
import java.awt.*;

import DataStructures.MapGraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

public class GUI{

    public static final String AirportName = "Data Airport";
    public static final String portAdminName = "felix";
    public static final String portAdminSurname = "morgan";
    public static final String portAdminSSN = "123";
    public static final String portAdminPassword = "123";

    public static final Color Main = new Color(188, 242, 252, 154);
    public static final Color Guest_COLOR = new Color(64, 68, 64, 154);
    public static final Color Login_COLOR = new Color(35, 131, 32, 10);
    public static final Color AirportAdminPage_COLOR = new Color(255, 255, 255, 255);
    public static final Color AirportAdminTitle_COLOR = new Color(222, 201, 27, 255);
    public static final Color Landing_COLOR = new Color(126, 11, 11, 65);

    JFrame frame = new JFrame();
    AirportSystemStorage portStorage = new AirportSystemStorage();
    AirportAdmin portAdmin = new AirportAdmin(portAdminName,portAdminSurname,portAdminSSN,portAdminPassword,portStorage);
    public void LOGIN(){

        frame.setVisible(false);
        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();
        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        panel.setBackground(Login_COLOR);

        JLabel a=new JLabel("label");
        a.setText("LOGIN TO YOUR ACCOUNT :)");
        a.setForeground(AirportAdminTitle_COLOR);
        a.setBounds(530,130,1000,55);
        Font font = new Font("arial", Font.BOLD, 50);
        a.setFont(font);
        panel.add(a);

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame1,panel);
        //***************************************************

        JLabel Name = new JLabel("Name");
        Name.setBounds(180,300,80,25);
        Name.setForeground(AirportAdminTitle_COLOR);
        panel.add(Name);
        JTextField nameText=new JTextField();
        nameText.setBounds(265,300,160,25);
        panel.add(nameText);

        JLabel SureName =new JLabel("Sure Name");
        SureName.setBounds(180,330,80,25);
        SureName.setForeground(AirportAdminTitle_COLOR);
        panel.add(SureName);
        JTextField sureNameText=new JTextField();
        sureNameText.setBounds(265,330,160,25);
        panel.add(sureNameText);

        JLabel SSN =new JLabel("SSN/UAID");
        SSN.setBounds(180,360,80,25);
        SSN.setForeground(AirportAdminTitle_COLOR);
        panel.add(SSN);
        JPasswordField ssnText  =new JPasswordField();
        ssnText.setBounds(265,360,160,25);
        panel.add(ssnText);

        JLabel PASSWORD = new JLabel("Password");
        PASSWORD.setBounds(180,390,80,25);
        PASSWORD.setForeground(AirportAdminTitle_COLOR);
        panel.add(PASSWORD);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(265,390,160,25);
        panel.add(passwordText);

        JLabel UserType = new JLabel("User Type");
        UserType.setBounds(180,420,80,25);
        UserType.setForeground(AirportAdminTitle_COLOR);
        panel.add(UserType);

        Object[] items = {"Airport Administrator","Airline Manager","Store Manager"
                        ,"Flight Manager","Airline Personnel","Ticketed Passenger"};

        JComboBox comboBox = new JComboBox(items);
        comboBox.setBounds(265,420,161,25);
        panel.add(comboBox);

        JButton Login=new JButton("LOGIN");
        Login.setBounds(300,470,80,25);
        panel.add(Login);


        ImageIcon icon = new ImageIcon("src/Pictures/loginpage.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 1920, 1080); // for example, you can use your own values
        panel.add(label);

        frame1.setVisible(true);
        Login.addActionListener(e -> {// e -> lambda expression
            if(comboBox.getSelectedItem().toString().equals(items[0])){// airport admin
                String ssn = new String(ssnText.getPassword());
                String password = new String(passwordText.getPassword());
                 if (nameText.getText().equals(portAdmin.getName()) && sureNameText.getText().equals(portAdmin.getSurname())
                        && ssn.equals(portAdmin.getSSN()) && password.equals(portAdmin.getPassword())){
                    AirportAdministrator();
                }else{
                    JOptionPane.showMessageDialog(this.frame,"Incorrect User Info :(");
                }
            }
            else if (comboBox.getSelectedItem().toString().equals(items[1])){//if airline admin
            }
            else if (comboBox.getSelectedItem().toString().equals(items[2])){

                StoreManager();
            }
            else if (comboBox.getSelectedItem().toString().equals(items[3])){
            }
            else if (comboBox.getSelectedItem().toString().equals(items[4])){
            }
            else if (comboBox.getSelectedItem().toString().equals(items[5])){
            }
        });
    }
    public void StoreManager(){
        frame.setVisible(false);
        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();
        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame1,panel);
        //***************************************************
        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(AirportAdminPage_COLOR);

        ///////Name
        JLabel UserID=new JLabel("Name");
        UserID.setBounds(180,300,80,25);
        panel.add(UserID);
        JTextField name=new JTextField();
        name.setBounds(280,300,160,25);
        panel.add(name);
        ///////ShopManager
        JTextField ShopManagerTEXT=new JTextField();
        ShopManagerTEXT.setBounds(280,330,160,25);
        panel.add(ShopManagerTEXT);
        frame1.setVisible(true);
        JLabel ShopManagerLBL=new JLabel("Shop Manager");
        ShopManagerLBL.setBounds(180,330,100,25);
        panel.add(ShopManagerLBL);

        /////////FEE
        JTextField fee=new JTextField();
        fee.setBounds(280,360,160,25);
        panel.add(fee);
        JLabel feeLBL=new JLabel("Fee");
        feeLBL.setBounds(180,360,100,25);
        panel.add(feeLBL);

        ///////////ID
        JTextField ID=new JTextField();
        ID.setBounds(280,390,160,25);
        panel.add(ID);
        JLabel IDLBL=new JLabel("ID");
        IDLBL.setBounds(180,390,100,25);
        panel.add(IDLBL);


        /////////BUTTONS
        JButton addUser=new JButton("Add");
        addUser.setBounds(280,450,100,25);
        panel.add(addUser);

        JButton removeUser=new JButton("Remove");
        removeUser.setBounds(390,450,100,25);
        panel.add(removeUser);



        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=ShopManagerTEXT.getText();
                String words[]=str.split("-");
                System.out.println(words[0]);
                Double FEE=Double.parseDouble(words[4]);
                System.out.println(FEE);
                try {
                    ShopManager SM=new ShopManager(words[0],words[1],words[2],words[3],FEE,null);
                    int feeShop=Integer.parseInt(fee.getText());
                    Shop shp=new Shop(UserID.getText(),SM,feeShop,ID.getText());
                    //addtotheCollection Shop
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }
        });
        removeUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=ShopManagerTEXT.getText();
                String words[]=str.split("-");
                System.out.println(words[0]);
                Double FEE=Double.parseDouble(words[4]);
                System.out.println(FEE);
                //ShopManager SM=new ShopManager(words[0],words[1],words[2],words[3],FEE,null);
            }
        });

    }
    public void GUEST(){

        frame.setVisible(false);
        JFrame frameGuest=new JFrame();
        JPanel panelGuest=new JPanel();
        frameGuest.setSize(1920,1080);;
        frameGuest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelGuest.setBackground(Guest_COLOR);
        frameGuest.add(panelGuest);
        frameGuest.setLocationRelativeTo(null);//set center
        panelGuest.setLayout(null);
        JTextField SearchText=new JTextField();
        SearchText.setBounds(180,100,160,25);
        panelGuest.add(SearchText);
        JButton search=new JButton("Search");
        search.setBounds(350,100,100,25);
        panelGuest.add(search);

        search.addActionListener(e -> {
            JLabel output=new JLabel("OUTPUT WILL BE PRINTED HERE");
            output.setBounds(180,120,200,25);
            panelGuest.add(output);
        });

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frameGuest,panelGuest);
        //***************************************************
        frameGuest.setVisible(true);
    }

    public void AirportAdministrator(){

        frame.setVisible(false);
        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame,panel);
        //***************************************************

        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(AirportAdminPage_COLOR);


        JLabel a=new JLabel("label");
        a.setText("AIRPORT ADMINISTRATION");
        a.setForeground(AirportAdminTitle_COLOR);
        a.setBounds(530,130,1000,55);
        Font font = new Font("arial", Font.BOLD, 50);
        a.setFont(font);
        panel.add(a);

        JLabel UserType=new JLabel("User Type");
        UserType.setForeground(AirportAdminTitle_COLOR);
        UserType.setBounds(800,400,150,25);
        panel.add(UserType);

        Object[] items = {"Airlines Administration","Stores Administration","Personnel Administration","Destination Administration"};
        JComboBox comboBox = new JComboBox(items);
        comboBox.setBounds(880,400,200,25);
        panel.add(comboBox);

        JButton addUser=new JButton("Add");
        addUser.setBounds(810,450,125,25);
        panel.add(addUser);

        JButton removeUser=new JButton("Remove");
        removeUser.setBounds(945,450,125,25);
        panel.add(removeUser);

        JButton adminInfo=new JButton("Display Personnel Info");
        adminInfo.setBounds(1700,5,200,40);
        panel.add(adminInfo);
        Font t = new Font("arial", Font.BOLD, 13);
        adminInfo.setFont(t);
        panel.add(adminInfo);

        JButton airline_settings=new JButton("Airline Settings");
        airline_settings.setBounds(1700,50,200,40);
        panel.add(airline_settings);
        Font airlineT = new Font("arial", Font.BOLD, 13);
        airline_settings.setFont(airlineT);
        panel.add(airline_settings);

        JButton shops_settings=new JButton("Shops Settings");
        shops_settings.setBounds(1700,100,200,40);
        panel.add(shops_settings);
        Font shopsT = new Font("arial", Font.BOLD, 13);
        shops_settings.setFont(shopsT);
        panel.add(shops_settings);

        JButton personnel_setting=new JButton("Airport Personnel");
        personnel_setting.setBounds(1700,150,200,40);
        panel.add(personnel_setting);
        Font personalT = new Font("arial", Font.BOLD, 13);
        personnel_setting.setFont(personalT);
        panel.add(personnel_setting);

        JButton destination_settings=new JButton("Destination Settings");
        destination_settings.setBounds(1700,200,200,40);
        panel.add(destination_settings);
        Font destT = new Font("arial", Font.BOLD, 13);
        destination_settings.setFont(destT);
        panel.add(destination_settings);


        ImageIcon icon = new ImageIcon("src/Pictures/airportadminis.jpg");

        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 1920, 1080); // for example, you can use your own values
        panel.add(label);
        frame1.setVisible(true);

        addUser.addActionListener(e -> {// e -> lambda expression.
        });
        removeUser.addActionListener(e -> {// e -> lambda expression.
        });
        adminInfo.addActionListener(e ->{
            AirportAdministratorPersonnelInfo();
        });
        airline_settings.addActionListener(e ->{
            AirportAdminAirlinesSetting();
        });
        shops_settings.addActionListener(e ->{
            AirportAdminShopsSetting();
        });

        personnel_setting.addActionListener(e ->{
            AirportAdminPersonnelsSetting();
        });

        destination_settings.addActionListener(e ->{
            AirportAdminDestinationSetting();
        });
    }

    public void AirportAdministratorPersonnelInfo(){

        frame.setVisible(false);

        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame,panel);
        //***************************************************

        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(AirportAdminPage_COLOR);


        JLabel a=new JLabel("admin");
        a.setText("PERSONNEL INFORMATION");
        a.setForeground(AirportAdminTitle_COLOR);
        a.setBounds(530,130,1000,55);
        Font font = new Font("arial", Font.BOLD, 50);
        a.setFont(font);
        panel.add(a);

        JLabel name=new JLabel("name");
        name.setText("Name : " + portAdmin.getName());
        name.setForeground(AirportAdminPage_COLOR);
        name.setBounds(530,190,1000,55);
        Font nameFont = new Font("arial", Font.BOLD, 20);
        name.setFont(nameFont);
        panel.add(name);

        JLabel sureName=new JLabel("sureName");
        sureName.setText("SureName : "+portAdmin.getSurname());
        sureName.setForeground(AirportAdminPage_COLOR);
        sureName.setBounds(530,250,1000,55);
        Font sureNameFont = new Font("arial", Font.BOLD, 20);
        sureName.setFont(sureNameFont);
        panel.add(sureName);

        JLabel ssn=new JLabel("ssn");
        ssn.setText("SSN : "+portAdmin.getSSN());
        ssn.setForeground(AirportAdminPage_COLOR);
        ssn.setBounds(530,310,1000,55);
        Font ssnFont = new Font("arial", Font.BOLD, 20);
        ssn.setFont(ssnFont);
        panel.add(ssn);

        JLabel pass=new JLabel("pass");
        pass.setText("Password : " + portAdmin.getPassword());
        pass.setForeground(AirportAdminPage_COLOR);
        pass.setBounds(530,370,1000,55);
        Font passFont = new Font("arial", Font.BOLD, 20);
        pass.setFont(passFont);
        panel.add(pass);


        JButton adminInfo=new JButton("Hide Personnel Info");
        adminInfo.setBounds(1700,5,200,40);
        panel.add(adminInfo);
        Font t = new Font("arial", Font.BOLD, 13);
        adminInfo.setFont(t);
        panel.add(adminInfo);


        JLabel SSN=new JLabel("New SSN ");
        SSN.setForeground(AirportAdminPage_COLOR);
        SSN.setBounds(180,350,80,25);
        panel.add(SSN);
        JTextField UserIDText=new JTextField();
        UserIDText.setBounds(300,350,160,25);
        panel.add(UserIDText);

        JPasswordField passwordText =new JPasswordField();
        JLabel Password=new JLabel("New Password");
        Password.setForeground(AirportAdminPage_COLOR);

        Password.setBounds(180,375,115,25);
        panel.add(Password);
        passwordText.setBounds(300,375,160,25);
        panel.add(passwordText);


        JButton addUser=new JButton("Reset");
        addUser.setBounds(330,410,100,25);
        panel.add(addUser);

        ImageIcon icon = new ImageIcon("src/Pictures/adminInfoPageImage.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 1920, 1080); // for example, you can use your own values
        panel.add(label);
        frame1.setVisible(true);

        adminInfo.addActionListener(e ->{
            AirportAdministrator();
        });
        addUser.addActionListener(e->{
            boolean isPassed = true;

            String SSn = new String(UserIDText.getText());
            String password = new String(passwordText.getPassword());
            try{
                portAdmin.setSSN(SSn);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            try {
                portAdmin.setPassword(password);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            if (isPassed) {
                AirportAdministratorPersonnelInfo();
                JOptionPane.showMessageDialog(this.frame, "Airport Admin's SSN And Password have been reset Successfully :)");
            }
        });
    }
    public void AirportAdminAirlinesSetting(){
        frame.setVisible(false);

        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame,panel);
        //***************************************************

        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(AirportAdminPage_COLOR);


        JLabel a=new JLabel("admin");
        a.setText("AIRLINES ADMINISTRATION");
        a.setForeground(AirportAdminTitle_COLOR);
        a.setBounds(530,130,1000,55);
        Font font = new Font("arial", Font.BOLD, 50);
        a.setFont(font);
        panel.add(a);

        JLabel name=new JLabel("name");
        name.setText("Airport Admin Name : " + portAdmin.getName());
        name.setForeground(AirportAdminPage_COLOR);
        name.setBounds(530,190,1000,55);
        Font nameFont = new Font("arial", Font.BOLD, 20);
        name.setFont(nameFont);
        panel.add(name);

        JLabel sureName=new JLabel("sureName");
        sureName.setText("Airport Admin SureName : "+portAdmin.getSurname());
        sureName.setForeground(AirportAdminPage_COLOR);
        sureName.setBounds(530,250,1000,55);
        Font sureNameFont = new Font("arial", Font.BOLD, 20);
        sureName.setFont(sureNameFont);
        panel.add(sureName);

        JLabel ssn=new JLabel("ssn");
        ssn.setText("Airport Admin SSN : "+portAdmin.getSSN());
        ssn.setForeground(AirportAdminPage_COLOR);
        ssn.setBounds(530,310,1000,55);
        Font ssnFont = new Font("arial", Font.BOLD, 20);
        ssn.setFont(ssnFont);
        panel.add(ssn);

        JLabel pass=new JLabel("pass");
        pass.setText("Airport Admin Password : " + portAdmin.getPassword());
        pass.setForeground(AirportAdminPage_COLOR);
        pass.setBounds(530,370,1000,55);
        Font passFont = new Font("arial", Font.BOLD, 20);
        pass.setFont(passFont);
        panel.add(pass);

        JButton adminInfo=new JButton("Go To Airport Admin Page");
        adminInfo.setBounds(1700,5,200,40);
        panel.add(adminInfo);
        Font t = new Font("arial", Font.BOLD, 13);
        adminInfo.setFont(t);
        panel.add(adminInfo);

        JLabel info=new JLabel("info");
        info.setText("Reset SSN And Password");
        info.setForeground(AirportAdminTitle_COLOR);
        info.setBounds(285,250,300,30);
        Font infoFont = new Font("arial", Font.BOLD, 13);
        info.setFont(infoFont);
        panel.add(info);

        JLabel oldSSN=new JLabel("Old SSN ");
        oldSSN.setForeground(AirportAdminPage_COLOR);
        oldSSN.setBounds(180,300,80,25);
        panel.add(oldSSN);
        JTextField oldssnText=new JTextField();
        oldssnText.setBounds(300,300,160,25);
        panel.add(oldssnText);

        JPasswordField oldPassword =new JPasswordField();
        JLabel OldPassword=new JLabel("Old Password");
        OldPassword.setForeground(AirportAdminPage_COLOR);

        OldPassword.setBounds(180,325,115,25);
        panel.add(OldPassword);
        oldPassword.setBounds(300,325,160,25);
        panel.add(oldPassword);

        JLabel SSN=new JLabel("New SSN ");
        SSN.setForeground(AirportAdminPage_COLOR);
        SSN.setBounds(180,350,80,25);
        panel.add(SSN);
        JTextField UserIDText=new JTextField();
        UserIDText.setBounds(300,350,160,25);
        panel.add(UserIDText);

        JPasswordField passwordText =new JPasswordField();
        JLabel Password=new JLabel("New Password");
        Password.setForeground(AirportAdminPage_COLOR);

        Password.setBounds(180,375,115,25);
        panel.add(Password);
        passwordText.setBounds(300,375,160,25);
        panel.add(passwordText);


        JButton addUser=new JButton("Reset");
        addUser.setBounds(330,410,100,25);
        panel.add(addUser);


        JButton airline_settings=new JButton("List Airlines");
        airline_settings.setBounds(1700,50,200,40);
        panel.add(airline_settings);
        Font airlineT = new Font("arial", Font.BOLD, 13);
        airline_settings.setFont(airlineT);
        panel.add(airline_settings);

        ImageIcon icon = new ImageIcon("src/Pictures/airlinepage.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 1920, 1080); // for example, you can use your own values
        panel.add(label);
        frame1.setVisible(true);

        adminInfo.addActionListener(e ->{
            AirportAdministrator();
        });
        addUser.addActionListener(e->{
            boolean isPassed = true;

            String SSn = new String(UserIDText.getText());
            String password = new String(passwordText.getPassword());
            try {

                //portAdmin.setSSN(SSn);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            try {
                //portAdmin.setPassword(password);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            if (isPassed) {
                JOptionPane.showMessageDialog(this.frame, "Airline Admin's SSN And Password have been reset Successfully :)");
            }
        });
        airline_settings.addActionListener(e->{
            new ListAirlines(getTestAirlines());
        });
    }
    public void AirportAdminShopsSetting(){

        frame.setVisible(false);

        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame,panel);
        //***************************************************

        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(AirportAdminPage_COLOR);


        JLabel a=new JLabel("admin");
        a.setText("STORES ADMINISTRATION");
        a.setForeground(AirportAdminTitle_COLOR);
        a.setBounds(530,130,1000,55);
        Font font = new Font("arial", Font.BOLD, 50);
        a.setFont(font);
        panel.add(a);

        JLabel name=new JLabel("name");
        name.setText("Airport Admin Name : " + portAdmin.getName());
        name.setForeground(AirportAdminPage_COLOR);
        name.setBounds(530,190,1000,55);
        Font nameFont = new Font("arial", Font.BOLD, 20);
        name.setFont(nameFont);
        panel.add(name);

        JLabel sureName=new JLabel("sureName");
        sureName.setText("Airport Admin SureName : "+portAdmin.getSurname());
        sureName.setForeground(AirportAdminPage_COLOR);
        sureName.setBounds(530,250,1000,55);
        Font sureNameFont = new Font("arial", Font.BOLD, 20);
        sureName.setFont(sureNameFont);
        panel.add(sureName);

        JLabel ssn=new JLabel("ssn");
        ssn.setText("Airport Admin SSN : "+portAdmin.getSSN());
        ssn.setForeground(AirportAdminPage_COLOR);
        ssn.setBounds(530,310,1000,55);
        Font ssnFont = new Font("arial", Font.BOLD, 20);
        ssn.setFont(ssnFont);
        panel.add(ssn);

        JLabel pass=new JLabel("pass");
        pass.setText("Airport Admin Password : " + portAdmin.getPassword());
        pass.setForeground(AirportAdminPage_COLOR);
        pass.setBounds(530,370,1000,55);
        Font passFont = new Font("arial", Font.BOLD, 20);
        pass.setFont(passFont);
        panel.add(pass);


        JButton adminInfo=new JButton("Go To Airport Admin Page");
        adminInfo.setBounds(1700,5,200,40);
        panel.add(adminInfo);
        Font t = new Font("arial", Font.BOLD, 13);
        adminInfo.setFont(t);
        panel.add(adminInfo);


        JLabel info=new JLabel("info");
        info.setText("Reset SSN And Password");
        info.setForeground(AirportAdminTitle_COLOR);
        info.setBounds(285,250,300,30);
        Font infoFont = new Font("arial", Font.BOLD, 13);
        info.setFont(infoFont);
        panel.add(info);

        JLabel oldSSN=new JLabel("Old SSN ");
        oldSSN.setForeground(AirportAdminPage_COLOR);
        oldSSN.setBounds(180,300,80,25);
        panel.add(oldSSN);
        JTextField oldssnText=new JTextField();
        oldssnText.setBounds(300,300,160,25);
        panel.add(oldssnText);

        JPasswordField oldPassword =new JPasswordField();
        JLabel OldPassword=new JLabel("Old Password");
        OldPassword.setForeground(AirportAdminPage_COLOR);

        OldPassword.setBounds(180,325,115,25);
        panel.add(OldPassword);
        oldPassword.setBounds(300,325,160,25);
        panel.add(oldPassword);

        JLabel SSN=new JLabel("New SSN ");
        SSN.setForeground(AirportAdminPage_COLOR);
        SSN.setBounds(180,350,80,25);
        panel.add(SSN);
        JTextField UserIDText=new JTextField();
        UserIDText.setBounds(300,350,160,25);
        panel.add(UserIDText);

        JPasswordField passwordText =new JPasswordField();
        JLabel Password=new JLabel("New Password");
        Password.setForeground(AirportAdminPage_COLOR);

        Password.setBounds(180,375,115,25);
        panel.add(Password);
        passwordText.setBounds(300,375,160,25);
        panel.add(passwordText);


        JButton addUser=new JButton("Reset");
        addUser.setBounds(330,410,100,25);
        panel.add(addUser);


        JButton storeSettings=new JButton("List Stores");
        storeSettings.setBounds(1700,50,200,40);
        panel.add(storeSettings);
        Font airlineT = new Font("arial", Font.BOLD, 13);
        storeSettings.setFont(airlineT);
        panel.add(storeSettings);

        ImageIcon icon = new ImageIcon("src/Pictures/shopspageimage.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 1920, 1080); // for example, you can use your own values
        panel.add(label);
        frame1.setVisible(true);

        adminInfo.addActionListener(e ->{
            AirportAdministrator();
        });
        addUser.addActionListener(e->{
            boolean isPassed = true;

            String SSn = new String(UserIDText.getText());
            String password = new String(passwordText.getPassword());
            try {
                //portAdmin.setSSN(SSn);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            try {
                //portAdmin.setPassword(password);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            if (isPassed) {
                JOptionPane.showMessageDialog(this.frame, "Stores Admin's SSN And Password have been reset Successfully :)");
            }
        });
        storeSettings.addActionListener(e->{//when button clicked lists all shops in screen
            new ListStores(portAdmin.getAirportSystemStorage().getShopManagers());
        });
    }
    public void AirportAdminPersonnelsSetting(){

        frame.setVisible(false);

        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame,panel);
        //***************************************************

        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(AirportAdminPage_COLOR);

        JLabel a=new JLabel("admin");
        a.setText("PERSONNEL ADMINISTRATION");
        a.setForeground(AirportAdminTitle_COLOR);
        a.setBounds(530,130,1000,55);
        Font font = new Font("arial", Font.BOLD, 50);
        a.setFont(font);
        panel.add(a);

        JLabel name=new JLabel("name");
        name.setText("Airport Admin Name : " + portAdmin.getName());
        name.setForeground(AirportAdminPage_COLOR);
        name.setBounds(530,190,1000,55);
        Font nameFont = new Font("arial", Font.BOLD, 20);
        name.setFont(nameFont);
        panel.add(name);

        JLabel sureName=new JLabel("sureName");
        sureName.setText("Airport Admin SureName : "+portAdmin.getSurname());
        sureName.setForeground(AirportAdminPage_COLOR);
        sureName.setBounds(530,250,1000,55);
        Font sureNameFont = new Font("arial", Font.BOLD, 20);
        sureName.setFont(sureNameFont);
        panel.add(sureName);

        JLabel ssn=new JLabel("ssn");
        ssn.setText("Airport Admin SSN : "+portAdmin.getSSN());
        ssn.setForeground(AirportAdminPage_COLOR);
        ssn.setBounds(530,310,1000,55);
        Font ssnFont = new Font("arial", Font.BOLD, 20);
        ssn.setFont(ssnFont);
        panel.add(ssn);

        JLabel pass=new JLabel("pass");
        pass.setText("Airport Admin Password : " + portAdmin.getPassword());
        pass.setForeground(AirportAdminPage_COLOR);
        pass.setBounds(530,370,1000,55);
        Font passFont = new Font("arial", Font.BOLD, 20);
        pass.setFont(passFont);
        panel.add(pass);

        JButton adminInfo=new JButton("Go To Airport Admin Page");
        adminInfo.setBounds(1700,5,200,40);
        panel.add(adminInfo);
        Font t = new Font("arial", Font.BOLD, 13);
        adminInfo.setFont(t);
        panel.add(adminInfo);


        JLabel info=new JLabel("info");
        info.setText("Reset SSN And Password");
        info.setForeground(AirportAdminTitle_COLOR);
        info.setBounds(285,250,300,30);
        Font infoFont = new Font("arial", Font.BOLD, 13);
        info.setFont(infoFont);
        panel.add(info);

        JLabel oldSSN=new JLabel("Old SSN ");
        oldSSN.setForeground(AirportAdminPage_COLOR);
        oldSSN.setBounds(180,300,80,25);
        panel.add(oldSSN);
        JTextField oldssnText=new JTextField();
        oldssnText.setBounds(300,300,160,25);
        panel.add(oldssnText);

        JPasswordField oldPassword =new JPasswordField();
        JLabel OldPassword=new JLabel("Old Password");
        OldPassword.setForeground(AirportAdminPage_COLOR);

        OldPassword.setBounds(180,325,115,25);
        panel.add(OldPassword);
        oldPassword.setBounds(300,325,160,25);
        panel.add(oldPassword);

        JLabel SSN=new JLabel("New SSN ");
        SSN.setForeground(AirportAdminPage_COLOR);
        SSN.setBounds(180,350,80,25);
        panel.add(SSN);
        JTextField UserIDText=new JTextField();
        UserIDText.setBounds(300,350,160,25);
        panel.add(UserIDText);

        JPasswordField passwordText =new JPasswordField();
        JLabel Password=new JLabel("New Password");
        Password.setForeground(AirportAdminPage_COLOR);

        Password.setBounds(180,375,115,25);
        panel.add(Password);
        passwordText.setBounds(300,375,160,25);
        panel.add(passwordText);


        JButton addUser=new JButton("Reset");
        addUser.setBounds(330,410,100,25);
        panel.add(addUser);


        JButton personnelSettings=new JButton("List Personnel");
        personnelSettings.setBounds(1700,50,200,40);
        panel.add(personnelSettings);
        Font airlineT = new Font("arial", Font.BOLD, 13);
        personnelSettings.setFont(airlineT);
        panel.add(personnelSettings);

        ImageIcon icon = new ImageIcon("src/Pictures/personnelpageimage.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 1920, 1080); // for example, you can use your own values
        panel.add(label);
        frame1.setVisible(true);

        adminInfo.addActionListener(e ->{
            AirportAdministrator();
        });
        addUser.addActionListener(e->{
            boolean isPassed = true;

            String SSn = new String(UserIDText.getText());
            String password = new String(passwordText.getPassword());
            try {
                //portAdmin.setSSN(SSn);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            try {
                //portAdmin.setPassword(password);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            if (isPassed) {
                JOptionPane.showMessageDialog(this.frame, "Personnel Admin's SSN And Password have been reset Successfully :)");
            }
        });
        personnelSettings.addActionListener(e->{

            portAdmin.getAirportSystemStorage().setAirportPersonnel(new ArrayList<>());
            AirportPersonnel aq = new AirportPersonnel("james","vardi","3334","76234555",portAdmin.getAirportSystemStorage());
            AirportPersonnel b = new AirportPersonnel("james","vardi","1141","2323454",portAdmin.getAirportSystemStorage());
            AirportPersonnel c = new AirportPersonnel("james","vardi","2222","55453",portAdmin.getAirportSystemStorage());
            AirportPersonnel d = new AirportPersonnel("james","vardi","3334","877",portAdmin.getAirportSystemStorage());
            AirportPersonnel ee = new AirportPersonnel("james","vardi","45345","2222452",portAdmin.getAirportSystemStorage());
            AirportPersonnel f = new AirportPersonnel("james","vardi","23424","2342345",portAdmin.getAirportSystemStorage());
            AirportPersonnel h = new AirportPersonnel("james","vardi","3334","23452455",portAdmin.getAirportSystemStorage());
            AirportPersonnel j = new AirportPersonnel("james","vardi","3334","87652555",portAdmin.getAirportSystemStorage());
            AirportPersonnel i = new AirportPersonnel("james","vardi","3334","23543225",portAdmin.getAirportSystemStorage());
            AirportPersonnel g = new AirportPersonnel("james","vardi","3334","98723456",portAdmin.getAirportSystemStorage());
            AirportPersonnel k = new AirportPersonnel("james","vardi","3334","23423455",portAdmin.getAirportSystemStorage());
            AirportPersonnel l = new AirportPersonnel("james","vardi","3334","12234523",portAdmin.getAirportSystemStorage());
            AirportPersonnel m = new AirportPersonnel("james","vardi","3334","98234576",portAdmin.getAirportSystemStorage());
            AirportPersonnel n = new AirportPersonnel("james","vardi","3334","55553454",portAdmin.getAirportSystemStorage());
            AirportPersonnel o = new AirportPersonnel("james","vardi","3334","23452345",portAdmin.getAirportSystemStorage());
            AirportPersonnel p = new AirportPersonnel("james","vardi","3334","24525345",portAdmin.getAirportSystemStorage());
            AirportPersonnel q = new AirportPersonnel("james","vardi","5443","23452345",portAdmin.getAirportSystemStorage());
            AirportPersonnel r = new AirportPersonnel("james","vardi","433","77234527",portAdmin.getAirportSystemStorage());
            AirportPersonnel s = new AirportPersonnel("james","vardi","1111","23452345",portAdmin.getAirportSystemStorage());

            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(aq);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(b);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(c);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(d);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(ee);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(f);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(j);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(h);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(i);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(g);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(k);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(l);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(m);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(n);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(o);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(p);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(q);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(r);
            portAdmin.getAirportSystemStorage().getAirportPersonnel().add(s);

            new ListPersonnel(portAdmin.getAirportSystemStorage().getAirportPersonnel());
        });
    }
    public void AirportAdminDestinationSetting(){

        frame.setVisible(false);

        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();

        //logo mouse click event
        LogoMouseListener logoMouseListener = new LogoMouseListener(frame,panel);
        //***************************************************

        frame1.setSize(1920,1080);;
        frame1.setLocationRelativeTo(null);//set center
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(AirportAdminPage_COLOR);

        JLabel a=new JLabel("admin");
        a.setText("DESTINATIONS ADMINISTRATION");
        a.setForeground(AirportAdminTitle_COLOR);
        a.setBounds(530,130,1000,55);
        Font font = new Font("arial", Font.BOLD, 50);
        a.setFont(font);
        panel.add(a);

        JLabel name=new JLabel("name");
        name.setText("Airport Admin Name : " + portAdmin.getName());
        name.setForeground(AirportAdminPage_COLOR);
        name.setBounds(530,190,1000,55);
        Font nameFont = new Font("arial", Font.BOLD, 20);
        name.setFont(nameFont);
        panel.add(name);

        JLabel sureName=new JLabel("sureName");
        sureName.setText("Airport Admin SureName : "+portAdmin.getSurname());
        sureName.setForeground(AirportAdminPage_COLOR);
        sureName.setBounds(530,250,1000,55);
        Font sureNameFont = new Font("arial", Font.BOLD, 20);
        sureName.setFont(sureNameFont);
        panel.add(sureName);

        JLabel ssn=new JLabel("ssn");
        ssn.setText("Airport Admin SSN : "+portAdmin.getSSN());
        ssn.setForeground(AirportAdminPage_COLOR);
        ssn.setBounds(530,310,1000,55);
        Font ssnFont = new Font("arial", Font.BOLD, 20);
        ssn.setFont(ssnFont);
        panel.add(ssn);

        JLabel pass=new JLabel("pass");
        pass.setText("Airport Admin Password : " + portAdmin.getPassword());
        pass.setForeground(AirportAdminPage_COLOR);
        pass.setBounds(530,370,1000,55);
        Font passFont = new Font("arial", Font.BOLD, 20);
        pass.setFont(passFont);
        panel.add(pass);

        JButton adminInfo=new JButton("Go To Airport Admin Page");
        adminInfo.setBounds(1700,5,200,40);
        panel.add(adminInfo);
        Font t = new Font("arial", Font.BOLD, 13);
        adminInfo.setFont(t);
        panel.add(adminInfo);

        JLabel info=new JLabel("info");
        info.setText("Reset SSN And Password");
        info.setForeground(AirportAdminTitle_COLOR);
        info.setBounds(285,250,300,30);
        Font infoFont = new Font("arial", Font.BOLD, 13);
        info.setFont(infoFont);
        panel.add(info);

        JLabel oldSSN=new JLabel("Old SSN ");
        oldSSN.setForeground(AirportAdminPage_COLOR);
        oldSSN.setBounds(180,300,80,25);
        panel.add(oldSSN);
        JTextField oldssnText=new JTextField();
        oldssnText.setBounds(300,300,160,25);
        panel.add(oldssnText);

        JPasswordField oldPassword =new JPasswordField();
        JLabel OldPassword=new JLabel("Old Password");
        OldPassword.setForeground(AirportAdminPage_COLOR);

        OldPassword.setBounds(180,325,115,25);
        panel.add(OldPassword);
        oldPassword.setBounds(300,325,160,25);
        panel.add(oldPassword);

        JLabel SSN=new JLabel("New SSN ");
        SSN.setForeground(AirportAdminPage_COLOR);
        SSN.setBounds(180,350,80,25);
        panel.add(SSN);
        JTextField UserIDText=new JTextField();
        UserIDText.setBounds(300,350,160,25);
        panel.add(UserIDText);

        JPasswordField passwordText =new JPasswordField();
        JLabel Password=new JLabel("New Password");
        Password.setForeground(AirportAdminPage_COLOR);

        Password.setBounds(180,375,115,25);
        panel.add(Password);
        passwordText.setBounds(300,375,160,25);
        panel.add(passwordText);


        JButton addUser=new JButton("Reset");
        addUser.setBounds(330,410,100,25);
        panel.add(addUser);


        JButton destinationsSettingsButton=new JButton("List Destinations");
        destinationsSettingsButton.setBounds(1700,50,200,40);
        panel.add(destinationsSettingsButton);
        Font airlineT = new Font("arial", Font.BOLD, 13);
        destinationsSettingsButton.setFont(airlineT);
        panel.add(destinationsSettingsButton);

        ImageIcon icon = new ImageIcon("src/Pictures/destPageImage.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 1920, 1080); // for example, you can use your own values
        panel.add(label);
        frame1.setVisible(true);

        adminInfo.addActionListener(e ->{
            AirportAdministrator();
        });
        addUser.addActionListener(e->{
            boolean isPassed = true;

            String SSn = new String(UserIDText.getText());
            String password = new String(passwordText.getPassword());
            try {
                portAdmin.setSSN(SSn);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            try {
                portAdmin.setPassword(password);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(this.frame,"Oops Can't Reset :(");
                isPassed = false;
                exception.printStackTrace();
            }
            if (isPassed) {
                JOptionPane.showMessageDialog(this.frame, "Destinations Admin's SSN And Password have been reset Successfully :)");
            }
        });
        destinationsSettingsButton.addActionListener(e->{
            new ListDestinations(portAdmin.getAirportSystemStorage().getDestinations());
        });
    }

    private TreeMap<String, Airline> getTestAirlines(){
        TreeMap<String, Airline> airlines = new TreeMap<String, Airline>();
        try{
            Destination localAirport = new Destination("Istanbul Airport",(double)1234, (double)4321);
            AirlineAdmin airlineAdmin = null;
            MapGraph ways = new MapGraph(80, true);
            ArrayList<Destination> destinations = new ArrayList<Destination>();
            AirlineSystemStorage aiss = new AirlineSystemStorage(airlineAdmin, "TRD", "888", ways, destinations);
            airlineAdmin = new AirlineAdmin("Jack", "Blue", aiss);

            Destination localAirport1 = new Destination("Ankara Airport", (double)3456, (double)6543);
            AirlineAdmin airlineAdmin1 = null;
            MapGraph ways1 = new MapGraph(90, true);
            ArrayList<Destination> destinations1 = new ArrayList<Destination>();
            AirlineSystemStorage aiss1 = new AirlineSystemStorage(airlineAdmin1, "TRD1", "888", ways1, destinations1);
            airlineAdmin = new AirlineAdmin("Mark", "Red", aiss1);

            Destination localAirport2 = new Destination("London Airport", (double)3456, (double)6543);
            AirlineAdmin airlineAdmin2 = null;
            MapGraph ways2 = new MapGraph(120, true);
            ArrayList<Destination> destinations2 = new ArrayList<Destination>();
            AirlineSystemStorage aiss2 = new AirlineSystemStorage(airlineAdmin2, "TRD2", "777", ways2, destinations2);
            airlineAdmin = new AirlineAdmin("James", "Yellow", aiss2);

            Destination localAirport3 = new Destination("Melbourne Airport", (double)3456, (double)6543);
            AirlineAdmin airlineAdmin3 = null;
            MapGraph ways3 = new MapGraph(120, true);
            ArrayList<Destination> destinations3 = new ArrayList<Destination>();
            AirlineSystemStorage aiss3 = new AirlineSystemStorage(airlineAdmin3, "TRD3", "544", ways3, destinations3);
            airlineAdmin = new AirlineAdmin("Jack", "Purple", aiss3);

            airlines.put("123", new Airline(localAirport, (double)444, airlineAdmin, "TradeMarkName", "123", ways, destinations));
            airlines.put("456", new Airline(localAirport1, (double)555, airlineAdmin1, "TradeMarkName1", "456", ways1, destinations1));
            airlines.put("131", new Airline(localAirport2, (double)535, airlineAdmin2, "TradeMarkName2", "131", ways2, destinations2));
            airlines.put("299", new Airline(localAirport3, (double)535, airlineAdmin3, "TradeMarkName3", "299", ways3, destinations3));

            return airlines;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public GUI(){

        //Airport airport = new Airport(AirportName);
        AirportSystemStorage portStorage = new AirportSystemStorage();
        AirportAdmin portAdmin = new AirportAdmin(portAdminName,portAdminSurname,portAdminSSN,portAdminPassword,portStorage);


        try{
                frame.setSize(1920, 1080);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);//set center

                JPanel panel = new JPanel();
                frame.add(panel);
                panel.setLayout(null);
                panel.setBackground(Main);

                JLabel a = new JLabel("label");
                a.setText("WELCOME TO DATA AIRPORT");
                a.setForeground(Landing_COLOR);
                a.setBounds(530, 130, 1000, 55);
                Font font = new Font("Arial", Font.BOLD, 50);
                a.setFont(font);
                panel.add(a);


                Icon icon = new ImageIcon("src/Pictures/3.gif");
                JLabel label = new JLabel(icon);
                label.setBounds(0, 200, 400, 200); // for example, you can use your own values
                panel.add(label);

                JButton Login = new JButton("LOGIN");
                Login.setBounds(470, 330, 150, 25);
                panel.add(Login);

                frame.setVisible(true);

                Login.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        LOGIN();
                    }
                });//go to login page

                JButton Guest = new JButton("GUEST");
                Guest.setBounds(470, 300, 150, 25);
                panel.add(Guest);
                Guest.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        GUEST();
                    }
                });//go to guest page.

                //logo mouse click event
                LogoMouseListener logoMouseListener = new LogoMouseListener(frame, panel);
                //***************************************************
            }catch (Exception e){
                System.out.println(e);
            }
        }
}