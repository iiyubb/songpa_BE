package com.ohgiraffers.associationmapping.section02.onetomany;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OneToManyService {

    private OneToManyRepository oneToManyRepository;

    public OneToManyService(OneToManyRepository oneToManyRepository) {
        this.oneToManyRepository = oneToManyRepository;
    }

    @Transactional
    public Category findCategory(int categoryCode) {
        Category category = oneToManyRepository.find(categoryCode);
        System.out.println("category : " + category);
        return category;
    }
}