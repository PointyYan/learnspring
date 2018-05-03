package com.smart.dao;


import com.smart.dataset.util.XlsDataSetBeanFactory;
import com.smart.domain.Board;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * @Author: VaporYan
 * @Decription:
 * @Date: Created in 16:34 2018/4/30
 * @Modified By:
 */
@SpringApplicationContext({"xiaochun-dao.xml"})
public class BoardDaoTest extends BaseDaoTest {

    //注入论坛板块DAO
    @SpringBean("boardDao")
    private BoardDao boardDao;

    /**
     * 添加测试板块
     */
    @Test
    @ExpectedDataSet("Xiaochun.ExpectedBoards.xls") //验证数据
    public void addBoard() throws Exception {
        //通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
//        List<Board> boards = new List<Board>();
        List<Board> boards = XlsDataSetBeanFactory.createBeans(BoardDaoTest.class, "XiaoChun.SaveBoards.xls", "t_board", Board.class);
        for (Board board : boards) {
            boardDao.save(board);
        }
    }

    /**
     * 删除一个版块
     *
     * @param
     */

    @Test
    @DataSet(value = "XiaoChun.Boards.xls")//准备数据
    @ExpectedDataSet(value = "XiaoChun.ExpectedBoards.xls")
    public void removeBoard() {
        Board board = boardDao.get(7);
        boardDao.remove(board);
    }

    @Test
    @DataSet("XiaoChun.Boards.xls")//准备数据
    public void getBoard() {
        Board board = boardDao.load(1);
        assertNotNull(board);
        assertEquals(board.getBoardName(), "育儿");
    }

}

