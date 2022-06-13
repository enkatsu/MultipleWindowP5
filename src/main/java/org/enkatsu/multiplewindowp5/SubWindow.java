package org.enkatsu.multiplewindowp5;

import processing.awt.PSurfaceAWT;
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
    MouseEventRunner mouseEventRunner;
    KeyEventRunner keyEventRunner;
    Consumer<SubWindow> setupConsumer = self -> {};
    Consumer<SubWindow> drawConsumer = self -> {};

    public SubWindow(PApplet parent, int width, int height) {
        super();
        this.parent = parent;
        this.width = width;
        this.height = height;
        this.mouseEventRunner = new MouseEventRunner(this);
        this.keyEventRunner = new KeyEventRunner(this);
        SubWindow.childWindowCount++;
        this.windowName = SubWindow.class.getName() + SubWindow.childWindowCount;
    }

    public void settings() {
        size(width, height);
    }

    public void setup(Consumer<SubWindow> setupConsumer) {
        this.setupConsumer = setupConsumer;
        PApplet.runSketch(new String[]{this.windowName}, this);
    }

    @Override
    public void setup() {
        setupConsumer.accept(this);
    }

    public void draw(Consumer<SubWindow> drawConsumer) {
         this.drawConsumer = drawConsumer;
    }

    @Override
    public void draw() {
        this.drawConsumer.accept(this);
    }

    public int getX() {
        PSurfaceAWT.SmoothCanvas frame = (PSurfaceAWT.SmoothCanvas) this.surface.getNative();
        return frame.getFrame().getX();
    }

    public int getY() {
        PSurfaceAWT.SmoothCanvas frame = (PSurfaceAWT.SmoothCanvas) this.surface.getNative();
        return frame.getFrame().getY();
    }

    public void setLocation(int x, int y) {
        this.surface.setLocation(x, y);
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
