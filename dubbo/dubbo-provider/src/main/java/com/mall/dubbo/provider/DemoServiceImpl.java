package com.mall.dubbo.provider;

import com.alibaba.dubbo.rpc.RpcContext;
import com.mall.dubbo.api.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pc-fengc
 * created by pc-fengc on 2018-10-10 16:48.
 */
public class DemoServiceImpl implements DemoService {

    public String sayName(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return null;
    }
}
