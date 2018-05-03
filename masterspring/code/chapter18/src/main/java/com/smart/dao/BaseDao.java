package com.smart.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: VaporYan
 * @Decription: 所有DAO的基类
 * @Date: Created in 14:45 2018/4/29
 * @Modified By:
 */
public class BaseDao<T> {
    private Class<T> entityClass;

    private HibernateTemplate hibernateTemplate;

    /**
     * 通过反射获取子类确定的泛类型
     */
    public BaseDao() {
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

    /**
     * Description: 对延迟加载的实体PO执行实体化
     *
     * @param: entity
     * @return:
     */
    public void initialize(Object object) {
        this.getHibernateTemplate().initialize(object);
    }

    /**
     * Description: 分页查询函数，使用hql
     *
     * @param:
     * @return:
     */
    public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values) {
        Assert.hasText(hql);
        Assert.isTrue(pageNo >= 1, "Page should start from 1");
        //Count查询
        String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));
        List countList = getHibernateTemplate().find(countQueryString, values);
        long totalCount = (Long) countList.get(0);

        if (totalCount < 1) {
            return new Page();
        }
        //实际查询返回分页对象
        int startIndex = Page.getStartOfPage(pageNo, pageSize);
        Query query = createQuery(hql, values);
        List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();

        return new Page(startIndex, totalCount, pageSize, list);
    }

    /**
     * 创建Query对象. 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
     * 留意可以连续设置,如下：
     * <pre>
     * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
     * </pre>
     * 调用方式如下：
     * <pre>
     *        dao.createQuery(hql)
     *        dao.createQuery(hql,arg0);
     *        dao.createQuery(hql,arg0,arg1);
     *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
     * </pre>
     *
     * @param values 可变参数.
     */
    public Query createQuery(String hql, Object... values) {
        Assert.hasText(hql);
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query;
    }

    /**
     * 去除hql的select 子句，未考虑union的情况,用于pagedQuery.
     *
     * @see #pagedQuery(String,int,int,Object[])
     */
    private static String removeSelect(String hql) {
        Assert.hasText(hql);
        int beginPos = hql.toLowerCase().indexOf("from");
        Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
        return hql.substring(beginPos);
    }

    /**
     * 去除hql的orderby 子句，用于pagedQuery.
     *
     * @see #pagedQuery(String,int,int,Object[])
     */
    private static String removeOrders(String hql) {
        Assert.hasText(hql);
        Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hql);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Session getSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
