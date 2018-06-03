package com.Threads;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    private MainThread mainThread = new MainThread();

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
            mainThread.createPlanet("Earth");
            String s1 = String.valueOf(mainThread.getPln());
            mainThread.createPlanet("Saturn");
            String s2 = String.valueOf(mainThread.getPln());
            mainThread.createPlanet("Mars");
            String s3 = String.valueOf(mainThread.getPln());
            mainThread.start();
            try {
                mainThread.join();
                planetsField.setVisible(true);
                String str = String.valueOf(mainThread.getGm());
                planetsField.setText(s1+" "+str+"\n"+s2+" "+str+"\n"+s3+" "+str+"\n");
            }catch (InterruptedException exc){
                System.out.println("Main thread interrupted");
            }

            startButton.setVisible(true);
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