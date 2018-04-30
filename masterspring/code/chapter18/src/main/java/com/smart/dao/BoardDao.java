package com.smart.dao;

import com.smart.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

/**
 * @Author: VaporYan
 * @Decription: 扩展BaseDao，并确定泛型的类为Board
 * @Date: Created in 11:44 2018/4/30
 * @Modified By:
 */
@Repository
public class BoardDao extends BaseDao<Board> {

    private static final String GET_BOARD_NUM = "select count(f.boardId) from Board f";

    //获取论坛板块数目
    public long getBoardNum() {
        Iterator<?> iter = getHibernateTemplate().iterate(GET_BOARD_NUM);
        return ((Long) iter.next());
    }

}
