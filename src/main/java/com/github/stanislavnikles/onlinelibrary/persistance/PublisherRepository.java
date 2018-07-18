package com.github.stanislavnikles.onlinelibrary.persistance;

import com.github.stanislavnikles.onlinelibrary.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
