package com.s24825.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Engine {

    private boolean isGameOver;
    private int currentDirection;

    private final GraphicsContext board;

    private final int rows;
    private final int columns;
    private final int squareSize;

    private final Snake snake = new Snake();
    private final Food food;

    private Image back1;
    private Image back2;

    public Engine(GraphicsContext board, int rows, int columns, int squareSize) {
        this.board = board;
        this.rows = rows;
        this.columns = columns;
        this.squareSize = squareSize;
        this.food = new Food(board);
    }

    public void start() {
        drawBackGround2();
        food.drawFood(rows, columns, squareSize);

    }

    public void drawBackGround() {

        Color color2 = Color.rgb(192, 242, 40, 0.8);
        Color color1 = Color.rgb(92, 207, 47, 0.8);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i + j) % 2 == 0) {
                    board.setFill(color2);
                } else {
                    board.setFill(color1);
                }
                board.fillRect(i * squareSize, j * squareSize, squareSize, squareSize);
            }

        }
    }
    public void drawBackGround2() {

        back1 = new Image(getClass().getResourceAsStream("/com/s24825/view/assets/background1.png"));
        back2 = new Image(getClass().getResourceAsStream("/com/s24825/view/assets/background2.png"));

        Image image;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i + j) % 2 == 0) {
                    image = back1;
                } else {
                    image = back2;
                }
                board.drawImage(image, i * squareSize, j * squareSize, squareSize, squareSize);
            }

        }
    }





}
