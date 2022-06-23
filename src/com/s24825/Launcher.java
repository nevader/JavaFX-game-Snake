package com.s24825;

import com.s24825.view.ViewFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showGameWindow();



    }
}
