package com.example.moviesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTV, overviewTV, budgetTV, releaseDateTV, revenueTV, runtimeTV;

    public static final String EXTRA_MOVIE = "EXTRA_MOVIE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        findViews();

        if (getIntent().hasExtra(EXTRA_MOVIE)) {
            Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
            titleTV.setText(movie.getTitle());
            overviewTV.setText(movie.getOverview());
            if (movie.getBudget() == 0){
                budgetTV.setText("Unknown");
            }else{
                budgetTV.setText(movie.getBudget()+"");
            }

           /* String genres = "";
            for ()
            genuriTV.setText(movie.getGenres().toString());*/
            releaseDateTV.setText(movie.getReleaseDate());
            if (movie.getRevenue() == 0){
                revenueTV.setText("Unknown");
            }else{
                revenueTV.setText(movie.getRevenue()+"");
            }

            if (movie.getRuntime() == 0){
                runtimeTV.setText("Unknown");
            }else {
                runtimeTV.setText(String.valueOf(movie.getRuntime()));
            }


        }
    }

    private void findViews(){
        titleTV = findViewById(R.id.text_title);
        overviewTV = findViewById(R.id.text_overview);
        budgetTV = findViewById(R.id.text_budget);
        //genuriTV = findViewById(R.id.text_genres);
        releaseDateTV = findViewById(R.id.text_release_date);
        revenueTV = findViewById(R.id.text_revenue);
        runtimeTV = findViewById(R.id.text_runtime);

    }
}
