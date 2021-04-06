package pl.coderslab.beans.service;

import pl.coderslab.beans.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> findAll();

    public Optional<Book> read(long id);

    public Book create(Book book);

    public void update(Book book);

    public void delete(long id);
}
