package de.fema.movie;

import de.fema.movie.domain.Movie;
import de.fema.movie.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MovieDatabaseApplication implements CommandLineRunner {

    @Autowired
    MovieRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MovieDatabaseApplication.class, args);

        //ApplicationContext ctx = SpringApplication.run(MovieDatabaseApplication.class, args);

    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of customers
        repository.save(new Movie("Terminator", LocalDate.of(1981, Month.MARCH,23),"Arnis first Terminator", 8.9));
        repository.save(new Movie("Total Recall", LocalDate.of(1991, Month.AUGUST,18),"Arnis on Mars", 9.1));


        // fetch all customers
        System.out.println("Movies found with findAll():");
        System.out.println("-------------------------------");
        for (Movie movie : repository.findAll()) {
            System.out.println(movie);
        }
        System.out.println();

        // fetch an individual customer by ID
        Movie movie = repository.findOne(1L);
        System.out.println("Movie found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(movie);
        System.out.println();

        // fetch customers by last name
        System.out.println("Movie found with findByName('Terminator'):");
        System.out.println("--------------------------------------------");
        for (Movie mv : repository.findByName("Terminator")) {
            System.out.println(mv.toString());
        }
    }
}
