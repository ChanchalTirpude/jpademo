package io.pragra.learning.jpademo.repo;

import io.pragra.learning.jpademo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Author , Long> {

}
