package com.jiajun.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiajun.springboot.model.Book;
import com.jiajun.springboot.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("save")
	public String save(Book book) {
		bookService.insert(book);
		return "添加成功";
	}
	
	@RequestMapping("index")
	public Object index() {
		return new Book(1L,"springboot", "java书籍", 50.8, 30);
	}
	
	@PostMapping("delete")
	public Object delete(@RequestParam(required=true)Long id) {
		bookService.delete(id);
		return "删除成功";
	}
	
	@RequestMapping("find")
	public Object findById(Long id) {
		return bookService.query(id);
	}
}
