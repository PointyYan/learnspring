package com.smart.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @Author: VaporYan
 * @Decription: 所有PO类的基类，实现Serializable接口
 * @Date: Created in 13:29 2018/4/29
 * @Modified By:
 */
public class BaseDomain implements Serializable {

    //统一的toString方法
    @Override
    public String toString() {
        //将PO对象打印为一个字符串，由toString完成
        return ToStringBuilder.reflectionToString(this);
    }
}
