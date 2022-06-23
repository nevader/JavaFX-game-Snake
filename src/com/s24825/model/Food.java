package com.s24825.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;

public class Food extends GameManager {

    private Image foodImage;
    private int foodX;
    private int foodY;
    private final GraphicsContext board;

    public Food(GraphicsContext board) {
        this.board = board;
    }

    public int generateFoodX(int rows) {
            return (int) (Math.random() * rows);
    }
    public int generateFoodY(int columns) {
        return (int) (Math.random() * columns);
    }

    public void drawFood(int rows, int columns, int squareSize) {

        foodX = generateFoodX(rows);
        foodY = generateFoodY(columns);

        foodImage = new Image(getClass().getResourceAsStream("/com/s24825/view/assets/fruitSize.png"));

        board.drawImage(foodImage, foodX * squareSize, foodY * squareSize, squareSize, squareSize);

    }


}
