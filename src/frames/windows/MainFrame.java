package frames.windows;

import models.Exponential;
import models.Liner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends JFrame {

    JPanel progressionPanel = new JPanel();
    JPanel centralPanel = new JPanel();
    JPanel inputPanel1 = new JPanel();
    JPanel inputPanel2 = new JPanel();
    JPanel inputPanel3 = new JPanel();
    JPanel inputPanel = new JPanel();
    JPanel operationPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    String[] progressions = {"Exponential", "Linear"};
    JComboBox<String> progressionComboBox = new JComboBox<>(progressions);
    JTextField firstElementField = new JTextField(10);
    JTextField ratioField = new JTextField(10);
    JTextField nElementField = new JTextField(10);
    JButton calculateNthElementButton = new JButton("Output N-th element");
    JButton calculateSumButton = new JButton("Output sum of progression");
    JButton outputAllButton = new JButton("Output all elements of progression");
    JButton outputInFileButton = new JButton("Write progression to file");
    JLabel resultLabel = new JLabel("Result: ");




    public MainFrame(Liner liner, Exponential exponential) {
        super("Progressions");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 400);
        setLayout(new BorderLayout(10, 10));


       AllNorthPanel();
       AllCentralPanel();
       AllSouthPanel();

       button1(liner, exponential);
       button2(liner, exponential);
       button3(liner, exponential);
       button4(liner, exponential);

       setVisible(true);

    }

    void AllNorthPanel(){
        progressionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        progressionPanel.add(new JLabel("Choose progression:"));
        progressionPanel.add(progressionComboBox);
        add(progressionPanel, BorderLayout.NORTH);
    }
    void AllSouthPanel(){
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);
        resultLabel.setFont(BigFontTR);
        resultPanel.add(resultLabel);
        add(resultPanel, BorderLayout.SOUTH);
    }
    void AllCentralPanel(){
        centralPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        inputPanel1.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel1.add(new JLabel("First element:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel1.add(firstElementField, gbc);


        inputPanel2.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel2.add(new JLabel("Coefficient:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel2.add(ratioField, gbc);


        inputPanel3.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel3.add(new JLabel("N-th element:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel3.add(nElementField, gbc);


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



        gbc.gridx = 0;
        gbc.gridy = 2;
        centralPanel.add(operationPanel, gbc);
        inputPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.SOUTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        calculateNthElementButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(calculateNthElementButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        calculateSumButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(calculateSumButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        outputAllButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(outputAllButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        outputInFileButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(outputInFileButton, gbc);

        add(centralPanel, BorderLayout.CENTER);
    }
    void button1(Liner liner,Exponential exponential){
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
    }
    void button2(Liner liner,Exponential exponential){
        outputAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int firstElement = Integer.parseInt(firstElementField.getText());
                    int coefficient = Integer.parseInt(ratioField.getText());
                    int index = Integer.parseInt(nElementField.getText());
                    String result="";

                    if (Objects.equals(progressionComboBox.getSelectedItem(), "Exponential")) {
                        result = exponential.toString(firstElement, index, coefficient);

                    } else if (Objects.equals(progressionComboBox.getSelectedItem(), "Linear")) {
                        result = liner.toString(firstElement, index, coefficient);

                    }
                    resultLabel.setText(String.format("Result: %s", result));

                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error");
                }
            }
        });
    }
    void button3(Liner liner,Exponential exponential){
        calculateSumButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int firstElement = Integer.parseInt(firstElementField.getText());
                int coefficient = Integer.parseInt(ratioField.getText());
                int index = Integer.parseInt(nElementField.getText());
                int result=0;

                if (Objects.equals(progressionComboBox.getSelectedItem(), "Exponential")) {
                    result = exponential.sumOfProgression(firstElement, index, coefficient);

                } else if (Objects.equals(progressionComboBox.getSelectedItem(), "Linear")) {
                    result = liner.sumOfProgression(firstElement, index, coefficient);

                }
                resultLabel.setText(String.format("Result: %d", result));

            } catch (NumberFormatException ex) {
                resultLabel.setText("Error");
            }
        }
    });}
    void button4(Liner liner,Exponential exponential){
        outputInFileButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int firstElement = Integer.parseInt(firstElementField.getText());
                int coefficient = Integer.parseInt(ratioField.getText());
                int index = Integer.parseInt(nElementField.getText());


                if (Objects.equals(progressionComboBox.getSelectedItem(), "Exponential")) {
                    exponential.exportInFile(firstElement, index, coefficient);
                } else if (Objects.equals(progressionComboBox.getSelectedItem(), "Linear")) {
                    liner.exportInFile(firstElement, index, coefficient);
                }
                resultLabel.setText("Result: progression successfully written to file");

            } catch (NumberFormatException ex) {
                resultLabel.setText("Error");
            }
        }
    });}


}


