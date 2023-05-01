package EE4216Lab3.springboot.entity;

import javax.persistence.*;

@Entity
@Table
public class Movie {
    @Id
    Integer id;

    @Column
    String name;

    @Column
    Integer year;

    @Column
    Float rank;

    public Movie() {
    }

    public Movie(Integer id, String name, Integer year, Float rank) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public Float getRank() {
        return rank;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setRank(Float rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("Movie [id=%s, name=%s, year=%s, rank=%s]", id, name, year, rank);
    }
}
