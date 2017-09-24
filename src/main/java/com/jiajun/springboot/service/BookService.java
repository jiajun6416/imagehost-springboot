package com.jiajun.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiajun.springboot.dao.BookDao;
import com.jiajun.springboot.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	public void insert(Book book) {
		bookDao.save(book);
	}
	
	public void delete(Long id) {
		bookDao.delete(id);
	}
}
