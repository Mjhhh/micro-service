package com.imooc.user.thrift;

import com.imooc.thrift.message.MessageService;
import com.imooc.thrift.user.UserService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Michael on 2017/10/30.
 */
@Component
public class ServiceProvider {

    @Value("${server.thrift.user.ip}")
    private String serverIp;

    @Value("${server.thrift.user.port}")
    private int serverPort;

    @Value("${server.thrift.message.ip}")
    private String messageServerIp;

    @Value("${server.thrift.message.port}")
    private int messageServerPort;

    private enum ServiceType {
        /*用户服务*/
        USER,
        /*消息服务*/
        MESSAGE
    }

    public UserService.Client getUserService() {
        return getService(serverIp, serverPort, ServiceType.USER);
    }

    public MessageService.Client getMessasgeService() {
        return getService(messageServerIp, messageServerPort, ServiceType.MESSAGE);
    }

    public <T> T getService(String ip, int port, ServiceType serviceType) {
        TSocket socket = new TSocket(ip, port);
        TTransport transport = new TFramedTransport(socket, 600);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        //协议对象 这里使用协议对象需要和服务器的一致
        TProtocol protocol = new TCompactProtocol(transport);

        TServiceClient result = null;
        switch (serviceType) {
            case USER:
                result = new UserService.Client(protocol);
                break;
            case MESSAGE:
                result = new MessageService.Client(protocol);
                break;
        }
        return (T)result;
    }

}
