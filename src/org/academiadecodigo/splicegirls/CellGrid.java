package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.FileReader;
import java.io.IOException;

public class CellGrid implements KeyboardHandler {

    private int cellSize;
    private int cols;
    private int rows;
    private int paintCounter;

    private IO io;

    private Cell[][] cellGrid;
    private Cell[][] copyCellGrid;
    private HeadCell headCell;

    public CellGrid(int cols, int rows, int cellSize, String saveFile){
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        this.paintCounter = 0;

        io = new IO(saveFile, cols, rows);

        cellGrid = new Cell[cols][rows];
        copyCellGrid = new Cell[cols][rows];

        keyBoardInit();
    }

    public void init(){

        for(int i = 0; i < cols; i++ ){
            for(int j=0; j<rows; j++){
                cellGrid[i][j] = new Cell(i, j,cellSize);
                copyCellGrid[i][j] = new Cell(i, j,cellSize);
            }
        }
        headCell = new HeadCell(cols/2,rows/2,cellSize,cols,rows);

        drawGrid();
    }

    private void drawGrid(){

        for(int i = 0; i < cols; i++ ){
            for(int j=0; j<rows; j++){
                cellGrid[i][j].draw();
            }
        }
        headCell.draw();
    }

    private void clearGrid(){
        for(int i = 0; i < cols; i++ ){
            for(int j=0; j<rows; j++){
                cellGrid[i][j].clearCell();
            }
        }
        headCell.draw();
    }

    private void save() throws IOException {

        String[] states = new String[rows];

        for (int j=0; j<rows; j++){
            states[j] = "";
        }

        for(int i = 0; i < cols; i++){
            for (int j=0; j<rows; j++){
                states[j] += cellGrid[i][j].getState();
//                System.out.println("States for row " + j + " : "+ states[j]);
            }
        }

        try{
            io.save(states);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void load() throws IOException {
        try{

            for(int i = 0; i < cols; i++ ){
            for(int j=0; j<rows; j++){
//                String s = io.load()[j].split(" ")[i];
                System.out.println(io.load());
//                cellGrid[i][j].setState(s);
            }
        }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


//        drawGrid();
    }


    public int getCellSize() {
        return cellSize;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                cellGrid[headCell.getCol()][headCell.getRow()].paintToggle();
                cellGrid[headCell.getCol()][headCell.getRow()].draw();
                paintCounter++;
                headCell.draw();
//                System.out.println(paintCounter);

//                if(paintCounter%5 == 1){
//                    try {
//                        save();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
                break;
            case KeyboardEvent.KEY_S:
                try {
                    save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Saved.");
                break;
            case KeyboardEvent.KEY_C:
                clearGrid();
                paintCounter = 0;
                break;
            case KeyboardEvent.KEY_L:
                try {
                    load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                drawGrid();
                System.out.println("Loaded.");
                break;
        }
    }

    public void keyBoardInit() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent SpaceKeyPressed = new KeyboardEvent();
        KeyboardEvent SKeyPressed = new KeyboardEvent();
        KeyboardEvent CKeyPressed = new KeyboardEvent();
        KeyboardEvent LKeyPressed = new KeyboardEvent();

        SpaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        SKeyPressed.setKey(KeyboardEvent.KEY_S);
        CKeyPressed.setKey(KeyboardEvent.KEY_C);
        LKeyPressed.setKey(KeyboardEvent.KEY_L);

        SpaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        SKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        CKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        LKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(SpaceKeyPressed);
        keyboard.addEventListener(SKeyPressed);
        keyboard.addEventListener(CKeyPressed);
        keyboard.addEventListener(LKeyPressed);

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

}
