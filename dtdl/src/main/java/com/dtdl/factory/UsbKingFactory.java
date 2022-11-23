package com.dtdl.factory;

import com.dtdl.service.UsbSell;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 14:49
 */

//定义的厂家 目标类 金士顿厂家 不接受用户的单独购买
public class UsbKingFactory implements UsbSell {

    @Override
    public float sell(int amount) {
        System.out.println("目标方法调用");
        //一个128G的u盘 85元
        //后期根据amount，可以实现不同的价格 列入10000个 单价80 50000单价75
        return 85.0f;
    }
}
