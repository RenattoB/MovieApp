package com.sistema.Controller;

import com.sistema.Entities.Category;
import com.sistema.Entities.Movie;
import com.sistema.Repository.CategoryRepository;
import com.sistema.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/movies")
    public String showMovies(Model model){
        List<Movie> listMovies = movieRepository.findAll();
        model.addAttribute("listMovies", listMovies);
        return "movies";
    }

    @GetMapping("/movies/add")
    public String addMovie(Model model){
        List<Category> listCategory = categoryRepository.findAll();
        model.addAttribute("movie", Movie.builder().build());
        model.addAttribute("listCategory", listCategory);
        return "addMovie";
    }

    @PostMapping("/movies/save")
    public String saveMovie(Movie movie){
        try {
            movieRepository.save(movie);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/movies";
    }

    @GetMapping("/movies/edit/{id_movie}")
    public String editMovie(@PathVariable("id_movie") Integer idMovie, Model model){
        Movie movie = movieRepository.findById(idMovie).isPresent()? movieRepository.findById(idMovie).get():null;
        List<Category> listCategory = categoryRepository.findAll();
        if(movie == null) return "movies";
        model.addAttribute("movie", movie);
        model.addAttribute("listCategory", listCategory);
        return "addMovie";
    }

    @GetMapping("/movies/delete/{id_movie}")
    public String deleteMovie(@PathVariable("id_movie") Integer idMovie){
        movieRepository.deleteById(idMovie);
        return "redirect:/movies";
    }
}
