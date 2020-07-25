package com.springframework.SimpleSpringApp.bootstrap;

import com.springframework.SimpleSpringApp.model.Author;
import com.springframework.SimpleSpringApp.model.Book;
import com.springframework.SimpleSpringApp.model.Publisher;
import com.springframework.SimpleSpringApp.repository.AuthorRepository;
import com.springframework.SimpleSpringApp.repository.BookRepository;
import com.springframework.SimpleSpringApp.repository.PublisherRepository;
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

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("Tim");

        publisherRepository.save(publisher);

        Author evgen = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        evgen.getBooks().add(ddd);
        ddd.getAuthors().add(evgen);

        authorRepository.save(evgen);
        bookRepository.save(ddd);

        Author shild = new Author("Gerbert", "Shild");
        Book jv = new Book("Java", "5678", publisher);
        shild.getBooks().add(jv);
        jv.getAuthors().add(shild);

        authorRepository.save(shild);
        bookRepository.save(jv);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
