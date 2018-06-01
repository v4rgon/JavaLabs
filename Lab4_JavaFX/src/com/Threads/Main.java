package com.Threads;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();


        Label planetsField = new Label(" ");
        Button startButton = new Button("start");

        //planetsField
        AnchorPane.setBottomAnchor(planetsField,60.0);
        AnchorPane.setLeftAnchor(planetsField,20.0);
        AnchorPane.setRightAnchor(planetsField,20.0);
        AnchorPane.setTopAnchor(planetsField,20.0);

        //startButton
        AnchorPane.setBottomAnchor(startButton,0.0);
        AnchorPane.setLeftAnchor(startButton,175.0);
        AnchorPane.setRightAnchor(startButton,175.0);
        AnchorPane.setTopAnchor(startButton,150.0);

        root.getChildren().addAll(startButton,planetsField);

        startButton.setOnAction((event)->{

                startButton.setVisible(false);
                planetsField.setVisible(true);
                System.out.println(" Main Thread starting");

                PlanetThreads pl1 = new PlanetThreads("Earth");
                pl1.start();
                PlanetThreads pl2 = new PlanetThreads("Saturn");
                pl2.start();
                PlanetThreads pl3 = new PlanetThreads("Mars");
                pl3.start();
                try{
                    pl1.join();
                    System.out.println(pl1.getPlanetName()+" joined");
                    pl2.join();
                    System.out.println(pl2.getPlanetName()+" joined");
                    pl3.join();
                    System.out.println(pl3.getPlanetName()+" joined");

                        String str = String.valueOf(pl1.getPlanetName() + " " + pl1.getGm() + " Day " + pl1.getDay() + "\n" + pl2.getPlanetName() + " " + pl2.getGm() + " Day " + pl2.getDay() + "\n" + pl3.getPlanetName() + " " + pl3.getGm() + " Day " + pl3.getDay() + "\n");
                        planetsField.setText(str);
                    if(pl1.getYear()!=0) {
                        String str1 = String.valueOf(pl1.getPlanetName()+" " + pl1.getNw()+"\n"+pl2.getPlanetName()+" "+pl2.getNw()+"\n"+pl3.getPlanetName()+" Year "+pl3.getNw()+"\n");
                        planetsField.setText(str + str1);
                    }
                }catch (InterruptedException exc){
                    System.out.println("Main Thread interrupted");
                }

                System.out.println("Main Thread ending");

        });

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Thread Planets");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}