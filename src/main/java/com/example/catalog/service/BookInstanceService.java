package com.example.catalog.service;

import com.example.catalog.model.BookInstance;
import com.example.catalog.model.dto.request.BookInstanceRequest;
import com.example.catalog.model.dto.response.BookInstanceResponse;
import com.example.catalog.repository.BookInstanceRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class BookInstanceService {
    private final BookInstanceRepository bookInstanceRepository;

    public BookInstanceService(BookInstanceRepository bookInstanceRepository) {
        this.bookInstanceRepository = bookInstanceRepository;
    }

    public long countBookInstances(){
        return bookInstanceRepository.count();
    }

    public List<BookInstanceResponse> readAllBookInstances(){
        return bookInstanceRepository.find();
    }

    public BookInstanceResponse readBookInstance(Long id){

        Optional<BookInstanceResponse> optionalBookInstanceResponse = bookInstanceRepository.find(id);

        if(optionalBookInstanceResponse.isEmpty()){
            throw new NoSuchElementException("A Book Instance with this id does not exist!");
        }

        return optionalBookInstanceResponse.get();
    }

    @Transactional
    public BookInstanceResponse createBookInstance(BookInstanceRequest bookInstanceRequest){

        BookInstance bookInstance = new BookInstance();

        bookInstance.setImprint(bookInstanceRequest.imprint());
        bookInstance.setDueBack(bookInstanceRequest.dueBack());
        bookInstance.setStatus(BookInstance.LOAN_STATUS.valueOf(bookInstanceRequest.status()));

        bookInstance = bookInstanceRepository.save(bookInstance);
        return new BookInstanceResponse(bookInstance);
    }

    @Transactional
    public BookInstanceResponse updateBookInstance(Long id, BookInstanceRequest bookInstanceRequest){
        Optional<BookInstance> optionalBookInstance = bookInstanceRepository.findById(id);
        if(optionalBookInstance.isEmpty()){
            throw new NoSuchElementException("A Book Instance with this id does not exist!");
        }
        else {
            BookInstance bookInstance = optionalBookInstance.get();

            bookInstance.setImprint(bookInstanceRequest.imprint());
            bookInstance.setDueBack(bookInstanceRequest.dueBack());
            bookInstance.setStatus(BookInstance.LOAN_STATUS.valueOf(bookInstanceRequest.status()));

            bookInstance = bookInstanceRepository.update(bookInstance);
            return new BookInstanceResponse(bookInstance);
        }
    }

    @Transactional
    public String deleteBookInstance(Long id){
        Optional<BookInstance> optionalBookInstance = bookInstanceRepository.findById(id);
        if(optionalBookInstance.isEmpty()){
            throw new NoSuchElementException("A Book Instance with this id does not exist!");
        }
        else {
            bookInstanceRepository.delete(optionalBookInstance.get());
            return "success";
        }
    }
}
