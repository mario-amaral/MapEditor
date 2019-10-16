package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class HeadCell implements KeyboardHandler {

    private Color CONTOUR_COLOR = Color.BLUE;
    private Rectangle headCell;
    private final int CELL_PADDING = 10;

    private int col;
    private int row;

    public HeadCell(int col, int row, int cellSize) {
        this.col = col;
        this.row = row;

        headCell = new Rectangle(CELL_PADDING + col*cellSize, CELL_PADDING + row*cellSize, cellSize, cellSize );
        headCell.setColor(CONTOUR_COLOR);
        headCell.draw();
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
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                moveUp = true;
                moveDown = false;
//                yf = super.getY();
//                super.getPaddle().translate(0,yf-yi);
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown = true;
                moveUp = false;
//                yf = super.getY();
//                super.getPaddle().translate(0,yf-yi);
                break;
            case KeyboardEvent.KEY_LEFT:
                moveUp = true;
                moveDown = false;
//                yf = super.getY();
//                super.getPaddle().translate(0,yf-yi);
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveUp = true;
                moveDown = false;
//                yf = super.getY();
//                super.getPaddle().translate(0,yf-yi);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void move(){

        switch ()

    }
}
