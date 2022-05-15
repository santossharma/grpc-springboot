package com.marionete.proto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santoshsharma on 12 May, 2022
 */

public class TempDB {

    public static List<Author> getAuthorFromTempDB() {
        return new ArrayList<Author>() {
            {
                add(Author.newBuilder().setAutherId(1).setBookId(1)
                        .setFirstName("Santosh").setLastName("Sharma").setGender("Male")
                        .build());
                add(Author.newBuilder().setAutherId(2).setBookId(2)
                        .setFirstName("Sharma").setLastName("Santosh").setGender("Male")
                        .build());
                add(Author.newBuilder().setAutherId(3).setBookId(3)
                        .setFirstName("William").setLastName("Shakespeare").setGender("Male")
                        .build());
            }
        };
    }

    public static List<Book> getBooksFromTempDB() {
        return new ArrayList<Book>() {
            {
                add(Book.newBuilder()
                        .setBookId(1)
                        .setAutherId(1)
                        .setPrice(20.0f)
                        .setTitle("Spring Boot gRPC")
                        .build());
                add(Book.newBuilder()
                        .setBookId(2)
                        .setAutherId(2)
                        .setPrice(650.0f)
                        .setTitle("Hamlet")
                        .build());
                add(Book.newBuilder()
                        .setBookId(3)
                        .setAutherId(3)
                        .setPrice(470.5f)
                        .setTitle("Harry Potter")
                        .build());

            }
        };
    }
}
