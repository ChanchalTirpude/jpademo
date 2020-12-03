package io.pragra.learning.jpademo.repo;

import io.pragra.learning.jpademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
// Custom Methods other than native on findBy...
    List<Book> findByPriceOrderByIsbn(double price);
// example of alias query , its not a native since its not executed on table ,its on entity
    @Query("select count(b) from Book b")
    long findall();
// example of native query
    @Query(value = "select count (*) from table_book",nativeQuery = true)
    long findallnative();
}
