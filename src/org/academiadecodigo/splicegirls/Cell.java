package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private boolean painted;
    private Rectangle cell;
    private final int CELL_PADDING = 10;
    private Color PAINTED_COLOR = Color.BLACK;
    private Color DEFAULT_COLOR = Color.LIGHT_GRAY;

    private int col;
    private int row;

    public Cell(int col, int row, int cellSize) {
        painted = false;
        cell = new Rectangle(CELL_PADDING + col*cellSize, CELL_PADDING + row*cellSize, cellSize, cellSize);
        cell.setColor(DEFAULT_COLOR);
        cell.draw();
    }

    public void paint(){
        painted = true;
        cell.setColor(PAINTED_COLOR);
        cell.fill();
    }

    public void clearCell(){
        painted = false;
        cell.setColor(DEFAULT_COLOR);
        cell.fill();
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
