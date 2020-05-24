package cn.springcloud.cloudgrpcserver;

import cn.springcloud.grpc.lib.HelloReply;
import cn.springcloud.grpc.lib.HelloRequest;
import cn.springcloud.grpc.lib.SimpleGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                                     .setMessage("Hello =============> " + req.getName())
                                     .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
