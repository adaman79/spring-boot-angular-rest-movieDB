package movie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by fema on 12.09.15.
 */
@Entity
public class Movie {
    public Movie() {
    }

    public Movie(String name, LocalDate year, String description, double imdb) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.imdb = imdb;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate year;

    private String description;

    private double imdb;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", imdb=" + imdb +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (Double.compare(movie.imdb, imdb) != 0) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (year != null ? !year.equals(movie.year) : movie.year != null) return false;
        return !(description != null ? !description.equals(movie.description) : movie.description != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(imdb);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    public Long getId() {
        return id;
    }
}
