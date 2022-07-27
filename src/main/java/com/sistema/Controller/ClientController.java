package com.sistema.Controller;

import com.sistema.Entities.Category;
import com.sistema.Entities.Client;
import com.sistema.Entities.Movie;
import com.sistema.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public String showClients(Model model){
        List<Client> listClients = clientRepository.findAll();
        model.addAttribute("listClients", listClients);
        return "clients";
    }

    /*@GetMapping("/clients/add")
    public String addClient(Model model){
        model.addAttribute("client", Client.builder().build());
        return "addClient";
    }*/

    @PostMapping("/clients/save")
    public String saveClient(@RequestBody Client client){
        try {
            clientRepository.save(client);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "redirect:/clients";
    }

    @GetMapping("/clients/edit/{id_client}")
    public String editMovie(@PathVariable("id_client") Integer id_client, Model model){
        Client client = clientRepository.findById(id_client).isPresent()? clientRepository.findById(id_client).get():null;
        if(client == null) return "clients";
        model.addAttribute("client", client);
        return "addClient";
    }

    @GetMapping("/clients/delete/{id_client}")
    public String deleteMovie(@PathVariable("id_client") Integer id_client){
        clientRepository.deleteById(id_client);
        return "redirect:/clients";
    }

}
