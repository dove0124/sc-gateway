package cn.springcloud.cloudgrpcclient;

import cn.springcloud.grpc.lib.HelloReply;
import cn.springcloud.grpc.lib.HelloRequest;
import cn.springcloud.grpc.lib.SimpleGrpc;
import io.grpc.Channel;

import org.springframework.stereotype.Service;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class GrpcClientService {

    @GrpcClient("cloud-grpc-server")
    private Channel serverChannel;

    public String sendMessage(String name) {
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(serverChannel);
        HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}
