package com.marionete.controller;

import com.google.protobuf.Descriptors;
import com.marionete.service.BookAuthorClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by santoshsharma on 12 May, 2022
 */

@RestController
public class BookAuthorController {
    private final BookAuthorClientService bookAuthorClientService;

    @Autowired
    public BookAuthorController(BookAuthorClientService bookAuthorClientService) {
        this.bookAuthorClientService = bookAuthorClientService;
    }

    @GetMapping("/author/{authorId}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String authorId) {
        System.out.println("calling author client " + authorId);
        return bookAuthorClientService.getAuthor(Integer.parseInt(authorId));
    }
}
