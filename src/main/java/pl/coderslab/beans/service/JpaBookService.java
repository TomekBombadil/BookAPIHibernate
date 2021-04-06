package pl.coderslab.beans.service;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.beans.model.Book;
import pl.coderslab.beans.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> read(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(long id) {
        bookRepository.delete(read(id).orElseThrow(() -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");}));
    }
}
