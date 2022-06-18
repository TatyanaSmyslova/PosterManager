package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.movie.Movie;

@Data

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int defaultMovieLength = 10;

    MovieManager() {
    }

    public MovieManager(int customMovieLength) {
        if (customMovieLength > 0) {
            defaultMovieLength = customMovieLength;
        }
    }

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastMovie = tmp.length - 1;
        tmp[lastMovie] = movie;
        movies = tmp;
    }

    //изменила метод вывода последних 10 фильмов
    public Movie[] getLastAdd() {
        int feed = this.defaultMovieLength;
        if (feed > movies.length)
            feed = movies.length;
        Movie[] result = new Movie[feed]; //
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}