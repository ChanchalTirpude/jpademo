package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorbyId(@PathVariable Long id){
        // return  servrice.getBookbyId(id).orElseThrow(()-> new BookNotFoundException("Book With ID"+id+"Not in database"));
        return  authorService.getAuthorbyId(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }
}
