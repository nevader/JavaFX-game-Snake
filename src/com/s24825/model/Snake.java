package com.s24825.model;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Snake extends GameManager {

    private int length;
    private ArrayList<Point2D> snakeBody;
    private Point2D snakeHead;
    private int currentDirection;
    private final GraphicsContext board;

    public Snake(GraphicsContext board) {
        this.board = board;
        this.snakeBody = new ArrayList<>();
    }

    public void generateStartingSnake(int startingX, int startingY, int snakeLength) {
        for (int i = 0; i < snakeLength; i++) {
            snakeBody.add(new Point2D(startingX, startingY));
        }
        snakeHead = snakeBody.get(0);
    }

    public void drawSnake(int squareSize) {

        board.setFill(Color.LIGHTBLUE);

        board.fillRoundRect(snakeHead.getX() * squareSize, snakeHead.getY() * squareSize,
                squareSize - 1, squareSize - 1, 35, 35);

        for (int i = 1; i < snakeBody.size(); i++) {
            board.fillRoundRect(snakeHead.getX() * squareSize, snakeHead.getY() * squareSize,
                    squareSize - 1, squareSize - 1, 20, 20);
        }
    }

}
