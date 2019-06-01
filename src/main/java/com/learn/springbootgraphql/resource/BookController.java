package com.learn.springbootgraphql.resource;

import com.learn.springbootgraphql.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author r0k00xp
 */
@RequestMapping("/rest/books")
@RestController
public class BookController {

    @Autowired
    private GraphQLService graphQLService;

    @GetMapping
    public ResponseEntity<String> echo(){
        return new ResponseEntity<>("Echo", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExecutionResult> getAllBooks(@RequestBody String query) {
        ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }
}
