package com.s24825.controller;

import com.s24825.model.Engine;
import com.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class GameWindowController extends BaseController implements Initializable {

    private Engine engine;
    private final DecimalFormat dt = new DecimalFormat("0.0");

    @FXML
    private Canvas canvas;

    @FXML
    private Text status;

    private int width;
    private int height;
    private int squareSize;
    private int columns = 10;
    private int rows = columns;

    private GraphicsContext board;




/*
    @FXML
    void displayPosition(MouseEvent event) {

        double x = event.getX();
        double y = event.getY();


        status.setText("X: " + dt.format(x) + "       Y:" + dt.format(y));
    }
*/

    @FXML
    void onMouseClicked(MouseEvent event) {
        Parent anchorPane = canvas.getParent();
        anchorPane.requestFocus();
        System.out.println(anchorPane.isFocused());
    }



    public GameWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setValues();
        this.engine = new Engine(board, rows, columns, squareSize);
        engine.start();


    }

    private void setValues() {
        this.board = canvas.getGraphicsContext2D();
        this.width = (int) canvas.getWidth();
        this.height = (int) canvas.getHeight();
        this.squareSize = width / columns;
    }


}
