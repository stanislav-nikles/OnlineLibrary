package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Genre;

import java.util.List;

/**
 * Service class for {@link Genre}
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
public interface GenreService {

    List<Genre> findAll();

    Genre findById(Long id);

    Genre findByName(String name);

    void save(Genre genre);

    void deleteById(Long id);

    void deleteByName(String name);
}
