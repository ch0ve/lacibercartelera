package com.cinema.Cinema.controllers;

import com.cinema.Cinema.entities.User;
import com.cinema.Cinema.repositories.UserRepository;
import com.cinema.Cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/showUsers")
    public String showUser(Model model){
        model.addAttribute("users",userService.getUsers());
        return "usersTable";
    }

    @GetMapping("/user/{id}")
    public String user(Model model, @PathVariable Long id){
        model.addAttribute("name",userService.getUser(id).get().getName());
        return "userIndex";
    }

    @GetMapping("/deleteUsers")
    public String deleteUsers(Model model){
        model.addAttribute("users",userService.getUsers());
        return "deleteUsers";
    }

    @GetMapping("/deleteUsers/{id}")
    public String deleteUser(Model model, @PathVariable Long id){
        model.addAttribute("user",userService.getUser(id).get().getName());
        userService.deleteUser(id);
        return "userDeleted";
    }
    @GetMapping("/addUsers")
    public String addUser(Model model){
        model.addAttribute("users",userService.getUsers());
        return "addUsers";
    }

    @GetMapping("/userAdded")
    public String formUser(Model model,  @RequestParam String pass, @RequestParam String name, @RequestParam String surname,@RequestParam String email){
        userService.addUser(new User(name,surname,pass,email));
        model.addAttribute("user",name);
        return "userAdded";
    }

    @GetMapping("/user/{id}/modifyUser")
    public String modifyUser(Model model, @PathVariable Long id){
        model.addAttribute("name",userService.getUser(id).get().getName());
        model.addAttribute("surname",userService.getUser(id).get().getSurname());
        model.addAttribute("pass",userService.getUser(id).get().getPass());
        model.addAttribute("email",userService.getUser(id).get().getEmail());
        return "modifyUser";
    }

    @GetMapping("/user/{id}/userModified")
    public String userModified(Model model,  @RequestParam String pass, @RequestParam String name, @RequestParam String surname,@PathVariable Long id){
        userService.getUser(id).get().setName(name);
        userService.getUser(id).get().setSurname(surname);
        userService.getUser(id).get().setPass(pass);
        model.addAttribute("name",userService.getUser(id).get().getName());
        return "userModified";
    }
}





/*

--------------------------------------------









@GetMapping("/showUsers")
public String showUser(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "usersTable";
        }

@GetMapping("/user/{id}")
public String user(Model model, @PathVariable Long id){
        model.addAttribute("name", userRepository.findById(id).get().getName());
        return "userIndex";
        }

@GetMapping("/deleteUsers")
public String deleteUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "deleteUsers";
        }

@GetMapping("/deleteUsers/{id}")
public String deleteUser(Model model, @PathVariable Long id){
        model.addAttribute("user", userRepository.findById(id).get().getName());
        userRepository.deleteById(id);
        return "userDeleted";
        }
@GetMapping("/addUsers")
public String addUser(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "addUsers";
        }

@GetMapping("/userAdded")
public String formUser(Model model,  @RequestParam String pass, @RequestParam String name, @RequestParam String surname,@RequestParam String email){
        userRepository.save(new User(name,surname,pass,email));
        model.addAttribute("user",name);
        return "userAdded";
        }

@GetMapping("/user/{id}/modifyUser")
public String modifyUser(Model model, @PathVariable Long id){
        model.addAttribute("name", userRepository.findById(id).get().getName());
        model.addAttribute("surname", userRepository.findById(id).get().getSurname());
        model.addAttribute("pass", userRepository.findById(id).get().getPass());
        model.addAttribute("email", userRepository.findById(id).get().getEmail());
        return "modifyUser";
        }

@GetMapping("/user/{id}/userModified")
public String userModified(Model model,  @RequestParam String pass, @RequestParam String name, @RequestParam String surname,@PathVariable Long id){
        userRepository.findById(id).get().setName(name);
        userRepository.findById(id).get().setSurname(surname);
        userRepository.findById(id).get().setPass(pass);
        model.addAttribute("name", userRepository.findById(id).get().getName());
        return "userModified";
        }
        }
*/