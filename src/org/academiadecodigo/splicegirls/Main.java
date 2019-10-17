package org.academiadecodigo.splicegirls;

public class Main {

    public static final int COLS= 20;
    public static final int ROWS = 30;
    public static final int CELL_SIZE = 10;

    public static final String SAVE_FILE = "resources/save.txt";

    public static void main(String[] args) {

        CellGrid cellGrid = new CellGrid(COLS, ROWS, CELL_SIZE, SAVE_FILE);

        cellGrid.init();

    }
}
