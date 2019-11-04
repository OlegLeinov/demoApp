package demo.app.demoApp.repositories;

import demo.app.demoApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
