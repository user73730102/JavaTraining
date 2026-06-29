package com.mmcoe.dao;

import java.util.List;
import java.util.Vector;

import com.mmcoe.pojo.Book;

public class BookDaoCollectionImpl implements BookDao {

	private List<Book> books;
	
	public BookDaoCollectionImpl(List<Book> books) {
		books=new Vector<Book>();
	}

	@Override
	public boolean save(Book b) {
		// TODO Auto-generated method stub
		books.add(b);
		return true;
	}

	@Override
	public Book find(int isbn) {
		// TODO Auto-generated method stub
		for (Book book : books) {
			if(book.getIsbn()==isbn)
				return book;
		}
		return null;
	}

	@Override
	public List<Book> list() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public boolean delete(int isbn) {
		// TODO Auto-generated method stub
		for (Book book : books) {
			if(book.getIsbn()==isbn) {
				books.remove(book);
				return true;
			}
		}
		return false;
	}

	
	
}
