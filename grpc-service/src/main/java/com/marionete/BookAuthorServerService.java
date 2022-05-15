package com.marionete;

import com.marionete.proto.Author;
import com.marionete.proto.BookAuthorServiceGrpc;
import com.marionete.proto.TempDB;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Created by santoshsharma on 12 May, 2022
 */

@GrpcService
public class BookAuthorServerService extends BookAuthorServiceGrpc.BookAuthorServiceImplBase {

    @Override
    public void getAuthor(Author request, StreamObserver<Author> responseObserver) {
        TempDB.getAuthorFromTempDB().stream().filter(author -> author.getAutherId() == request.getAutherId()).findFirst()
                .ifPresent(responseObserver::onNext);

        responseObserver.onCompleted();
    }
}
