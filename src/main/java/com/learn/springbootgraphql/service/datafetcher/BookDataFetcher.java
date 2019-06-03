package com.learn.springbootgraphql.service.datafetcher;

import com.learn.springbootgraphql.model.Book;
import com.learn.springbootgraphql.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author r0k00xp
 */
@Service
@Slf4j
public class BookDataFetcher implements DataFetcher<Book> {

    private BookRepository bookRepository;

    @Autowired
    public BookDataFetcher(@NonNull BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        String isbn = dataFetchingEnvironment.getArgument("id");
        log.info("fetch isbn :" + isbn);
        return bookRepository.getOne(isbn);
    }
}
