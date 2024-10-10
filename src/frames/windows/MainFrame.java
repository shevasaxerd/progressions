package frames.windows;

import models.Exponential;
import models.Liner;
import models.Liner;
import models.Series;
import models.Exponential;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends JFrame {

    Liner liner = new Liner();
    Exponential exponential = new Exponential();


    public MainFrame() {
        super("Progressions");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 400);
        setLayout(new BorderLayout(10, 10));


        JPanel progressionPanel = new JPanel();
        progressionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] progressions = {"Exponential", "Linear"};
        JComboBox<String> progressionComboBox = new JComboBox<>(progressions);

        progressionPanel.add(new JLabel("Choose progression:"));
        progressionPanel.add(progressionComboBox);
        add(progressionPanel, BorderLayout.NORTH);


        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel inputPanel1 = new JPanel();
        inputPanel1.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel1.add(new JLabel("First element:"), gbc);
        JTextField firstElementField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel1.add(firstElementField, gbc);

        JPanel inputPanel2 = new JPanel();
        inputPanel2.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel2.add(new JLabel("Coefficient:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        JTextField ratioField = new JTextField(10);
        inputPanel2.add(ratioField, gbc);

        JPanel inputPanel3 = new JPanel();
        inputPanel3.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel3.add(new JLabel("N-th element:"), gbc);
        JTextField nElementField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel3.add(nElementField, gbc);


        JPanel inputPanel = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(inputPanel1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(inputPanel2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        inputPanel.add(inputPanel3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        centralPanel.add(inputPanel, gbc);


        JPanel operationPanel = new JPanel();
        gbc.gridx = 0;
        gbc.gridy = 2;
        centralPanel.add(operationPanel, gbc);
        inputPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.SOUTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton calculateNthElementButton = new JButton("Output N-th element");
        calculateNthElementButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(calculateNthElementButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JButton calculateSumButton = new JButton("Output sum of progression");
        calculateSumButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(calculateSumButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        JButton outputAllButton = new JButton("Output all elements of progression");
        outputAllButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(outputAllButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        JButton outputInFileButton = new JButton("Write progression to file");
        outputInFileButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(outputInFileButton, gbc);

        add(centralPanel, BorderLayout.CENTER);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setFont(BigFontTR);

        resultPanel.add(resultLabel);
        add(resultPanel, BorderLayout.SOUTH);

        calculateNthElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int firstElement = Integer.parseInt(firstElementField.getText());
                    int coefficient = Integer.parseInt(ratioField.getText());
                    int index = Integer.parseInt(nElementField.getText());
                    int result=0;

                    if (Objects.equals(progressionComboBox.getSelectedItem(), "Exponential")) {
                       result = exponential.getElement(firstElement, index, coefficient);

                    } else if (Objects.equals(progressionComboBox.getSelectedItem(), "Linear")) {
                        result = liner.getElement(firstElement, index, coefficient);

                    }
                    resultLabel.setText(String.format("Result: %d", result));

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error");
                }
            }
        });


        setVisible(true);

    }
}


