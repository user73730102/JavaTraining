package com.mmcoe.dao;

import java.util.List;
import java.util.Vector;

import com.mmcoe.pojo.Book;
import com.mmcoe.service.BookNotFoundException;

public class BookDaoCollectionImpl implements BookDao {

	private List<Book> books;
	
	public BookDaoCollectionImpl(List<Book> books) {
		this.books = books;
	}
	public BookDaoCollectionImpl() {
		this.books = new Vector<Book>();
	}

	@Override
	public boolean save(Book b) {
		// TODO Auto-generated method stub
		books.add(b);
		return true;
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException {
		// TODO Auto-generated method stub
		for (Book book : books) {
			if(book.getIsbn()==isbn)
				return book;
		}
		throw new BookNotFoundException("Book not found");
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

	@Override
	public List<Book> findByPrice(double min, double max) {
		// TODO Auto-generated method stub
		List<Book> res=new Vector<Book>();
		for (Book book : books) {
			if(book.getPrice()>=min && book.getPrice()<=max) {
				res.add(book);
			}
		}
		if(res.size()==0)
				return null;
		return res;
	}
	
}