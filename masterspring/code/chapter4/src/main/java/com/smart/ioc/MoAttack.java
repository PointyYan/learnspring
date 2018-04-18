package com.smart.ioc;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 11:51 2018/4/18
 * @Modified By:
 */
public class MoAttack implements ActorArrangle{

    public void cityGateAsk() {
//        //对象直接进入
//        LiuDeHua ldh = new LiuDeHua();
//        ldh.responseAsk("ssss");

        //引入隔离角色
        GeLi geLi = new LiuDeHua();
        //通过接口来使用
        geLi.responseAsk("ssss");
    }

    public void injectGeli(GeLi geli) {
        
    }
}
