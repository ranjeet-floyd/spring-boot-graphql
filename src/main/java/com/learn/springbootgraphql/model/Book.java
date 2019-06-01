package com.learn.springbootgraphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author r0k00xp
 *
 */
@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String isn;
    private String title;
    private String publisher;
    private String[] authors;
    private String publishedDate;
}
