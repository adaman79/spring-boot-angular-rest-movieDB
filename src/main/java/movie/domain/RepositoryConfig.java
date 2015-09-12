package movie.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by fema on 12.09.15.
 */
@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Movie.class);
    }

}
