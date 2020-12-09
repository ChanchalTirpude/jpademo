package io.pragra.learning.jpademo.service;

import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.exceptions.AuthorNotFoundException;
import io.pragra.learning.jpademo.repo.AuthRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthRepo repo;

    public AuthorService(AuthRepo repo) {
        this.repo = repo;
    }

    public Author getAuthorbyId(Long id){
        Optional<Author> byId = this.repo.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        } else {
            throw new AuthorNotFoundException("Not Found any Author");
        }

    }
    public List<Author> getAll(){
        return  repo.findAll();
    }

    public Author createAuthor(@RequestBody Author author){
        return repo.save(author);
    }

}
