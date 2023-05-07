package com.example.catalog.service;

import com.example.catalog.model.Book;
import com.example.catalog.model.dto.request.BookRequest;
import com.example.catalog.model.dto.response.BookResponse;
import com.example.catalog.repository.BookRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public long countBooks(){
        return bookRepository.count();
    }

    public List<BookResponse> readAllBooks(){
        return bookRepository.find();
    }

    public BookResponse readBook(Long id){

        Optional<BookResponse> optionalBookResponse = bookRepository.find(id);

        if(optionalBookResponse.isEmpty()){
            throw new NoSuchElementException("A Book with this id does not exist!");
        }

        return optionalBookResponse.get();
    }

    @Transactional
    public BookResponse createBook(BookRequest bookRequest){

        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setSummary(bookRequest.summary());
        book.setIsbn(bookRequest.isbn());
        book.setGenres(new ArrayList<>());

        bookRepository.save(book);

        return new BookResponse(book);
    }

    @Transactional
    public BookResponse updateBook(Long id, BookRequest bookRequest){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new NoSuchElementException("A Book with this id does not exist!");
        }
        else {
            Book book = optionalBook.get();
            book.setTitle(bookRequest.title());
            book.setSummary(bookRequest.summary());
            book.setIsbn(bookRequest.isbn());

            book = bookRepository.update(book);
            return new BookResponse(book);
        }
    }

    @Transactional
    public String deleteBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new NoSuchElementException("A Book with this id does not exist!");
        }
        else {
            bookRepository.delete(optionalBook.get());
            return "success";
        }
    }

}
