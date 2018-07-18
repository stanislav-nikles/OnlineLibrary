package com.github.stanislavnikles.onlinelibrary.persistance;

import com.github.stanislavnikles.onlinelibrary.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
