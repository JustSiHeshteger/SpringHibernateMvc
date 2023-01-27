package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    ///Display

    @GetMapping("/")
    public String displayUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    ///Display

    ///Add

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    ///Add

    ///Update

    @GetMapping("/editUser/{userId}")
    public String editUser(@PathVariable("userId") int id, Model model){
        model.addAttribute("user", userService.readUser(id));
        return "edit_user";
    }

    @PatchMapping(value="/editUser/{getId}")
    public String saveEditedUser(@PathVariable int getId, @ModelAttribute("user") User user){
        user.setId(getId);
        userService.updateUser(user);
        return "redirect:/";
    }

    ///Update

    ///Delete

    @DeleteMapping("deleteUser/{getId}")
    public String deleteUser(@PathVariable int getId) {
        userService.deleteUser(getId);
        return "redirect:/";
    }

    ///Delete

}
