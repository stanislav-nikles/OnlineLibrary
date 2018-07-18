package com.github.stanislavnikles.onlinelibrary.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publish_year")
    private Integer publishYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "image")
    private String image;

    @Column(name = "descr")
    private String descr;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "vote_count")
    private Integer voteCount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(content, book.content) &&
                Objects.equals(pageCount, book.pageCount) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(publishYear, book.publishYear) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(image, book.image) &&
                Objects.equals(descr, book.descr) &&
                Objects.equals(rating, book.rating) &&
                Objects.equals(voteCount, book.voteCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, pageCount,
                isbn, publishYear, genre, publisher, image, descr, rating, voteCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", pageCount=" + pageCount +
                ", isbn='" + isbn + '\'' +
                ", publishYear=" + publishYear +
                ", genre=" + genre +
                ", publisher=" + publisher +
                ", image='" + image + '\'' +
                ", descr='" + descr + '\'' +
                ", rating=" + rating +
                ", voteCount=" + voteCount +
                '}';
    }
}
