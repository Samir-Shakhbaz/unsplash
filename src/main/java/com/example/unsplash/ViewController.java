package com.example.unsplash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    UnsplashService unsplashService;

    @GetMapping("/")
    public String displayIndex(Model model) {
        model.addAttribute("searchKeyword", new SearchKeyword());
        return "index";
    }

    @PostMapping("/")
    public String performSearch(@ModelAttribute("searchKeyword") SearchKeyword searchKeyword, Model model) throws InterruptedException {
        ReactiveDataDriverContextVariable reactiveData =
                new ReactiveDataDriverContextVariable(unsplashService.getPhotos(searchKeyword.getText()), 1);

        model.addAttribute("photos", reactiveData);
        model.addAttribute("searchText", searchKeyword.getText());
           if (unsplashService.getTotalPages(searchKeyword.getText()) == null) {
            return "error";
        }
        else{return "index";}
    }


//    @RequestMapping(value = "/" , method = RequestMethod. POST)
//    public void checkBox(@RequestParam("checkboxName")String[] checkboxValue)
//    {
//        if(checkboxValue !=null)
//        {
//              System.out.println("checkbox is checked");
//        }
//        else
//        {
//            System.out.println("checkbox is not checked");
//        }
//    }

}