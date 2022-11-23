package com.dtdl.service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 14:45
 */

//表示功能的 厂家 商家都要完成的功能
public interface UsbSell {
    //定义一个方法 参数是 amount: 表示一次购买的数量
    //返回值表示一个u盘的价格
    float sell(int amount);

}
