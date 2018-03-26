package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in ${Time} 2018/3/26
 * @Modified By: me
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
    }

    @Test
    @Ignore
    public void insertArea() {
    }

    @Test
    @Ignore
    public void updateArea() {
    }

    @Test
    @Ignore
    public void deleteArea() {
    }
}