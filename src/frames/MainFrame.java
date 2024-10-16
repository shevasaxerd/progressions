package frames;

import models.Series;
import models.Exponential;
import models.Liner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainFrame extends JFrame {

    private JPanel centralPanel;
    private JPanel inputAllParametersPanel;
    private final String[] progressions = new String[]{"Exponential", "Linear"};
    private JComboBox<String> progressionComboBox;
    private JTextField firstElementField;
    private JTextField ratioField;
    private JTextField nElementField;
    private JButton calculateNthElementButton;
    private JButton calculateSumButton;
    private JButton outputAllButton;
    private JButton outputInFileButton;
    private JTextArea textArea;
    private final Series liner;
    private final Series exponential;
    private Series current;



    public MainFrame(Series liner, Series exponential) {
        super("Progressions");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 400);
        setLayout(new BorderLayout(10, 10));
        this.liner = liner;
        this.exponential = exponential;
        current = this.exponential;



        initProgressionPanel();
        initParametersPanel();
        initResultPanel();
        initCalculateNthElementButton();
        initOutputAllButton();
        initCalculateSumButton();
        initOutputInFileButton();
        ButtonsPanel();
        setVisible(true);

    }

    void initProgressionPanel(){
        JPanel progressionPanel = new JPanel();
        progressionComboBox = new JComboBox<>(progressions);
        progressionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        progressionPanel.add(new JLabel("Choose progression:"));
        progressionPanel.add(progressionComboBox);
       progressionComboBox.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                if (Objects.equals(progressionComboBox.getSelectedItem(), "Linear")) {
                        current = liner;
                    } else if (Objects.equals(progressionComboBox.getSelectedItem(), "Exponential")) {
                    current = exponential;
                    }
            }
        });
        add(progressionPanel, BorderLayout.NORTH);
    }
    void initResultPanel(){
        textArea = new JTextArea("Result: ", 1, 45);
        JPanel resultPanel = new JPanel();
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
    void initParametersPanel(){
        centralPanel = new JPanel();
        centralPanel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);


        JPanel inputFirstElementPanel = new JPanel();
        firstElementField = new JTextField(10);
        inputFirstElementPanel.setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        inputFirstElementPanel.add(new JLabel("First element:"), gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        inputFirstElementPanel.add(firstElementField, gridBagConstraints);


        JPanel inputCoefficientPanel = new JPanel();
        ratioField = new JTextField(10);
        inputCoefficientPanel.setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        inputCoefficientPanel.add(new JLabel("Coefficient:"), gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        inputCoefficientPanel.add(ratioField, gridBagConstraints);


        JPanel inputNthElementPanel = new JPanel();
        nElementField = new JTextField(10);
        inputNthElementPanel.setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        inputNthElementPanel.add(new JLabel("N-th element:"), gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        inputNthElementPanel.add(nElementField, gridBagConstraints);


        inputAllParametersPanel = new JPanel();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        inputAllParametersPanel.add(inputFirstElementPanel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        inputAllParametersPanel.add(inputCoefficientPanel, gridBagConstraints);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        inputAllParametersPanel.add(inputNthElementPanel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        centralPanel.add(inputAllParametersPanel, gridBagConstraints);

    }
    void ButtonsPanel(){

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        JPanel operationPanel = new JPanel();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        centralPanel.add(operationPanel, gridBagConstraints);
        inputAllParametersPanel.setLayout(new GridBagLayout());
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.SOUTH;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        calculateNthElementButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(calculateNthElementButton, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        calculateSumButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(calculateSumButton, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        outputAllButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(outputAllButton, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        outputInFileButton.setPreferredSize(new Dimension(250, 50));
        operationPanel.add(outputInFileButton, gridBagConstraints);

        add(centralPanel, BorderLayout.CENTER);
    }

    void initCalculateNthElementButton(){
        calculateNthElementButton = new JButton("Output N-th element");
        calculateNthElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int firstElement = Integer.parseInt(firstElementField.getText());
                    int coefficient = Integer.parseInt(ratioField.getText());
                    int index = Integer.parseInt(nElementField.getText());
                    int result = current.getElement(firstElement, index, coefficient);
                    textArea.setText(String.format("Result: %d", result));
                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
                }
            }
        });
    }
    void initOutputAllButton(){
        outputAllButton = new JButton("Output all elements of progression");
        outputAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int firstElement = Integer.parseInt(firstElementField.getText());
                    int coefficient = Integer.parseInt(ratioField.getText());
                    int index = Integer.parseInt(nElementField.getText());
                    String result = current.toString(firstElement, index, coefficient);
                    textArea.setText(String.format("Result: %s", result));
                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
                }
            }
        });
    }
    void initCalculateSumButton(){
        calculateSumButton = new JButton("Output sum of progression");
        calculateSumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int firstElement = Integer.parseInt(firstElementField.getText());
                    int coefficient = Integer.parseInt(ratioField.getText());
                    int index = Integer.parseInt(nElementField.getText());
                    int result = current.sumOfProgression(firstElement, index, coefficient);
                    textArea.setText(String.format("Result: %d", result));
                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
                }
            }
        });}
    void initOutputInFileButton(){
        outputInFileButton = new JButton("Write progression to file");
        outputInFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int firstElement = Integer.parseInt(firstElementField.getText());
                    int coefficient = Integer.parseInt(ratioField.getText());
                    int index = Integer.parseInt(nElementField.getText());
                    current.exportInFile(firstElement, index, coefficient);
                    textArea.setText("Result: progression successfully written to file");
                } catch (NumberFormatException ex) {
                    textArea.setText("Error");
                }
            }
        });}



}

