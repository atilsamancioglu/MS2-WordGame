package com.atilsamancioglu.wordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.atilsamancioglu.wordgame.ModelPopulator.bandCategoryName;
import static com.atilsamancioglu.wordgame.ModelPopulator.bandList;
import static com.atilsamancioglu.wordgame.ModelPopulator.dogCategoryName;
import static com.atilsamancioglu.wordgame.ModelPopulator.dogList;
import static com.atilsamancioglu.wordgame.ModelPopulator.fruitCategoryName;
import static com.atilsamancioglu.wordgame.ModelPopulator.fruitList;

public class GameActivity extends AppCompatActivity {

    EditText inputText;
    TextView scoreText;
    TextView categoryText;
    int score;
    ArrayList<WordModel> categories;
    int categoryCounter;
    WordModel currentCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        scoreText = findViewById(R.id.scoreText);
        categoryText = findViewById(R.id.categoryText);

        score = 0;
        categoryCounter = 0;

        WordModel fruitModel = new WordModel(fruitCategoryName,fruitList);
        WordModel bandModel = new WordModel(bandCategoryName,bandList);
        WordModel dogModel = new WordModel(dogCategoryName,dogList);

        categories = new ArrayList<>();
        categories.add(fruitModel);
        categories.add(bandModel);
        categories.add(dogModel);

        categoryRefresher();

    }

    public void sendButtonClicked(View view) {
        int scoreFromInput = checkWord();
        score += scoreFromInput;
        scoreText.setText("Score: " + score);
    }

    private int checkWord() {
        String userInput = inputText.getText().toString();
        if (currentCategory.gameWords.contains(userInput)) {
            return 1;
        } else {
            return 0;
        }
    }

    private void categoryRefresher() {
        currentCategory = categories.get(categoryCounter);
        categoryText.setText("Category: " + currentCategory.categoryName);
    }

    public void changeCategoryClicked(View view) {
        if (categoryCounter + 1 < categories.size()) {
            categoryCounter += 1;
            categoryRefresher();
        } else {
            categoryCounter = 0;
            categoryRefresher();
        }
    }
}
