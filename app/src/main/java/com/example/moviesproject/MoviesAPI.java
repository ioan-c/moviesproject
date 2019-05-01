package com.example.moviesproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {
    @GET("3/genre/movie/list")
    Call<GenresResult> getGenres(@Query("api_key")String apiKey);

    @GET("/3/movie/popular")
    Call<MoviesResult> getPopularMovies(@Query("api_key")String apiKey);

    @GET("/3/discover/movie")
    Call<MoviesResult> getMoviesByGenre(@Query("api_key")String apiKey, @Query("with_genres")int genreId);
}
