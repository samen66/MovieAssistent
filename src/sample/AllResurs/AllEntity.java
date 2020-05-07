package sample.AllResurs;

import sample.Cinema.Cinema;
import sample.Cinema.Movie;
import sample.LOGIN.Admin;
import sample.LOGIN.User;

import java.io.Serializable;
import java.util.ArrayList;

public class AllEntity implements Serializable {
    String operationType;
    ArrayList<Movie> movies;
    ArrayList<Cinema> cinemas;
    User user;
    Movie movie;
    Cinema cinema;
    Admin admin;

    public AllEntity() {
    }

    public AllEntity(String operationType, ArrayList<Movie> movies, ArrayList<Cinema> cinemas, User user, Movie movie, Cinema cinema, Admin admin) {
        this.operationType = operationType;
        this.movies = movies;
        this.cinemas = cinemas;
        this.user = user;
        this.movie = movie;
        this.cinema = cinema;
        this.admin = admin;
    }

    public AllEntity(String operationType, ArrayList<Movie> movies, ArrayList<Cinema> cinemas) {
        this.operationType = operationType;
        this.movies = movies;
        this.cinemas = cinemas;
    }

    public String getOperationType() {
        return operationType;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    @Override
    public String toString() {
        return "AllEntity{" +
                "operationType='" + operationType + '\'' +
                ", movies=" + movies +
                ", cinemas=" + cinemas +
                '}';
    }
}
