package com.bogdyMusicLover.controller;

import com.bogdyMusicLover.service.ConstructionGelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/construction-gel")
public class ConstructionGelController {


    private final ConstructionGelService constructionGelService;

    @GetMapping("/available-gels")
    public String getAllConstructionGelsAvailable(Model model) {
        model.addAttribute("gels", constructionGelService.getAll());
        return "construction-gels";
    }
}
