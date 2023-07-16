package com.bogdyMusicLover.controller;

import com.bogdyMusicLover.dto.ConstructionGelRequest;
import com.bogdyMusicLover.service.ConstructionGelService;
import com.bogdyMusicLover.service.ProductBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/construction-gel")
public class ConstructionGelController {


    private final ConstructionGelService constructionGelService;
    private final ProductBrandService productBrandService;

    @GetMapping("/available-gels")
    public String getAllConstructionGelsAvailable(Model model) {
        model.addAttribute("gels", constructionGelService.getAllAvailable());
        return "construction-gels";
    }

    @GetMapping("/add-form")
    public String addForm(Model model) {
        model.addAttribute("brands", productBrandService.getAll());
        model.addAttribute("gelRequest", new ConstructionGelRequest());
        return "add-construction-gel";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute ConstructionGelRequest request, Model model) {
        constructionGelService.add(request);
        model.addAttribute("gels", constructionGelService.getAllAvailable());
        return "construction-gels";
    }
}
