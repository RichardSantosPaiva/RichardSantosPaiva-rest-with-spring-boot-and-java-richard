package br.com.richard.services;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.richard.model.Book;

@Service
public class BookServices {
	
	private Logger logger = Logger.getLogger(BookServices.class.getName());
	
	public List<Book>findAll(){	
		
		logger.info("findig all books");
		List<Book> listBook = new ArrayList<>();
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));

		for(int i = 0 ; i <= 14; i++) {
			Book book = new Book();
			book.setAuthor("author" + i);
			book.setLaunchDate(new Date());
			String formattedPrice = decimalFormat.format(Math.random()*100);
			book.setPrice(Double.parseDouble(formattedPrice.replaceAll(",", ".")));
			book.setTitle("title"+ i);
			listBook.add(book);
		}
		
		return listBook;	
	}
	
	public Book findById(Long id){	
			
			logger.info("findig one book");
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));

			Book oneBook =  new Book();
			
			oneBook.setAuthor("author" + id);
			oneBook.setLaunchDate(new Date());;
			String formattedPrice = decimalFormat.format(Math.random()*100);
			oneBook.setPrice(Double.parseDouble(formattedPrice.replaceAll(",", ".")));
			oneBook.setTitle("title"+ id);
			
			return  oneBook;	
	}
	
	public Book create(Book book){	
		logger.info("create one book");
		return  book;	
	}
	
	public Book update(Book book){	
		logger.info("update one book");
		return  book;	
	}
	
	public void delete(Long id){	
		logger.info("delete one book");
	}
	
	
}
