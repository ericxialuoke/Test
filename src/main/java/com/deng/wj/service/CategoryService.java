package com.deng.wj.service;

import com.deng.wj.dao.CategoryDao;
import com.deng.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> list(){
//        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return categoryDao.findAll();
    }

    public Category get(int id){
        return categoryDao.findById(id).orElse(null);
    }
}
