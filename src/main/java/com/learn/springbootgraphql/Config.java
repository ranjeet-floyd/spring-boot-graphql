package com.learn.springbootgraphql;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author r0k00xp
 */
@Configuration
@Data
@NoArgsConstructor
@ToString
public class Config {

    @Value(value = "${graphql.query.name}")
    private String query;

    @Value(value = "${graphql.query.Books.fetcher}")
    private String allBookDataFetcher;

    @Value(value = "${graphql.query.book.fetcher}")
    private String bookDataFetcher;

}
