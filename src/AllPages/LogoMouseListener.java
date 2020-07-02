package AllPages;
import javax.swing.*;
import java.awt.event.*;

class LogoMouseListener extends JFrame{
    LogoMouseListener(JFrame frame,JPanel panel){
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src/Pictures/logo.jpg"));
        label.setBounds(0,0,176,39);
        panel.add(label);
        frame.add(panel);
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                frame.setVisible(false);
                GUI homePage = new GUI();
            }
        });
    }
}