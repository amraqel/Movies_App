package com.assignments.movies_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.assignments.movies_app.Model.IMovieDa;
import com.assignments.movies_app.Model.Movie;
import com.assignments.movies_app.Model.MovieFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    MovieFactory factory = new MovieFactory();
    IMovieDa objMovie = factory.getModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.genreField);
        populateSpinner();

    }

    private void populateSpinner() {


        ArrayList<String> genres = objMovie.getGenres();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, genres);

        spinner.setAdapter(adapter);

    }


    public void search(View view) {
        String title;
        int year;
        String genre;

        TextView textField = findViewById(R.id.titleField);
        TextView yearField = findViewById(R.id.yearField);

        //get Data from fields.
        title = textField.getText().toString();

        if(!yearField.getText().toString().equals(""))
            year = Integer.parseInt(yearField.getText().toString());
        else
            year = -1;

        genre = spinner.getSelectedItem().toString();

        //search for the movies in the data set
        List<Movie> data =objMovie.searchForMovie(title,year,genre);

        //add the results to an EditText in the UI
        addResultsToView(data);
        EditText results = this.findViewById(R.id.results);

        String result="";
        //Loop over the results to add them to the EditText
        //cnt is a counter
        int cnt = 1;
        for(Movie movie : data)
            result+= (cnt++)+"- "+movie.getTitle()+" "+movie.getYear()+ " "+ movie.getGenre()+"\n";

        //replace the text with the new one
        if(data.size() != 0){
            results.setText("");
            results.setText(result);
        }
        else{
            results.setText("There is no results.");
        }

        //import image for the first result for the result.
        ImageView img = findViewById(R.id.imageView);
        img.getLayoutParams().height = 200;
        img.getLayoutParams().width = 200;
        int drawableId = this.getResources().getIdentifier(data.get(0).getImg(),"drawable",getPackageName());
        System.out.println(drawableId);
        img.setImageResource(drawableId);

    }

    private void addResultsToView(List<Movie> data) {




    }
}