package com.example.catalog.controller;

import com.example.catalog.model.dto.request.BookRequest;
import com.example.catalog.model.dto.response.BookResponse;
import com.example.catalog.service.BookService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.List;

@Controller("/catalog/api/books")
@Secured(SecurityRule.IS_ANONYMOUS)
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    public List<BookResponse> getAllBooks(){
        return bookService.readAllBooks();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}/")
    public BookResponse getBookById(Long id){
        return bookService.readBook(id);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/")
    public BookResponse createBook(@Body BookRequest bookRequest){
        return bookService.createBook(bookRequest);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{id}/")
    public BookResponse updateBook(Long id, @Body BookRequest bookRequest){
        return bookService.updateBook(id, bookRequest);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Delete("/{id}/")
    public String deleteBook(Long id){
        return bookService.deleteBook(id);
    }
}
