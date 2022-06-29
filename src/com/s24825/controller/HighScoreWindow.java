package com.s24825.controller;

import com.s24825.Settings;
import com.s24825.view.ViewFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HighScoreWindow extends BaseController{
    public HighScoreWindow(ViewFactory viewFactory, String fxmlName, Settings settings) {
        super(viewFactory, fxmlName, settings);
    }


}
