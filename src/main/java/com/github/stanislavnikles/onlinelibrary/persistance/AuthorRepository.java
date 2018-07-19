package com.github.stanislavnikles.onlinelibrary.persistance;

import com.github.stanislavnikles.onlinelibrary.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Class provide basic CRUD operations for {@link Author}, extends {@link JpaRepository} interface.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    /**
     * Retrieves {@link Author} by name.
     *
     * @param name must not be {@literal null}.
     * @return the {@link Author} with the given name or {@literal Optional.empty()} if none found.
     */
    Optional<Author> findByFullName(String name);
}
