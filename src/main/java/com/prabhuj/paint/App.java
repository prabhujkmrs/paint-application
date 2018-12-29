package com.prabhuj.paint;

import com.prabhuj.paint.service.Draw;
import com.prabhuj.paint.service.DrawImpl;

public class App {

    public static void main(String args[]) {
        Draw draw = new DrawImpl();
        while (true) {
            draw.getUserInput();
            draw.processInput();
        }
    }

}
