/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee4216.test2.movie;

import java.util.List;

/**
 * Entity 
 * 
 * @author vanting
 */
public class Movie {
    
    private int id;
    private String name;
    private int year;
    private double rank;
    private List<String> genres;

    public Movie(int id, String name, int year, double rank, List<String> genres) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rank = rank;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    
}
