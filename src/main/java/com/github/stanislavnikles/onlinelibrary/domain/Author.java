package com.github.stanislavnikles.onlinelibrary.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object that represent Author of {@link Book}.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
