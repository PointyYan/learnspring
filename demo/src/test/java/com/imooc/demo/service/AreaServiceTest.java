package com.imooc.demo.service;

import com.imooc.demo.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 22:15 2018/3/27
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() {
        List<Area> areaList = areaService.getAreaList();
        Assert.assertEquals(2, areaList.size());
    }



}
