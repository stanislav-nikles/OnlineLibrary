package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Book;
import com.github.stanislavnikles.onlinelibrary.domain.Genre;
import com.github.stanislavnikles.onlinelibrary.domain.Publisher;

import java.util.List;

/**
 * Service class for {@link Book}
 */
public interface BookService {

    List<Book> findAll();

    List<Book> findPopular();

    List<Book> findByGenre(Genre genre);

    List<Book> findByPublisher(Publisher publisher);

    Book findById(Long id);

    Book findByName(String name);

    Book findByIsbn(String isbn);

    void save(Book book);

    void deleteById(Long id);

    void deleteByIsbn(String isbn);
}
