package com.sistema;

import com.sistema.Entities.Category;
import com.sistema.Entities.Movie;
import com.sistema.Repository.CategoryRepository;
import com.sistema.Repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class MoviesRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testAddMovie(){
        Movie movie = Movie.builder().name("Tets Movie 2").category(categoryRepository.findById(1).get()).director("Test Director").year("1997").build();
        movieRepository.save(movie);
    }

}
