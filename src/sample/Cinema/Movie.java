package sample.Cinema;

import java.io.Serializable;

public class Movie implements Serializable {
    private Integer id;
    private String name;
    private String ganer;
    private String YearOFIssue;
    private String age;
    private String director;
    private String actors;
    private String recall;


    public Movie() {
    }

    public Movie(Integer id, String name, String ganer, String yearOFIssue, String age, String director, String actors, String recall) {
        this.id = id;
        this.name = name;
        this.ganer = ganer;
        this.YearOFIssue = yearOFIssue;
        this.age = age;
        this.director = director;
        this.actors = actors;
        this.recall = recall;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGaner() {
        return ganer;
    }

    public void setGaner(String ganer) {
        this.ganer = ganer;
    }

    public String getYearOFIssue() {
        return YearOFIssue;
    }

    public void setYearOFIssue(String yearOFIssue) {
        YearOFIssue = yearOFIssue;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRecall() {
        return recall;
    }

    public void setRecall(String recall) {
        this.recall = recall;
    }

    @Override
    public String toString() {
        return id+ " " + name+ " " +ganer+ " " +YearOFIssue+ " " +age+ " " +director+ " " +actors+ " " +recall;
    }
}

