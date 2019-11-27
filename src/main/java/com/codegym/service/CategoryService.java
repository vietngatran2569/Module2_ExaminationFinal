package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Iterable<Category> findAll();
    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
