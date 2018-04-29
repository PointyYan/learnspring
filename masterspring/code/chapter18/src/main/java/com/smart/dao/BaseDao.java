package com.smart.dao;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author: VaporYan
 * @Decription: 所有DAO的基类
 * @Date: Created in 14:45 2018/4/29
 * @Modified By:
 */
public class BaseDao<T> {
    private Class<T> entityClass;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 通过反射获取子类确定的泛类型
     */
    private BaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    /**
     * Description: 根据ID加载PO类
     * @param: [id]
     * @return: T
     */
    public T load(Serializable id) {
        return (T)getHibernateTemplate().load(entityClass,id);
    }
    
    /**
     * Description: 根据ID获取PO实例
     * @param: [id]
     * @return: T
     */
    public T get(Serializable id) {
        return (T) getHibernateTemplate().get(entityClass, id);
    }

    /**
     * Description: 获取PO所有对象
     *
     * @param:
     * @return: List
     */
    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    /**
     * 保存PO
     *
     * @param entity
     */
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    /**
     * 删除PO
     *
     * @param entity
     */
    public void remove(T entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * 更改PO
     *
     * @param entity
     */
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    /**
     * Description: 执行hql查询
     *
     * @param: hql
     * @return: 查询结果
     */
    public List find(String hql) {
        return this.getHibernateTemplate().find(hql);
    }

    /**
     * Description: 执行带参的hql查询
     *
     * @param:
     * @return:
     */
    public List find(String hql, Object... params) {
        return this.getHibernateTemplate().find(hql, params);
    }




    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
