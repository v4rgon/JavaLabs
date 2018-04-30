package com.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{

    private JTextArea characterStats=new JTextArea("Race:\nSpecialisation\nLevel\nCordinates");
    private JLabel Hero = new JLabel("Active user: player");
    private JLabel firstQuest = new JLabel("First Quest: You should travel to ..."),
            questLabel = new JLabel("Quest"),
            secondQuest = new JLabel("Kill 5 monsters");
    private JButton acceptButton = new JButton("Accept"),
    goButton = new JButton("Go"),
    killButton = new JButton("Kill");


    private Hero hero;
    private Location locate;

    //private boolean flag = true;

    /**
     * Конструктор для создания экземпляра класс <b>My GUI</b>
     * @param _name
     */
    public GUI(String _name) {
        super(_name);
       setBounds(-50, 0, 500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gbl);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(0,10,0,0);
        gbl.setConstraints(characterStats, c);
        add(characterStats);

        acceptButton.addActionListener(new acceptTravelQuest ());
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(1, 10, 5, 5);
        gbl.setConstraints(acceptButton, c);
        add(acceptButton);

        c.gridx = 2;
        c.gridy = 0;
        gbl.setConstraints(questLabel, c);
        add(questLabel);

        c.gridx = 0;
        c.gridy = 0;
        gbl.setConstraints(firstQuest,c);
        add(firstQuest);
        firstQuest.setVisible(false);


        c.gridy=1;
        c.gridx=0;
        gbl.setConstraints(goButton,c);
        add(goButton);
        goButton.setVisible(false);

    }
    public class acceptTravelQuest implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                hero.getQuest('t');
                characterStats.setVisible(false);
                acceptButton.setVisible(false);
                questLabel.setVisible(false);
            firstQuest.setVisible(true);
            goButton.setVisible(true);
            goButton.addActionListener(new travelButton ());

        }
    }
    public class travelButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }
}
