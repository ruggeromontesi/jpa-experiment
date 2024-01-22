package it.ruggero.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository repository;

    public void doSomeMess(Book book) {
        repository.save(book);
        Book savedBook = repository.findById(book.getId()).orElseThrow();
        book.setTitle("new title");
        Book updatedBook = repository.saveAndFlush(book);
        Book retrievedBook = repository.findById(book.getId()).orElseThrow();
        System.out.println("");
    }
}

