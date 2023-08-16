package com.example.myspringblogapp.controllers;

import com.example.myspringblogapp.models.ArticleModel;
import com.example.myspringblogapp.services.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/write-article")
    public ModelAndView writeArticle(ArticleModel articleModel) {
        ModelAndView modelAndView = new ModelAndView("write-your-article");
        modelAndView.addObject("articleModel", articleModel);

        return modelAndView;
    }

    @PostMapping("/create-article")
    public String createArticle(@Valid ArticleModel articleModel, BindingResult result, Model model) {
            ArticleModel item = new ArticleModel();

            item.setTitle(articleModel.getTitle());
            item.setAuthor(articleModel.getAuthor());
            item.setDescription(articleModel.getDescription());

            articleService.save(articleModel);

            return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") Long id, Model model) {
        ArticleModel articleItem = articleService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: "+ id + " not found"));

        articleService.delete(articleItem);

        return "redirect:/";
    }
}
