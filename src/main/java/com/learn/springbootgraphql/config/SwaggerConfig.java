package com.learn.springbootgraphql.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author r0k00xp
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.learn.springbootgraphql"))
                .paths(regex("/rest.*"))
                .build();
    }
}


