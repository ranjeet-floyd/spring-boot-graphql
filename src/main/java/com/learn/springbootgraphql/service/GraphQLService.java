package com.learn.springbootgraphql.service;

import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
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
public class GraphQLService {
    @Value("classpath:books.graphql")
    private Resource resource;

    private GraphQL graphQL;

    @Autowired
    private DataFetcher allBooksDataFetcher;
    @Autowired
    private DataFetcher bookDataFetcher;

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
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allBooks", allBooksDataFetcher)
                        .dataFetcher("book", bookDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
