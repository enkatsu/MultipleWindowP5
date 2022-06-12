package org.enkatsu.multiplewindowp5;

import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.util.function.Consumer;


public class SubWindow extends PApplet {
    static int childWindowCount = 0;
    String windowName = null;
    PApplet parent = null;
    int width = 256;
    int height = 256;
    Runnable setupFunction = () -> {
    };
    Runnable drawFunction = () -> {
    };
    MouseEventRunner mouseEventRunner;
    KeyEventRunner keyEventRunner;

    public SubWindow(PApplet parent, int width, int height, Runnable setupFunction, Runnable drawFunction, String windowName) {
        super();
        this.parent = parent;
        this.width = width;
        this.height = height;
        this.setupFunction = setupFunction;
        this.drawFunction = drawFunction;
        this.mouseEventRunner = new MouseEventRunner(this);
        this.keyEventRunner = new KeyEventRunner(this);
        this.windowName = windowName;
        PApplet.runSketch(new String[]{this.windowName}, this);
    }

    public SubWindow(PApplet parent, int width, int height, Runnable setupFunction, Runnable drawFunction) {
        this(
                parent,
                width, height,
                setupFunction, drawFunction,
                SubWindow.class.getName() + SubWindow.childWindowCount
        );
        SubWindow.childWindowCount++;
    }

    public void settings() {
        size(width, height);
    }

    public void setup() {
        this.setupFunction.run();
    }

    public void draw() {
        this.drawFunction.run();
    }

    public int getX() {
        return this.frame.getX();
    }

    public int getY() {
        return this.frame.getX();
    }

    // ********************
    // *** Mouse Events ***
    // ********************
    public void setMouseClicked(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMouseClickedFunction(function);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        this.mouseClicked();
    }

    public void setMouseDragged(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMouseDraggedFunction(function);
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        this.mouseEventRunner.mouseDragged(event);
    }

    public void setMouseEntered(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMouseEnteredFunction(function);
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        this.mouseEventRunner.mouseEntered(event);
    }

    public void setMouseExited(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMouseExitedFunction(function);
    }

    @Override
    public void mouseExited(MouseEvent event) {
        this.mouseEventRunner.mouseExited(event);
    }

    public void setMouseMoved(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMouseMovedFunction(function);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        this.mouseEventRunner.mouseMoved(event);
    }

    public void setMousePressed(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMousePressedFunction(function);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        this.mouseEventRunner.mousePressed(event);
    }

    public void setMouseReleased(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMouseReleasedFunction(function);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        this.mouseEventRunner.mouseReleased(event);
    }

    public void setMouseWheel(Consumer<MouseEvent> function) {
        this.mouseEventRunner.setMouseWheelFunction(function);
    }

    @Override
    public void mouseWheel(MouseEvent event) {
        this.mouseEventRunner.mouseWheel(event);
    }

    // ******************
    // *** Key Events ***
    // ******************
    public void setKeyPressed(Consumer<KeyEvent> function) {
        this.keyEventRunner.setKeyPressedFunction(function);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        this.keyEventRunner.keyPressed(event);
    }

    public void setKeyReleased(Consumer<KeyEvent> function) {
        this.keyEventRunner.setKeyReleasedFunction(function);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        this.keyEventRunner.keyReleased(event);
    }

    public void setKeyTyped(Consumer<KeyEvent> function) {
        this.keyEventRunner.setKeyTypedFunction(function);
    }

    @Override
    public void keyTyped(KeyEvent event) {
        this.keyEventRunner.keyTyped(event);
    }
}
