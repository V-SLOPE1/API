package com.example.myspringblogapp.services;

import com.example.myspringblogapp.models.ArticleModel;
import com.example.myspringblogapp.models.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Iterable<ArticleModel> getAll() {
        return articleRepository.findAll();
    }

    public Optional<ArticleModel> getById(Long id) {
        return articleRepository.findById(id);
    }

    public ArticleModel save(ArticleModel articleModel) {
        if (articleModel.getId() == null) {
            articleModel.setCreatedAt(Instant.now());
        }

        articleModel.setUpdatedAt(Instant.now());

        return articleRepository.save(articleModel);
    }

    public void delete(ArticleModel articleModel) {
        articleRepository.delete(articleModel);
    }
}
