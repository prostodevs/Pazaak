/*
 * Title screen should have 3 buttons for options
 * 1. Play - setVisible to false and create a new GameBoard JFrame
 * 2. Read Rules - setVisible to false and create a new rules JFrame
 * 3. Exit - dispose of the frame and end the loop
 */


package com.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitleScreen implements ActionListener {
    JFrame frame = new JFrame();
    JButton play = new JButton();
    JButton rules = new JButton();
    JButton exit = new JButton();

    public TitleScreen() {
        // set up the frame // RE-USE FOR EACH 'WINDOW' //
        frame.setTitle("SDE6-7.2022 Pazaakas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 750);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        //Banner setup
        JPanel banner = new JPanel();
        banner.setPreferredSize(new Dimension(100,100));
        try{
            BufferedImage imageImport = ImageIO.read(new File("data/attonRand.jpg"));
            JLabel bannerImage = new JLabel(new ImageIcon(imageImport));
            frame.add(bannerImage, BorderLayout.NORTH);
        }catch (IOException e){
            e.printStackTrace();
        }

        //Menu option setup
        JPanel menu = new JPanel(); //this will create the label for our buttons
        menu.setBackground(Color.lightGray);
        menu.setPreferredSize(new Dimension(100, 325));

        frame.add(menu, BorderLayout.SOUTH);

        menu.setLayout(new FlowLayout(FlowLayout.CENTER,500,10));
        menu.add(play);
        menu.add(rules);
        menu.add(exit);

        //play button setup
        play.setSize(200,100);
        play.setHorizontalTextPosition(JButton.CENTER);
        play.setVerticalTextPosition(JButton.CENTER);
        play.addActionListener(this);
        play.setText("New Match");

        //rule display setup
        rules.setBounds(275, 130, 200, 100);
        rules.addActionListener(this);
        rules.setHorizontalTextPosition(JButton.CENTER);
        rules.setVerticalTextPosition(JButton.CENTER);
        rules.setText("Read the Rules");

        //exit program
        exit.setBounds(275, 235, 200, 100);
        exit.addActionListener(this);
        exit.setHorizontalTextPosition(JButton.CENTER);
        exit.setVerticalTextPosition(JButton.CENTER);
        exit.setText("Exit");


        frame.setVisible(true); // ALWAYS leave for last (so everything shows up)
    }

    @Override
    public void actionPerformed(ActionEvent e) { // if button pressed, 'close' this window and reveal the one pressed
        if (e.getSource() == play) {
            frame.dispose();
            new GameBoard();
        }

        if (e.getSource() == rules) {
            frame.dispose();
            new Rules();
        }

        if (e.getSource() == exit) {
            //Forces a 'window close' event (ending the whole program)
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
