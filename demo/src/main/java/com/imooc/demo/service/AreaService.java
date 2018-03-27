package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 21:39 2018/3/27
 * @Modified By:
 */
public interface AreaService {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Area> getAreaList();

    /**
     * 根据Id列出具体区域
     *
     * @param areaId
     * @return area
     */
    Area queryAreaById(int areaId);

    /**
     * 增加区域信息
     *
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除某条信息
     *
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
