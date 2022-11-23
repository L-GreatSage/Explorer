package com.dtdl.shangjia;

import com.dtdl.factory.UsbKingFactory;
import com.dtdl.service.UsbSell;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 14:53
 */

//淘宝是一个商家 代理 金士顿商家销售
public class TaoBao implements UsbSell {

    //声明商家代理的厂家具体是谁
    private UsbKingFactory factory = new UsbKingFactory();

    //实现销售这个功能
    @Override
    public float sell(int amount) {

        //当用户向商家购买优盘之后 商家要告诉厂家u盘  我买了u盘 厂家要发货了
        float price = factory.sell(amount); //厂家的价格
        //商家 需要加价 也就是代理的价格
        price = price + 25; //增强功能
        //在目标类的调用其他方法类 都是叫增强

        //列如
        System.out.println("返回一个优惠券");

        //增加的价格
        return price;
    }
}
