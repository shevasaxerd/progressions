package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeFrame extends JFrame {


    public NoticeFrame(){
        JOptionPane.showMessageDialog(null, "You have entered incorrect values!\n" + "Try again!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public NoticeFrame(String fileName){
        JOptionPane.showMessageDialog(null, "File " + fileName + ".txt has successfully saved in location", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

}


