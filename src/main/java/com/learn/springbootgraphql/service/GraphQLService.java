package com.learn.springbootgraphql.service;

import com.learn.springbootgraphql.Config;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * @author r0k00xp
 */
@Service
@Slf4j
public class GraphQLService {


    private Resource resource;
    private Config config;
    private GraphQL graphQL;
    private DataFetcher allBooksDataFetcher;
    private DataFetcher bookDataFetcher;


    @Autowired
    public GraphQLService(@NonNull @Value("classpath:books.graphql") Resource resource,
                          @NonNull Config config,
                          @NonNull DataFetcher allBooksDataFetcher,
                          @NonNull DataFetcher bookDataFetcher) {
        this.resource = resource;
        this.config = config;
        this.allBooksDataFetcher = allBooksDataFetcher;
        this.bookDataFetcher = bookDataFetcher;
        log.info("Config : {} and resource : {}", config, resource);
    }


    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser()
                .parse(schemaFile);
        RuntimeWiring runtimeWiring = buildRuntimeWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator()
                .makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();

    }


    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(config.getQuery(), typeWiring -> typeWiring
                        .dataFetcher(config.getAllBookDataFetcher(), allBooksDataFetcher)
                        .dataFetcher(config.getBookDataFetcher(), bookDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
