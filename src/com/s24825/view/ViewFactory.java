package com.s24825.view;

import com.s24825.controller.BaseController;
import com.s24825.controller.GameWindowController;
import com.s24825.controller.MainMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStages;
    private Styles styles = Styles.MEDIUM;

    public ViewFactory() {
        this.activeStages = new ArrayList<>();
    }

    public void showMainMenu() {
        BaseController mainMenu = new MainMenuController(this, "MainMenu.fxml");
        initializeStages(mainMenu);

    }

    public void showGameWindow() {
        BaseController gameWindow = new GameWindowController(this, "GameWindow.fxml");
        initializeStages(gameWindow);
    }

    private void initializeStages (BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource(Styles.getCssPath(styles)).toExternalForm());
        stage.setMinHeight(400);
        stage.setMinWidth(500);
        stage.setResizable(false);

        parent.requestFocus();
        stage.show();

        activeStages.add(stage);
    }

    public void closeStage (Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }
}
