package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.model.Goods;
import com.codegym.repository.GoodRepository;
import com.codegym.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodRepository goodRepository;
    @Override
    public Page<Goods> findAll(Pageable pageable) {
        return goodRepository.findAll(pageable);
    }

    @Override
    public Goods findById(Long id) {
        return goodRepository.findById(id).get();
    }

    @Override
    public void save(Goods goods) {
        goodRepository.save(goods);
    }

    @Override
    public void remove(Long id) {
         goodRepository.deleteById(id);
    }

    @Override
    public Page<Goods> findAllByNameContaining(String name, Pageable pageable) {
        return goodRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Goods> findAllByCategory(Pageable pageable, Category category) {
        return goodRepository.findAllByCategory(pageable,category);
    }


    @Override
    public Page<Goods> findAllByOrderByPriceAsc(Pageable pageable) {
        return goodRepository.findAllByOrderByPriceAsc(pageable);
    }

    @Override
    public Page<Goods> findAllByOrderByPriceDesc(Pageable pageable) {
        return goodRepository.findAllByOrderByPriceDesc(pageable);
    }
}
