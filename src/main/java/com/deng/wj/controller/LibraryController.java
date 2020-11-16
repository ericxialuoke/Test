package com.deng.wj.controller;


import com.deng.wj.pojo.Book;
import com.deng.wj.pojo.Category;
import com.deng.wj.service.BookService;
import com.deng.wj.service.CategoryService;
import com.deng.wj.untils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/books")
    public List<Book> list(){
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book){
        bookService.addOrUpdate(book);
        return book;
    }

    @GetMapping("/api/categories")
    public List<Category> categoryList(){
        return categoryService.list();
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid){
        if(cid!=0){
            return bookService.listByCategory(cid);
        }
        else{
            return list();
        }
    }

    @PostMapping("/api/covers")
    public String coverUpload(MultipartFile file){
        System.out.println("进入文件上传后端");
        String folder = "D:/ideaProjects/White/white-jotter/src/main/java/com/deng/wj/upload";
        File imageFolder = new File(folder);
        File f = new File(imageFolder,file.getOriginalFilename());
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
