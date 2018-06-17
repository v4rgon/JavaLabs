package com.Window;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();


        RadioButton box = new RadioButton("State 1");
        RadioButton box1 = new RadioButton("State 2");
        RadioButton box2 = new RadioButton("State 3");

        ToggleGroup group = new ToggleGroup();
        box.setToggleGroup(group);
        box1.setToggleGroup(group);
        box2.setToggleGroup(group);
        //box
        AnchorPane.setBottomAnchor(box,110.0);
        AnchorPane.setLeftAnchor(box,20.0);
        AnchorPane.setRightAnchor(box,170.0);
        AnchorPane.setTopAnchor(box,20.0);

        //box1
        AnchorPane.setBottomAnchor(box1,80.0);
        AnchorPane.setLeftAnchor(box1,20.0);
        AnchorPane.setRightAnchor(box1,170.0);
        AnchorPane.setTopAnchor(box1,50.0);

        //box2
        AnchorPane.setBottomAnchor(box2,50.0);
        AnchorPane.setLeftAnchor(box2,20.0);
        AnchorPane.setRightAnchor(box2,170.0);
        AnchorPane.setTopAnchor(box2,80.0);

        Spinner<Integer> spinner = new Spinner<Integer>();

        final int initialValue = 1;

        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2, initialValue);

        spinner.setValueFactory(valueFactory);

        AnchorPane.setBottomAnchor(spinner,70.0);
        AnchorPane.setLeftAnchor(spinner,165.0);
        AnchorPane.setRightAnchor(spinner,20.0);
        AnchorPane.setTopAnchor(spinner,40.0);
        box2.setDisable(true);
        root.getChildren().addAll(box,box1,box2,spinner);




        Scene scene = new Scene(root, 250, 150);
        primaryStage.setTitle("Buttons");
        primaryStage.setScene(scene);
        primaryStage.show();

        box.setOnAction((event)->{
            valueFactory.setValue(1);
            box1.setSelected(false);
            box2.setSelected(false);
        });

        box1.setOnAction((event)->{
            valueFactory.setValue(2);
            box.setSelected(false);
            box2.setSelected(false);
        });

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                if(valueFactory.getValue()==1){
                    box.setSelected(true);
                    box1.setSelected(false);
                }
                if(valueFactory.getValue()==2){
                    box1.setSelected(true);
                    box.setSelected(false);
                }
            }
        });
    }




    public static void main(String[] args) {

        launch(args);
    }

}