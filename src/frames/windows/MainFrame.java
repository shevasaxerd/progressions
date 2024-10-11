package frames.windows;

import models.Exponential;
import models.Liner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends JFrame {

    private final JPanel progressionPanel;
    private final JPanel centralPanel;
    private final JPanel inputPanel1;
    private final JPanel inputPanel2;
    private final JPanel inputPanel3;
    private final JPanel inputPanel;
    private final JPanel operationPanel;
    private final JPanel resultPanel;
    private final JComboBox<String> progressionComboBox;
    private final JTextField firstElementField;
    private final JTextField ratioField;
    private final JTextField nElementField;
    private final JButton calculateNthElementButton;
    private final JButton calculateSumButton;
    private final JButton outputAllButton;
    private final JButton outputInFileButton;
    //private final JLabel resultLabel;
    private final  JTextArea textArea;



    public MainFrame(Liner liner, Exponential exponential) {
        super("Progressions");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 400);
        setLayout(new BorderLayout(10, 10));
        progressionPanel = new JPanel();
        centralPanel = new JPanel();
        inputPanel1 = new JPanel();
        inputPanel2 = new JPanel();
        inputPanel3 = new JPanel();
        inputPanel = new JPanel();
        operationPanel = new JPanel();
        resultPanel = new JPanel();
        String[] progressions = new String[]{"Exponential", "Linear"};
        progressionComboBox = new JComboBox<>(progressions);
        firstElementField = new JTextField(10);
        ratioField = new JTextField(10);
        nElementField = new JTextField(10);
        calculateNthElementButton = new JButton("Output N-th element");
        calculateSumButton = new JButton("Output sum of progression");
        outputAllButton = new JButton("Output all elements of progression");
        outputInFileButton = new JButton("Write progression to file");
        //resultLabel = new JLabel("Result: ");
        textArea = new JTextArea("Result: ", 1, 45);


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
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);
        textArea.setFont(BigFontTR);
        textArea.setLineWrap(false);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        resultPanel.add(scrollPane);
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
                    textArea.setText(String.format("Result: %d", result));

                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
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
                    textArea.setText(String.format("Result: %s", result));

                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
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
                    textArea.setText(String.format("Result: %d", result));

                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
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
                    textArea.setText("Result: progression successfully written to file");

                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
                }
            }
        });}


}
