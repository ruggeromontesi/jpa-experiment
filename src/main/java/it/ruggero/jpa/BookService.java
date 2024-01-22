package it.ruggero.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository repository;

    public void save(Book book) {
        repository.save(book);
    }

    public void doSomeMess(Book book) {
        repository.save(book);
        Book savedBook = repository.findById(book.getId()).orElseThrow();
        book.setTitle("new title");
        Book updatedBook = repository.saveAndFlush(book);
        Book retrievedBook = repository.findById(book.getId()).orElseThrow();
        System.out.println("");
    }

    public Book update(Book book){
        Book updatedBook = repository.saveAndFlush(book);
        Book retrievedBook = repository.findById(book.getId()).orElseThrow();

        assert updatedBook.equals(retrievedBook);
        return updatedBook;
    }


    public Book getById(long id) {
        return repository.findById(id).orElseThrow();
    }



}

