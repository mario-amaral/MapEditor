package org.academiadecodigo.splicegirls;

public class Main {

    public static final int COLS= 70;
    public static final int ROWS = 40;
    public static final int CELL_SIZE = 20;

    public static void main(String[] args) {

        CellGrid cellGrid = new CellGrid(COLS, ROWS, CELL_SIZE);

        cellGrid.drawGrid();
        cellGrid.paintCell(20,30);
        cellGrid.paintCell(23, 32);


    }
}
