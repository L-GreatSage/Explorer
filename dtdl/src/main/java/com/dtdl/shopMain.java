package com.dtdl;

import com.dtdl.shangjia.TaoBao;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: fzykd
 * Date: 2022-11-23
 * Time: 14:59
 */

public class shopMain {
    public static void main(String[] args) {
        //创建一个代理对象的淘宝对象
        TaoBao taoBao = new TaoBao();
        float price = taoBao.sell(1);
        System.out.println("通过淘宝的商家，购买u盘的单价"+price);
    }

}
