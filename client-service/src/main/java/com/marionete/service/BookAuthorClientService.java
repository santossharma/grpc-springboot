package com.marionete.service;

import com.google.protobuf.Descriptors;
import com.marionete.proto.Author;
import com.marionete.proto.BookAuthorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by santoshsharma on 12 May, 2022
 */

@Service
public class BookAuthorClientService {

    @GrpcClient("grpc-marionete-service")
    BookAuthorServiceGrpc.BookAuthorServiceBlockingStub synchronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getAuthor(int authorId) {

        /*ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        BookAuthorServiceGrpc.BookAuthorServiceBlockingStub stub = BookAuthorServiceGrpc.newBlockingStub(channel);
        Author authorResponse = stub.getAuthor(Author.newBuilder().setAutherId(authorId).build());
        channel.shutdown();*/

        Author authorRequest = Author.newBuilder().setAutherId(authorId).build();
        Author authorResponse = synchronousClient.getAuthor(authorRequest);

        return authorResponse.getAllFields();
    }

}
