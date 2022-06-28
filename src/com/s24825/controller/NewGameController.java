package com.s24825.controller;

import com.s24825.Settings;
import com.s24825.model.Engine;
import com.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NewGameController extends BaseController {

    @FXML
    void sendSettingsBtn(MouseEvent event) {
        settings.setSpeed(Integer.parseInt(speedField.getText()));
        settings.setColumns(Integer.parseInt(sizeField.getText()));
        settings.setRows(Integer.parseInt(sizeField.getText()));
        Stage stage = (Stage) sizeField.getScene().getWindow();

        viewFactory.showGameWindow();
        viewFactory.closeStage(stage);

    }

    @FXML
    private TextField sizeField;

    @FXML
    private TextField speedField;

    public NewGameController(ViewFactory viewFactory, String fxmlName, Settings settings) {
        super(viewFactory, fxmlName, settings);
    }


}
