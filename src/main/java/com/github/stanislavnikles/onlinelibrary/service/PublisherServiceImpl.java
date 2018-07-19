package com.github.stanislavnikles.onlinelibrary.service;

import com.github.stanislavnikles.onlinelibrary.domain.Publisher;
import com.github.stanislavnikles.onlinelibrary.persistance.PublisherRepository;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Implementations of {@link PublisherService} interface.
 * This service is able to retrieve publisher data by means of {@link PublisherRepository}.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        final List<Publisher> publishers = publisherRepository.findAll();
        if (!publishers.isEmpty()) {
            return publishers;
        }
        return ImmutableList.of();
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new NoResultException("No publisher found with id " + id));
    }

    @Override
    public Publisher findByName(String name) {
        return publisherRepository.findByName(name)
                .orElseThrow(() -> new NoResultException("No publisher found with name " + name));
    }

    @Override
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        final Publisher publisher = findByName(name);
        publisherRepository.delete(publisher);
    }
}
