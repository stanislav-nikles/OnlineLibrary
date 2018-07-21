package com.github.stanislavnikles.onlinelibrary.persistance;

import com.github.stanislavnikles.onlinelibrary.domain.Book;
import com.github.stanislavnikles.onlinelibrary.domain.Genre;
import com.github.stanislavnikles.onlinelibrary.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Class provide basic CRUD operations for {@link Book}, extends {@link JpaRepository} interface.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Retrieves all instances of the {@link Book} by {@link Genre}.
     *
     * @param genre must not be {@literal null}.
     * @return the {@link Book}'s with the given {@link Genre} or {@literal Optional.empty()} if none found.
     */
    Optional<List<Book>> findBooksByGenre(Genre genre);


    /**
     * Retrieves all instance of {@link Book} by {@link Publisher}.
     *
     * @param publisher must not be {@literal null}.
     * @return the {@link Book}'s with the given {@link Publisher} or {@literal Optional.empty()} if none found.
     */
    Optional<List<Book>> findBooksByPublisher(Publisher publisher);

    /**
     * Retrieves {@link Book} by name.
     *
     * @param name must not be {@literal null}.
     * @return the {@link Book} with the given name or {@literal Optional.empty()} if none found.
     */
    Optional<Book> findBookByName(String name);

    /**
     * Retrieves {@link Book} by isbn.
     *
     * @param isbn must not be {@literal null}.
     * @return the {@link Book} with the given isbn or {@literal Optional.empty()} if none found.
     */
    Optional<Book> findBookByIsbn(String isbn);

    /**
     * Retrieves top 5 most popular {@link Book}'s by rating.
     *
     * @return top 5 most popular {@link Book}'s or {@literal Optional.empty()} if none found.
     */
    Optional<List<Book>> findTop5ByOrderByRatingDesc();
}
