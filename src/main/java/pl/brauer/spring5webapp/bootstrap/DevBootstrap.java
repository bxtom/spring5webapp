package pl.brauer.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import pl.brauer.spring5webapp.model.Author;
import pl.brauer.spring5webapp.model.Book;

public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private void initData() {
        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
