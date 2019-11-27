package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GoodRepository extends PagingAndSortingRepository<Goods,Long> {
    Page<Goods> findAllByNameContaining(String name, Pageable pageable);

//    Iterable<Goods> findAllByCategory(Category category);
    Page<Goods> findAllByCategory(Pageable pageable, Category category);

    Page<Goods> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Goods> findAllByOrderByPriceDesc(Pageable pageable);

}
