package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import static com.game.SwingConsole.run;

public class GUI extends JFrame{

    private JTextArea heroStats = new JTextArea("Race:\nSpecialization:\nLevel\nLoacation: X: Y: \n");
    private JLabel firstQuest = new JLabel("You should travel to "),
            questLabel = new JLabel("Quest"),
            secondQuest = new JLabel("Kill zergs");
    private JButton acceptButtonK = new JButton("Accept"),
                    acceptButtonT = new JButton("Accept"),
                    goButton = new JButton("Go"),
                    killButton = new JButton("Kill");
    private Hero hero = new Hero();
    private Location locate = new Location(1,1);
    private TravelQuest tq = new TravelQuest(new Location(12,23),14f);
    private KillingQuest kq = new KillingQuest("Zerg",0);
    private Quests quests = new Quests();

    //private boolean flag = true;

    /**
     * Конструктор для создания экземпляра класс <b> GUI</b>
     * @param _name
     */
    public GUI(String _name) {
        super(_name);
        setBounds(200, 200, 500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hero.setRace("Elf");
        hero.setSpecialization("Archer");
        hero.setLevel(1);
        hero.setLocation(2,3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gbl);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(0, 10, 0, 0);
        gbl.setConstraints(heroStats, c);
        add(heroStats);
        kq.setMonsterCount(12);
        heroStats.setText("Race: " +hero.getRace() + "\nSpecialization: " + hero.getSpecialization() +"\nLevel: " + hero.getLevel() + "\nLocation: X: " + hero.getLocationX() +" Y: " + hero.getLocationY());

        acceptButtonT.addActionListener(new acceptTravelQuestButton());
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(1, 10, 5, 5);
        gbl.setConstraints(acceptButtonT, c);
        add(acceptButtonT);

        acceptButtonK.addActionListener(new acceptKillQuestButton());
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(1, 10, 5, 5);
        gbl.setConstraints(acceptButtonK, c);
        add(acceptButtonK);
        acceptButtonK.setVisible(false);

        c.gridx = 2;
        c.gridy = 0;
        gbl.setConstraints(questLabel, c);
        add(questLabel);

        c.gridx =2;
        c.gridy = 0;
        gbl.setConstraints(firstQuest, c);
        add(firstQuest);
        firstQuest.setVisible(false);

        c.gridx=2;
        c.gridy=0;
        gbl.setConstraints(secondQuest,c);
        add(secondQuest);
        secondQuest.setVisible(false);

        goButton.addActionListener(new goButtonOnClick());
        c.gridy = 2;
        c.gridx = 2;
        c.anchor =GridBagConstraints.CENTER;
        gbl.setConstraints(goButton, c);
        add(goButton);
        goButton.setVisible(false);

        killButton.addActionListener(new killButtonOnClick());
        c.gridy = 2;
        c.gridx = 2;
        c.anchor =GridBagConstraints.CENTER;
        gbl.setConstraints(killButton, c);
        add(killButton);
        killButton.setVisible(false);
    }

     class acceptKillQuestButton implements ActionListener{
        @Override
         public void actionPerformed(ActionEvent e){


            questLabel.setVisible(false);
            acceptButtonK.setVisible(false);
            secondQuest.setVisible(true);
            secondQuest.setText("Kill "+kq.getMonsterCount() +" " + kq.getMonster());
            killButton.setVisible(true);

        }
     }
    class acceptTravelQuestButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            heroStats.setVisible(true);
            questLabel.setVisible(false);
         acceptButtonT.setVisible(false);
         firstQuest.setVisible(true);
         firstQuest.setText("\nFirst Quest: You should travel to \n"+ tq.getLocationX() + " "+tq.getLocationY() +" "+ tq.getTime());
         goButton.setVisible(true);

        }
    }

   class killButtonOnClick implements ActionListener{
       @Override
       public void actionPerformed(ActionEvent e){

           secondQuest.setVisible(true);
           if(kq.checkQuest() != quests.endQuest())
           kq.killMonster();

           else {
               hero.setLevel(hero.getLevel()+1);
               questLabel.setVisible(true);
               acceptButtonT.setVisible(true);
               secondQuest.setVisible(false);
               killButton.setVisible(false);
           }
           secondQuest.setText("Kill "+kq.getMonsterCount() +" " + kq.getMonster());
           heroStats.setText("Race: " +hero.getRace() + "\nSpecialization: " + hero.getSpecialization() +"\nLevel: " + hero.getLevel() + "\nLocation: X: " + hero.getLocationX() +" Y: " + hero.getLocationY());

       }
   }

   class goButtonOnClick implements ActionListener{
        @Override
       public void actionPerformed(ActionEvent e)
        {
            if(tq.checkCordinates(new Location(tq.getLocationX(),tq.getLocationY()))==quests.endQuest()){
            hero.travel(new Location(tq.getLocationX(),tq.getLocationY()));

                heroStats.setVisible(true);
                questLabel.setVisible(true);
                acceptButtonK.setVisible(true);
                firstQuest.setVisible(false);
                goButton.setVisible(false);
            }
            firstQuest.setText("\nFirst Quest: You should travel to \n"+ tq.getLocationX() + " "+tq.getLocationY() +" "+ tq.getTime());
            heroStats.setText("Race: " +hero.getRace() + "\nSpecialization: " + hero.getSpecialization() +"\nLevel: " + hero.getLevel() + "\nLocation: X: " + hero.getLocationX() +" Y: " + hero.getLocationY());

        }
   }



    public static void main(String[] args) {
        GUI myGUI = new GUI("Hero");
        myGUI.setVisible(true);
     }
    }