package org.enkatsu.multiplewindowp5;

import processing.event.KeyEvent;
import java.util.function.Consumer;

public class KeyEventRunner {
    SubWindow window;
    Consumer<KeyEvent> keyPressedFunction = event -> {
    };
    Consumer<KeyEvent> keyReleasedFunction = event -> {
    };
    Consumer<KeyEvent> keyTypedFunction = event -> {
    };

    KeyEventRunner(SubWindow window) {
        this.window = window;
    }

    public void setKeyPressedFunction(Consumer<KeyEvent> keyPressedFunction) {
        this.keyPressedFunction = keyPressedFunction;
    }

    public void keyPressed(KeyEvent event) {
        this.keyPressedFunction.accept(event);
    }

    public void setKeyReleasedFunction(Consumer<KeyEvent> keyReleasedFunction) {
        this.keyReleasedFunction = keyReleasedFunction;
    }

    public void keyReleased(KeyEvent event) {
        this.keyReleasedFunction.accept(event);
    }

    public void setKeyTypedFunction(Consumer<KeyEvent> keyTypedFunction) {
        this.keyTypedFunction = keyTypedFunction;
    }

    public void keyTyped(KeyEvent event) {
        this.keyTypedFunction.accept(event);
    }
}
