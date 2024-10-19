package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String displayAllUser(Model model){
        model.addAttribute("users",userService.getUsersList());
        return "users/allUsers";
    }

    @GetMapping("/show")
    public String showUser(@RequestParam("id") int id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam("id") int id){
        model.addAttribute("user",userService.getUser(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user){
        userService.editUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete (@RequestParam("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
