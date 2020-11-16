package com.deng.wj.dao;

import com.deng.wj.pojo.Book;
import com.deng.wj.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeAndAuthorLike(String title,String author);
}
