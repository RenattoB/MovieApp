package com.sistema.Controller;

import com.sistema.Entities.Category;
import com.sistema.Entities.Client;
import com.sistema.Entities.Movie;
import com.sistema.Entities.Rent;
import com.sistema.Repository.ClientRepository;
import com.sistema.Repository.MovieRepository;
import com.sistema.Repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RentController {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/rents")
    public String showRents(Model model){
        List<Rent> listRents = rentRepository.findAll();
        model.addAttribute("listRents", listRents);
        return "rents";
    }

    @GetMapping("/rents/add")
    public String addRent(Model model){
        List<Movie> listMovies = movieRepository.findAll();
        List<Client> listClients= clientRepository.findAll();
        model.addAttribute("rent", Rent.builder().build());
        model.addAttribute("listClients", listClients);
        model.addAttribute("listMovies", listMovies);
        return "addRent";
    }

    @PostMapping("/rents/save")
    public String saveRent(Rent rent){
        try {
            rentRepository.save(rent);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/rents";
    }

    @GetMapping("/rents/edit/{id_rent}")
    public String editMovie(@PathVariable("id_rent") Integer id_rent, Model model){
        Rent rent = rentRepository.findById(id_rent).isPresent()? rentRepository.findById(id_rent).get():null;
        List<Movie> listMovies = movieRepository.findAll();
        List<Client> listClients= clientRepository.findAll();
        if(rent == null) return "movies";
        model.addAttribute("rent", rent);
        model.addAttribute("listClients", listClients);
        model.addAttribute("listMovies", listMovies);
        return "addRent";
    }

    @GetMapping("/rents/delete/{id_rent}")
    public String deleteMovie(@PathVariable("id_rent") Integer id_rent){
        movieRepository.deleteById(id_rent);
        return "redirect:/movies";
    }
}
