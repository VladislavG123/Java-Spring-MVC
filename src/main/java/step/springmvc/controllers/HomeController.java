package step.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import step.springmvc.Book;
import step.springmvc.DbManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {
        var books = DbManager.getAllBooks();

        model.addAttribute("books", books);

        return "home";
    }

    @GetMapping("/find")
    public String getByName(@RequestParam(name="name") String name,
                          Model model) {

        var books = DbManager.getBooksByName(name);

        model.addAttribute("books", books);

        return "home";
    }


    @GetMapping("/info")
    public String getInfo() {
        return "info";
    }

}
