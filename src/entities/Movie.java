package entities;

import constants.MovieGenre;

import java.util.Arrays;

public class Movie extends Bookmark {
    private int yearRealise;
    private String[] cats;
    private String[] directors;
    private String genre;
    private double imbRaring;

    public int getYearRealise() {
        return yearRealise;
    }

    public void setYearRealise(int yearRealise) {
        this.yearRealise = yearRealise;
    }

    public String[] getCats() {
        return cats;
    }

    public void setCats(String[] cats) {
        this.cats = cats;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getImbRaring() {
        return imbRaring;
    }

    public void setImbRaring(double imbRaring) {
        this.imbRaring = imbRaring;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "yearRealise=" + yearRealise +
                ", cats=" + Arrays.toString(cats) +
                ", directors=" + Arrays.toString(directors) +
                ", genre='" + genre + '\'' +
                ", imbRaring=" + imbRaring +
                '}';
    }

    @Override
    public boolean isKidFriendly() {
        if (genre.equals(MovieGenre.HORROR) || genre.equals((MovieGenre.THRILLERS))) {
            return false;
        }
        return true;
    }
}
