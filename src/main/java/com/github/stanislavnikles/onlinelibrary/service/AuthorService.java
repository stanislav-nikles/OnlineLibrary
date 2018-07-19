package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Author;

import java.util.List;

/**
 * Service class for {@link Author}
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
public interface AuthorService {

    List<Author> findAll();

    Author findById(Long id);

    Author findByName(String name);

    void save(Author author);

    void deleteById(Long id);

    void deleteByName(String name);
}
