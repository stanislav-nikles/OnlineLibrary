package com.github.stanislavnikles.onlinelibrary.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
