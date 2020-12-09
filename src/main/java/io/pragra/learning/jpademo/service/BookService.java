package io.pragra.learning.jpademo.service;

import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.exceptions.BookNot.BookNotFoundException;
import io.pragra.learning.jpademo.repo.BookRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public Book getBookbyId(Long id){
       // return  repo.findById(id).orElseThrow(()-> new BookNotFoundException("Book With ID"+id+"Not in database"));

        Optional<Book> byId = this.repo.findById(id);
        if (byId.isPresent()){
            return byId.get();
        } else {
            throw new BookNotFoundException("Not found any book");
        }
    }

    public List<Book> getAll(){
        return  repo.findAll();
    }

    public Book createBook(@RequestBody Book book){
        return repo.save(book);
    }
}
