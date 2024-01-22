package it.ruggero.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRepository repository;
    private final BookService service;

    @PostMapping("/save")
    public Book save(@RequestBody Book book){
//        service.doSomeMess(book);
//        return repository.findById(book.getId()).orElseThrow();
       service.save(book);
       return  service.getById(book.getId());

    }

    @GetMapping("book/{id}")
    public Book findById(@PathVariable long id){
        return repository.findById(id).orElseThrow();
    }


    @PutMapping("/update")
    public Book update(@RequestBody Book book){
        return service.update(book);
    }
}
