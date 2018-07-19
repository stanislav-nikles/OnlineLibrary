package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Author;
import com.github.stanislavnikles.onlinelibrary.persistance.AuthorRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Implementation of {@link AuthorService} interface.
 * This service is able to retrieve author data by means of {@link AuthorRepository}.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        final List<Author> authors = authorRepository.findAll();
        if (!authors.isEmpty()) {
            return authors;
        }
        return ImmutableList.of();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NoResultException("No author found with id " + id));
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findByFullName(name)
                .orElseThrow(() -> new NoResultException("No author found with name " + name));
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        final Author author = findByName(name);
        authorRepository.delete(author);
    }
}
