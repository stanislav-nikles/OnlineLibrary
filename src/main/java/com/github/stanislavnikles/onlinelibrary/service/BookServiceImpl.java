package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Book;
import com.github.stanislavnikles.onlinelibrary.domain.Genre;
import com.github.stanislavnikles.onlinelibrary.domain.Publisher;
import com.github.stanislavnikles.onlinelibrary.persistance.BookRepository;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

/**
 * Implementations of {@link BookService} interface.
 * This service is able to retrieve book data by means of {@link BookRepository}.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return Optional.of(bookRepository.findAll())
                .orElse(ImmutableList.of());
    }

    @Override
    public List<Book> findPopular() {
        return bookRepository.findTop5ByOrderByRatingDesc()
                .orElse(ImmutableList.of());
    }

    @Override
    public List<Book> findByGenre(@NonNull Genre genre) {
        return bookRepository.findBooksByGenre(genre)
                .orElse(ImmutableList.of());
    }

    @Override
    public List<Book> findByPublisher(@NonNull Publisher publisher) {
        return bookRepository.findBooksByPublisher(publisher)
                .orElse(ImmutableList.of());
    }

    @Override
    public Book findById(@NonNull Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new NoResultException("No book found with id " + id));
    }

    @Override
    public Book findByName(@NonNull String name) {
        return bookRepository.findBookByName(name)
                .orElseThrow(() ->
                        new NoResultException("No book found with name " + name));
    }

    @Override
    public Book findByIsbn(@NonNull String isbn) {
        return bookRepository.findBookByIsbn(isbn)
                .orElseThrow(() ->
                        new NoResultException("No book with isbn " + isbn));
    }

    @Override
    public void save(@NonNull Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        final Book book = findByIsbn(isbn);
        bookRepository.delete(book);
    }
}
