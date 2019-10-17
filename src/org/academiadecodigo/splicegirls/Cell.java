package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private boolean paintToggle;
    private String state;
    private Rectangle cellShape;
    private final int CELL_PADDING = 10;
    private Color PAINTED_COLOR = Color.BLACK;
    private Color DEFAULT_COLOR = Color.LIGHT_GRAY;

    private int col;
    private int row;

    public Cell(int col, int row, int cellSize) {
        paintToggle = false;
        state = "c ";
        cellShape = new Rectangle(CELL_PADDING + col*cellSize, CELL_PADDING + row*cellSize, cellSize, cellSize);
//        cellShape.setColor(DEFAULT_COLOR);
//        cellShape.draw();
    }

    public void draw(){
        if(paintToggle){
            cellShape.setColor(PAINTED_COLOR);
            cellShape.fill();
        } else {
            cellShape.setColor(DEFAULT_COLOR);
            cellShape.draw();
        }
    }

    public void paintToggle(){
        paintToggle = !paintToggle;
        state = paintToggle ? "p ": "c ";
    }

    public void clearCell(){
        paintToggle = false;
//        cellShape.delete();
        cellShape.setColor(DEFAULT_COLOR);
        cellShape.draw();
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getState() {
        return state;
    }

    public void setState(String state){
        this.state = state;
    }
}
