package com.github.stanislavnikles.onlinelibrary.persistance;

import com.github.stanislavnikles.onlinelibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
