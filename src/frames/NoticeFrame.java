package frames;

import javax.swing.*;
import java.awt.*;

public class NoticeFrame extends JFrame {
    private JPanel mainPanel;

    public NoticeFrame(String massage){
        super("ERROR");
        setMinimumSize(new Dimension(450, 100));
        setLayout(new BorderLayout(10, 10));
        JLabel massageText = new JLabel(massage);
        massageText.setFont(new Font("TimesRoman", Font.BOLD, 20));
        massageText.setLayout(new FlowLayout(FlowLayout.CENTER));
        setContentPane(massageText);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}


