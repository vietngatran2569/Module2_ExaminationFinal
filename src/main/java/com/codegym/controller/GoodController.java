package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Goods;
import com.codegym.service.CategoryService;
import com.codegym.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class GoodController {
    @Autowired
    private GoodService goodService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/goods")
    public ModelAndView listGood(@RequestParam("s") Optional<String> s, @PageableDefault(size = 5) Pageable pageable) {
        Page<Goods> goods;
        if (s.isPresent()) {
            goods = goodService.findAllByNameContaining(s.get(), pageable);
        } else {
            goods = goodService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("good/list");
        modelAndView.addObject("goods", goods);
        return modelAndView;
    }
    @GetMapping("/create-good")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("good/create");
        modelAndView.addObject("good", new Goods());
        return modelAndView;
    }

    @PostMapping("/create-good")
    public ModelAndView saveGood(@ModelAttribute("good") Goods goods) {
        goodService.save(goods);
        ModelAndView modelAndView = new ModelAndView("good/create");
        modelAndView.addObject("good", new Goods());
        modelAndView.addObject("message", "New good created successfully");
        return modelAndView;
    }
    @GetMapping("/edit-good/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Goods goods = goodService.findById(id);
        if (goods != null) {
            ModelAndView modelAndView = new ModelAndView("good/edit");
            modelAndView.addObject("good", goods);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-good")
    public ModelAndView updateGood(@ModelAttribute("good") Goods goods) {
        goodService.save(goods);
        ModelAndView modelAndView = new ModelAndView("good/edit");
        modelAndView.addObject("good", goods);
        modelAndView.addObject("message", "Good Update successful");
        return modelAndView;
    }

    @GetMapping("/delete-good/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Goods goods = goodService.findById(id);
        if (goods != null) {
            ModelAndView modelAndView = new ModelAndView("good/delete");
            modelAndView.addObject("good", goods);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-good")
    public String deleteGood(@ModelAttribute("good") Goods goods) {
        goodService.remove(goods.getId());
        return "redirect:goods";
    }

    @GetMapping("/searchByCategory")
    public ModelAndView getGoodByCategory(@RequestParam("search") int categoryId, Pageable pageable){
        Page<Goods> goods ;
        if (categoryId==-1){
            goods = goodService.findAll(pageable);
        }else {
            Category category = categoryService.findById((long) categoryId);
            goods = goodService.findAllByCategory(pageable,category);
        }
        ModelAndView modelAndView = new ModelAndView("good/list");
        modelAndView.addObject("goods",goods);
        modelAndView.addObject("search",categoryId);
        return modelAndView;
    }

    @GetMapping("/sortByPriceAsc")
    public ModelAndView getMaterialSortByPriceAsc(Pageable pageable){
        Page<Goods> goods = goodService.findAllByOrderByPriceAsc(pageable);
        ModelAndView modelAndView = new ModelAndView("good/list");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

    @GetMapping("/sortByPriceDesc")
    public ModelAndView getMaterialSortByPriceDesc(Pageable pageable){
        Page<Goods> goods = goodService.findAllByOrderByPriceDesc(pageable);
        ModelAndView modelAndView = new ModelAndView("good/list");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }


}
