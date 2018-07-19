package com.github.stanislavnikles.onlinelibrary.persistance;

import com.github.stanislavnikles.onlinelibrary.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Class provide basic CRUD operations for {@link Publisher}, extends {@link JpaRepository} interface.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    /**
     * Retrieves {@link Publisher} by name.
     *
     * @param name must not be {@literal null}
     * @return the {@link Publisher} with the given name or {@literal Optional.empty()} if none found.
     */
    Optional<Publisher> findByName(String name);
}
