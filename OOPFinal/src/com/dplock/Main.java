package com.dplock;

import window.Window;
import commons.Commons;

public class Main extends Object implements Commons {

    static final String WINDOW_TITLE = "BreakoutOOP";

    public static void main(String[] args){

        Window window = new Window(
                Commons.WINDOW_WIDTH,
                Commons.WINDOW_HEIGHT,
                WINDOW_TITLE);
    }

}
