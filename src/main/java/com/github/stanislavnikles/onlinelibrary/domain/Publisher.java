package com.github.stanislavnikles.onlinelibrary.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represent Publisher of {@link Book}.
 *
 * @author Stanislav Nikles
 * @since 1.0
 */
@Data
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
