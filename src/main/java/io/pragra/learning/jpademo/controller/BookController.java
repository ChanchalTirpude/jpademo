package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.exceptions.BookNot.BookNotFoundException;
import io.pragra.learning.jpademo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAll(){
        return  service.getAll();
    }

    @GetMapping("/{id}")
    public Book getByID(@PathVariable Long id){
       // return  servrice.getBookbyId(id).orElseThrow(()-> new BookNotFoundException("Book With ID"+id+"Not in database"));
        return  service.getBookbyId(id);
    }

  //  @RequestMapping(value = "/book",method = RequestMethod.POST,consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PostMapping
    public Book createBook(@RequestBody Book book){
       return service.createBook(book);
    }

//    @PutMapping
//    public Book updateBook(@RequestBody Book book){
//        return repo.save(book);
//    } //   @RequestMapping(value = "/book",method = RequestMethod.PUT,consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//
//
//  //  @RequestMapping(value = "/book",method = RequestMethod.DELETE,consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @DeleteMapping
//    public void deleteBook(@RequestBody Book book){
//        repo.delete(book);
//    }
}
