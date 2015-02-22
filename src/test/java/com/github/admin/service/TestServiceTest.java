package com.github.admin.service;

import com.github.admin.BaseTest;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * 描述
 *
 * @author changjiang.tang Date:2/21/15 Time:10:21 PM
 */
public class TestServiceTest extends BaseTest {

    @Autowired
    TestService testService;

    @Autowired
    DataSource dataSource;

    @Before
    public void init() {
        try {
            File file = ResourceUtils.getFile("classpath:sql/test-schema.sql");
            new ScriptRunner(dataSource.getConnection()).runScript(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        assertThat("数据库存在记录，删除成功", true, equalTo(testService.delete("张三")));
        assertThat("数据库不存在记录，删除失败", false, equalTo(testService.delete("张三xxx")));
    }

}
