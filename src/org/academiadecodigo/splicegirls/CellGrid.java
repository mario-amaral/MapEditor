package org.academiadecodigo.splicegirls;

public class CellGrid {

    private int cellSize;
    private int cols;
    private int rows;
    private final int CELL_PADDING = 20;

    private Cell[][] cellGrid;

    public CellGrid(int cols, int rows, int cellSize){
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        cellGrid = new Cell[cols][rows];
    }

    public void drawGrid(){

        for(int i = 0; i < cols; i++ ){

            for(int j=0; j<rows; j++){

                cellGrid[i][j] = new Cell(i, j,cellSize);

            }
        }
    }


    public void paintCell(int colIndex, int rowIndex){

       cellGrid[colIndex][rowIndex].paint();

    }


}
