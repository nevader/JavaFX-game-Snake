package com.s24825.controller;

import com.s24825.model.Engine;
import com.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GameWindowController extends BaseController implements Initializable {

    private Engine engine;

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




    @FXML
    void displayPosition(MouseEvent event) {
        status.setText("x = " + event.getX() + "      y = " + event.getY());
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
