package org.doit;

import org.doit.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aidar Shaifutdinov.
 */
@Controller
public class MainController {

    private static List<User> users = new ArrayList<>();

    @GetMapping("/view/{name}")
    public String view(@PathVariable("name") String name, Model model) {
        model.addAttribute("msg", "Привет " + name);
        return "/index";
    }

    @GetMapping("/raw")
    @ResponseBody
    public String raw() {
        return "Raw data";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/users/new")
    public String getSignUp() {
        return "/sign_up";
    }

    @PostMapping("/users/new")
    public String signUp(@ModelAttribute User user) {
        users.add(user);
        return "redirect:/users";
    }

}
