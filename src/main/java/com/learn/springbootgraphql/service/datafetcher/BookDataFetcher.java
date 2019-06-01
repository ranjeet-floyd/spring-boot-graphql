package com.learn.springbootgraphql.service.datafetcher;

import com.learn.springbootgraphql.model.Book;
import com.learn.springbootgraphql.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author r0k00xp
 */
@Service
public class BookDataFetcher implements DataFetcher<Book> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
        String isbn = dataFetchingEnvironment.getArgument("id");
        return bookRepository.getOne(isbn);
    }
}
