package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Publisher;

import java.util.List;

/**
 * Service class for {@link com.github.stanislavnikles.onlinelibrary.domain.Publisher}.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
public interface PublisherService {

    List<Publisher> findAll();

    Publisher findById(Long id);

    Publisher findByName(String name);

    void save(Publisher publisher);

    void deleteById(Long id);

    void deleteByName(String name);
}
