package demo.app.demoApp.repositories;

import demo.app.demoApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
