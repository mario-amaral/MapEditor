package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class HeadCell implements KeyboardHandler {

    private Color CONTOUR_COLOR = Color.BLUE;
    private Rectangle headCellShape;
    private final int CELL_PADDING = 10;

    private int col;
    private int row;
    private int cellSize;
    private int cols;
    private int rows;

    public HeadCell(int col, int row, int cellSize, int cols, int rows) {
        this.col = col;
        this.row = row;
        this.cellSize = cellSize;
        this.cols = cols;
        this.rows = rows;

        headCellShape = new Rectangle(CELL_PADDING + col*cellSize, CELL_PADDING + row*cellSize, cellSize, cellSize );
//        headCellShape.setColor(CONTOUR_COLOR);
//        headCellShape.draw();
        keyBoardInit();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void draw(){
        headCellShape.setColor(CONTOUR_COLOR);
        headCellShape.draw();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                if((row)*cellSize < CELL_PADDING){
                    break;
                }
                row--;
                headCellShape.translate(0, -cellSize);
                System.out.println("Head cell » " + col + ", " + row + "." );
                break;
            case KeyboardEvent.KEY_DOWN:
                if((row)*cellSize > (rows-1)*cellSize-CELL_PADDING ){
                    break;
                }
                row++;
                headCellShape.translate(0, cellSize);
                System.out.println("Head cell » " + col + ", " + row + "." );
                break;
            case KeyboardEvent.KEY_LEFT:
                if((col)*cellSize < CELL_PADDING){
                    break;
                }
                col--;
                headCellShape.translate(-cellSize,0);
                System.out.println("Head cell » " + col + ", " + row + "." );
                break;
            case KeyboardEvent.KEY_RIGHT:
                if((col)*cellSize > (cols-1)*cellSize - CELL_PADDING){
                    break;
                }
                col++;
                headCellShape.translate(cellSize,0);
                System.out.println("Head cell » " + col + ", " + row + "." );
                break;
        }
    }

    public void keyBoardInit() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent UpKeyPressed = new KeyboardEvent();
        KeyboardEvent DownKeyPressed = new KeyboardEvent();
        KeyboardEvent LeftKeyPressed = new KeyboardEvent();
        KeyboardEvent RightKeyPressed = new KeyboardEvent();
        KeyboardEvent SpaceKeyPressed = new KeyboardEvent();
        KeyboardEvent SKeyPressed = new KeyboardEvent();

        UpKeyPressed.setKey(KeyboardEvent.KEY_UP);
        DownKeyPressed.setKey(KeyboardEvent.KEY_DOWN);
        LeftKeyPressed.setKey(KeyboardEvent.KEY_LEFT);
        RightKeyPressed.setKey(KeyboardEvent.KEY_RIGHT);
        SpaceKeyPressed.setKey(KeyboardEvent.KEY_SPACE);
        SKeyPressed.setKey(KeyboardEvent.KEY_S);

        UpKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        DownKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        LeftKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        RightKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        SpaceKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        SKeyPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(UpKeyPressed);
        keyboard.addEventListener(DownKeyPressed);
        keyboard.addEventListener(LeftKeyPressed);
        keyboard.addEventListener(RightKeyPressed);
        keyboard.addEventListener(SpaceKeyPressed);
        keyboard.addEventListener(SKeyPressed);

    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
