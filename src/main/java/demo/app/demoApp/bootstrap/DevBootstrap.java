package demo.app.demoApp.bootstrap;

import demo.app.demoApp.model.Author;
import demo.app.demoApp.model.Book;
import demo.app.demoApp.model.Publisher;
import demo.app.demoApp.repositories.AuthorRepository;
import demo.app.demoApp.repositories.BookRepository;
import demo.app.demoApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo publisher");

        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "SurnameEric");
        Book ddd = new Book("Domain driven design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development withour EJB", "2345", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
