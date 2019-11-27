package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GoodService {
    Page<Goods> findAll(Pageable pageable);

    Goods findById(Long id);

    void save(Goods goods);

    void remove(Long id);

    Page<Goods> findAllByNameContaining(String name, Pageable pageable);

    Page<Goods> findAllByCategory(Pageable pageable, Category category);

    Page<Goods> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Goods> findAllByOrderByPriceDesc(Pageable pageable);
}

