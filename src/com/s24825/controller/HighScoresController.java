package com.s24825.controller;

import com.s24825.Settings;
import com.s24825.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class HighScoresController extends BaseController implements Initializable {
    public HighScoresController(ViewFactory viewFactory, String fxmlName, Settings settings) {
        super(viewFactory, fxmlName, settings);
    }

    @FXML
    private ImageView backBtn;

    @FXML
    private TextArea highscoreTable;

    @FXML
    void backClicked(MouseEvent event) {
        Stage stage = (Stage) highscoreTable.getScene().getWindow();

        viewFactory.showMainMenu();
        viewFactory.closeStage(stage);
    }

    @FXML
    void backNotHover(MouseEvent event) {
        viewFactory.dropShadowOff(event);

    }

    @FXML
    void backOnHover(MouseEvent event) {
        viewFactory.dropShadowOn(event);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pupulateHighScore();
    }

    private void pupulateHighScore() {

        ArrayList<String> high = new ArrayList<>();

        FileReader fileReader;
        BufferedReader bufferedReader = null;

        try {

            fileReader = new FileReader("highscore.txt");
            bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null) {
                high.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        for (int i = high.size(); i >= 1; i--) {
            highscoreTable.appendText(high.get(i-1) + "\n");
        }

    }

    public ArrayList<String> sorting(ArrayList<String> arrayList) {

        int n = arrayList.size();
        String temp = "";


        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){

                long jot1 = stringtoint(arrayList.get(j-1));
                long jot = stringtoint(arrayList.get(j));

                if(jot1 > jot){
                    temp = arrayList.get(j);
                    arrayList.set(j-1, arrayList.get(j));
                    arrayList.set(j, temp);
                }

            }
        }
        return arrayList;
    }


    public long stringtoint(String st) {
        String DIGIT_AND_DECIMAL_REGEX = "[^\\d.]";
        String digits = st.replaceAll(DIGIT_AND_DECIMAL_REGEX, "");
        return Long.parseLong(digits);
    }
}
