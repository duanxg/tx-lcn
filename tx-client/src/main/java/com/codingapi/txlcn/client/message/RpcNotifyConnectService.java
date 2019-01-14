package com.codingapi.txlcn.client.message;

import com.codingapi.txlcn.client.message.helper.RpcExecuteService;
import com.codingapi.txlcn.client.message.helper.TransactionCmd;
import com.codingapi.txlcn.commons.exception.SerializerException;
import com.codingapi.txlcn.commons.exception.TxClientException;
import com.codingapi.txlcn.spi.message.params.NotifyConnectParams;
import com.codingapi.txlcn.spi.message.RpcClientInitializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;

/**
 * Description:
 * Company: CodingApi
 * Date: 2018/12/29
 *
 * @author codingapi
 */
@Service(value = "rpc_notify-connect")
@Slf4j
public class RpcNotifyConnectService implements RpcExecuteService {

    private final RpcClientInitializer rpcClientInitializer;

    @Autowired
    public RpcNotifyConnectService(RpcClientInitializer rpcClientInitializer) {
        this.rpcClientInitializer = rpcClientInitializer;
    }

    @Override
    public Object execute(TransactionCmd transactionCmd) throws TxClientException {
        try {

            log.info("transactionCmd->{}", transactionCmd);

            NotifyConnectParams notifyConnectParams = transactionCmd.getMsg().loadData(NotifyConnectParams.class);

            log.info("notifyConnectParams->{}", notifyConnectParams);

            rpcClientInitializer.connect(new InetSocketAddress(notifyConnectParams.getHost(), notifyConnectParams.getPort()));
        } catch (SerializerException e) {
            throw new TxClientException(e);
        }

        return null;
    }
}