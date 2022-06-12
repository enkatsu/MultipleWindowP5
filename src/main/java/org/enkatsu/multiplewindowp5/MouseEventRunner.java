package org.enkatsu.multiplewindowp5;

import processing.event.MouseEvent;
import java.util.function.Consumer;

public class MouseEventRunner {
    SubWindow window;
    Consumer<MouseEvent> mousePressedFunction = event -> {
    };
    Consumer<MouseEvent> mouseReleasedFunction = event -> {
    };
    Consumer<MouseEvent> mouseWheelFunction = event -> {
    };
    Consumer<MouseEvent> mouseMovedFunction = event -> {
    };
    Consumer<MouseEvent> mouseEnteredFunction = event -> {
    };
    Consumer<MouseEvent> mouseExitedFunction = event -> {
    };
    Consumer<MouseEvent> mouseClickedFunction = event -> {
    };
    Consumer<MouseEvent> mouseDraggedFunction = event -> {
    };

    MouseEventRunner(SubWindow window) {
        this.window = window;
    }

    public void setMousePressedFunction(Consumer<MouseEvent> mousePressedFunction) {
        this.mousePressedFunction = mousePressedFunction;
    }

    public void mousePressed(MouseEvent event) {
        this.mousePressedFunction.accept(event);
    }


    public void setMouseReleasedFunction(Consumer<MouseEvent> mouseReleasedFunction) {
        this.mouseReleasedFunction = mouseReleasedFunction;
    }

    public void mouseReleased(MouseEvent event) {
        this.mouseReleasedFunction.accept(event);
    }

    public void setMouseWheelFunction(Consumer<MouseEvent> mouseWheelFunction) {
        this.mouseWheelFunction = mouseWheelFunction;
    }

    public void mouseWheel(MouseEvent event) {
        this.mouseWheelFunction.accept(event);
    }

    public void setMouseMovedFunction(Consumer<MouseEvent> mouseMovedFunction) {
        this.mouseMovedFunction = mouseMovedFunction;
    }

    public void mouseMoved(MouseEvent event) {
        this.mouseMovedFunction.accept(event);
    }

    public void setMouseEnteredFunction(Consumer<MouseEvent> mouseEnteredFunction) {
        this.mouseEnteredFunction = mouseEnteredFunction;
    }

    public void mouseEntered(MouseEvent event) {
        this.mouseEnteredFunction.accept(event);
    }

    public void setMouseExitedFunction(Consumer<MouseEvent> mouseExitedFunction) {
        this.mouseExitedFunction = mouseExitedFunction;
    }

    public void mouseExited(MouseEvent event) {
        this.mouseExitedFunction.accept(event);
    }

    public void setMouseClickedFunction(Consumer<MouseEvent> mouseClickedFunction) {
        this.mouseClickedFunction = mouseClickedFunction;
    }

    public void mouseClicked(MouseEvent event) {
        this.mouseClickedFunction.accept(event);
    }

    public void setMouseDraggedFunction(Consumer<MouseEvent> mouseDraggedFunction) {
        this.mouseDraggedFunction = mouseDraggedFunction;
    }

    public void mouseDragged(MouseEvent event) {
        this.mouseDraggedFunction.accept(event);
    }
}
