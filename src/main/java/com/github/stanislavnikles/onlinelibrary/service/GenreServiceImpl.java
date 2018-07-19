package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Genre;
import com.github.stanislavnikles.onlinelibrary.persistance.GenreRepository;
import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Implementations of {@link GenreService} interface
 * This service is able to retrieve genre data by means of {@link GenreRepository}.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        final List<Genre> genres = genreRepository.findAll();
        if (!genres.isEmpty()) {
            return genres;
        }
        return ImmutableList.of();
    }

    @Override
    public Genre findById(@NonNull Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NoResultException("No genre found with id " + id));
    }

    @Override
    public Genre findByName(@NonNull String name) {
        return genreRepository.findByName(name)
                .orElseThrow(() -> new NoResultException("No genre found with name " + name));
    }

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        final Genre genre = findByName(name);
        genreRepository.delete(genre);
    }
}
