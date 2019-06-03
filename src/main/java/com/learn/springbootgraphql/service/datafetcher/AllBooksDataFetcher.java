package com.learn.springbootgraphql.service.datafetcher;

import com.learn.springbootgraphql.model.Book;
import com.learn.springbootgraphql.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author r0k00xp
 */
@Service
public class AllBooksDataFetcher implements DataFetcher<List<Book>> {

    private BookRepository bookRepository;

    @Autowired
    public AllBooksDataFetcher(@NonNull BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    private void loadBooks() {
        Stream.of(new Book("978-8192910963", "The Power of your Subconscious Mind", "Amazing Reads", new String[]{"Joseph Murphy"}, Instant.now().toString()),
                new Book("978-1542040464", "In Search of Lost Time ", "Westland", new String[]{"Chetan Bhagat "}, Instant.now().toString())
        ).forEach(b -> bookRepository.save(b));

    }

    @Override
    public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return bookRepository.findAll();
    }


}
