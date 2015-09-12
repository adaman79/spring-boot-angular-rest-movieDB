package movie.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fema on 12.09.15.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
public interface MovieRepository extends CrudRepository<Movie, Long>,PagingAndSortingRepository<Movie, Long> {

    //List<Movie> findByName(String name);
    List<Movie> findByName(@Param("name") String name);
}
