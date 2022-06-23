package com.s24825.controller;

import com.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends BaseController implements Initializable{

    public MainMenuController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView highScoresButton;

    @FXML
    private ImageView newGameButton;

    @FXML
    private ImageView optionsButton;



    @FXML
    void exitNotHover(MouseEvent event) {
        dropShadowOff(event);

    }

    @FXML
    void exitOnClicked(MouseEvent event) {

    }

    @FXML
    void exitOnHover(MouseEvent event) {
        dropShadowOn(event);

    }



    @FXML
    void highScoresClicked(MouseEvent event) {

    }

    @FXML
    void highScoresNotHover(MouseEvent event) {
        dropShadowOff(event);

    }

    @FXML
    void highScoresOnHover(MouseEvent event) {
        dropShadowOn(event);

    }



    @FXML
    void newGameClicked(MouseEvent event) {
        Stage stage = (Stage) newGameButton.getScene().getWindow();

        viewFactory.showGameWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void newGameNotHover(MouseEvent event) {
        dropShadowOff(event);
    }

    @FXML
    void newGameOnHover(MouseEvent event) {
        dropShadowOn(event);

    }

    @FXML
    void optionsMouseClicked(MouseEvent event) {

    }

    @FXML
    void optionsNotHover(MouseEvent event) {
        dropShadowOff(event);

    }

    @FXML
    void optionsOnHover(MouseEvent event) {
        dropShadowOn(event);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void dropShadowOn (MouseEvent event) {

        ImageView source = (ImageView) event.getSource();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(4);
        dropShadow.setOffsetY(6);
        dropShadow.setColor(Color.BLACK);

        source.setEffect(dropShadow);
    }

    private void dropShadowOff (MouseEvent event) {
        ImageView source = (ImageView) event.getSource();
        source.setEffect(null);
    }

}
