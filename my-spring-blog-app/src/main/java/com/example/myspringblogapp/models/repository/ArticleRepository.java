package com.example.myspringblogapp.models.repository;

import com.example.myspringblogapp.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository  extends JpaRepository<ArticleModel, Long> {
}
