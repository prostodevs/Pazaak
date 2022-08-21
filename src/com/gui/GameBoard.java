package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard implements ActionListener {
    JFrame frame = new JFrame();
    JButton playAgain = new JButton();
    JButton placeholder = new JButton();

    GameBoard() {
        // set up the frame // RE-USE FOR EACH 'WINDOW' //
        frame.setLayout(new FlowLayout());
        ImageIcon image1 = new ImageIcon("data/windowCard20-20.jpg"); //create the image icon
        frame.setIconImage(image1.getImage()); //change default icon to image1
        frame.setTitle("SDE6-7.2022 Pazaakas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //TODO-----TITLE PANEL CREATED HERE-----// -----SEE UPDATED UML FOR SKETCH
        JPanel title = new JPanel();

        //TODO-----PLAYER WIN COUNT FRAME CREATED HERE-----//
        JPanel userWinCount = new JPanel();

        //TODO-----COMPUTER WIN COUNT FRAME CREATED HERE-----//
        JPanel compWinCount = new JPanel();

        //TODO-----PLAYER CARD MAT FRAME CREATED HERE-----//
        JPanel userMat = new JPanel();

        //TODO-----COMPUTER CARD MAT FRAME CREATED HERE-----//
        JPanel compMat = new JPanel();

        //TODO-----PLAYER HAND CARD FRAME CREATED HERE-----//
        JPanel userHandMat = new JPanel();

        //TODO-----COMPUTER HAND CARD FRAME CREATED HERE-----//
        JPanel compHandMat = new JPanel();


//-----REMOVE AFTER FUNCTIONALITY PROVIDED TO OTHER FRAMES-----//
        placeholder.setSize(200, 100);
        placeholder.setHorizontalTextPosition(JButton.CENTER);
        placeholder.setVerticalTextPosition(JButton.CENTER);
        placeholder.addActionListener(this);
        placeholder.setText("PLACEHOLDER");
        frame.add(placeholder, BorderLayout.CENTER);
//-----REMOVE AFTER FUNCTIONALITY PROVIDED TO OTHER FRAMES-----//


        frame.add(title, BorderLayout.NORTH);
        frame.add(userWinCount, BorderLayout.WEST);
        frame.add(compWinCount, BorderLayout.EAST);
        frame.add(userMat, BorderLayout.CENTER);
        frame.add(compMat, BorderLayout.CENTER);
        frame.add(userHandMat, BorderLayout.SOUTH);
        frame.add(compHandMat, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == placeholder){
            frame.dispose();
            TitleScreen title = new TitleScreen();
        }

    }
}
