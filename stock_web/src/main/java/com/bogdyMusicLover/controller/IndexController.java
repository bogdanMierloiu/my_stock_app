package com.bogdyMusicLover.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {


    @RequestMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @RequestMapping("/menu")
    public String showMenuPage(){
        return "menu";
    }

}
