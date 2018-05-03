package org.smart4j.chapter2.test;

import org.junit.Before;
import org.smart4j.chapter2.service.CustomerService;

/**
 * @Author: VaporYan
 * @Decription: CustomerService单元测试
 * @Date: Created in 20:32 2018/5/3
 * @Modified By:
 */
public class CustomerServiceTest {

    private final CustomerService customerService;


    public CustomerServiceTest(CustomerService customerService) {
        this.customerService = customerService;
    }

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    /**
     * 初始化数据库
     */
    @Before
    public void init() {
        //TODO
    }

    
}
