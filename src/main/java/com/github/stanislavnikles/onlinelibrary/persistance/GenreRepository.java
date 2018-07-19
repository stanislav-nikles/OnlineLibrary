package com.github.stanislavnikles.onlinelibrary.persistance;

import com.github.stanislavnikles.onlinelibrary.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Class provide basic CRUD operations for {@link Genre}, extends {@link JpaRepository} interface.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {

    /**
     * Retrieves {@link Genre} by name.
     *
     * @param name must not be {@literal null}.
     * @return the {@link Genre} with the given name or {@literal Optional.empty()} if none found.
     */
    Optional<Genre> findByName(String name);
}
