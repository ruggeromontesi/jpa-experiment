package it.ruggero.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    private Long id;
    private String name;

    @Column(name = "BOOK_TITLE", updatable = false, nullable = false)
    private String title;
}
