package pl.coderslab.beans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.beans.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

}
