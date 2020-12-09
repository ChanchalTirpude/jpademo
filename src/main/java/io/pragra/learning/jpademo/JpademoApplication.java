package io.pragra.learning.jpademo;


import com.sun.corba.se.impl.orb.PrefixParserData;
import io.pragra.learning.jpademo.domain.Author;
import io.pragra.learning.jpademo.domain.Book;
import io.pragra.learning.jpademo.domain.RefData;
import io.pragra.learning.jpademo.domain.StatusEnum;
import io.pragra.learning.jpademo.repo.AuthRepo;
import io.pragra.learning.jpademo.repo.BookRepo;
import io.pragra.learning.jpademo.repo.RefDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Ref;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication

public class JpademoApplication {
    @Autowired
    private BookRepo repo;

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private RefDataRepo refDataRepo;
//
//    public JpademoApplication(AuthRepo authRepo) {
//        this.authRepo = authRepo;
//    }

    public static void main(String[] args) {
        SpringApplication.run(JpademoApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(){
        return args -> {
            Author Auth1 = new Author("John doe","ABC company",null,new Date(),new Date(), StatusEnum.Active);
            Author Auth2 = new Author("Jean doe","ABC company",null,new Date(),new Date(), StatusEnum.Active);
            Author Auth3 = new Author("Adam","ABC company",null,new Date(),new Date(), StatusEnum.Active);

  //          auth1 = authRepo.save(auth1);
 //         Author Auth4 = Author("Chanchal","ABC company",null,new Date(),new Date(), StatusEnum.Active);

            Book book = new Book(1234L,"learning Java", Auth1,"Technical",200.00);
            Book book2 = new Book(1235L,"learning reac",Auth2,"Technical",200.00);
            Book save = repo.save(book);
            Book save2 = repo.save(book2);
            repo.findById(2L);
 //           book2.setAuthor("Sashi");
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Type Something");
//            scanner.next();
            repo.save(save2);
            repo.save(new Book(1234L,"learning ABC",Auth3,"Technical",200.00));
            repo.findById(2L).ifPresent(System.out::println);
      //      System.out.println(repo.ge());
            //      System.out.println(repo.findallnative());
            refDataRepo.save(new RefData("Apple" , "Fruit"));
            refDataRepo.save(new RefData("Orange","Fruit"));

        };

    }
}
