package me.cresterida.learning;

import io.quarkus.grpc.GrpcService;

import io.quarkus.grpc.example.Greeter;
import io.quarkus.grpc.example.HelloReply;
import io.quarkus.grpc.example.HelloReplyALot;
import io.quarkus.grpc.example.HelloRequest;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements Greeter
{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HelloGrpcService.class);
    @Override
    public Uni<HelloReply> sayHello(HelloRequest request)
    {
        log.info("Request from sayHello: " + request.getName());
        return Uni.createFrom().item(() -> HelloReply.newBuilder().setMessage("Hello " + request.getName() +" from sayHello").build() );
    }

    @Override
    public Multi<HelloReplyALot> sayHelloALot(HelloRequest request)
    {
        return null;
    }


}
