package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Rules implements ActionListener {
    JFrame frame = new JFrame();
    JButton back = new JButton();

    public Rules() {
        // set up the frame // RE-USE FOR EACH 'WINDOW' //

        ImageIcon image1 = new ImageIcon("data/windowCard20-20.jpg"); //create the image icon
        frame.setIconImage(image1.getImage()); //change default icon to image1
        frame.setTitle("SDE6-7.2022 Pazaakas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //-----CREATE JTEXTAREA AND GET DATA FROM .TXT-----//
        JTextArea rules = new JTextArea();
        rules.setVisible(true);
        rules.setBackground(null);
        rules.setBorder(null);
        rules.setLineWrap(true);
        rules.setWrapStyleWord(true);
        rules.setFont(rules.getFont().deriveFont(14f)); // change font size to 14

        try {
            FileReader in = new FileReader("data/Rules.txt");
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                rules.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-----GET DATA FROM .TXT AND ADD TO JTEXTAREA-----//
        /*
        try {
            List<String> lines = Files.readAllLines(Path.of("data/Rules.txt"));
            for (String line : lines) {
                rules.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //-----CREATE A SCROLL PANE-----//
        JScrollPane scrollPane = new JScrollPane(rules);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setVisible(true);


        //-----CREATE THE BACK BUTTON AND ADD TO NEW PANEL-----//
        JPanel backButton = new JPanel();
        back.setSize(200, 100);
        back.setHorizontalTextPosition(JButton.CENTER);
        back.setVerticalTextPosition(JButton.CENTER);
        back.addActionListener(this);
        back.setText("Back to Menu");
        backButton.add(back);
        //-----CREATE THE BACK BUTTON AND ADD TO NEW PANEL-----//

        //-----ADD ALL COMPONENTS TO PARENT FRAME-----//
        frame.add(scrollPane, BorderLayout.NORTH);
        frame.add(backButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
            TitleScreen frame = new TitleScreen();
        }
    }
}
