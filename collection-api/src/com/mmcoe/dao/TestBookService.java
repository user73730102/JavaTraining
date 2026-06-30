package com.mmcoe.dao;


import java.util.List;
import java.util.Vector;

import com.mmcoe.pojo.Book;
import com.mmcoe.service.BookNotFoundException;
import com.mmcoe.service.BookService;
import com.mmcoe.service.BookServiceImpl;

public class TestBookService {
	public static void main(String[] args) {
		BookDao dao=new BookDaoCollectionImpl();
		BookService service=new BookServiceImpl(dao);
		service.save(new Book(10, "abc", "xyz", 500));
		service.save(new Book(11, "abc1", "xyz1", 400));
		service.save(new Book(12, "abc2", "xyz2", 550));
		for(Book b:service.list())
			System.out.println(b);
		
		try {
			System.out.println(service.find(12));
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Book b : service.findByPrice(400, 600)) {
			System.out.println(b);
		}
		try {
			service.delete(10);
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}