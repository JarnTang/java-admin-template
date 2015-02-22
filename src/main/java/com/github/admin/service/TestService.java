package com.github.admin.service;

import com.github.admin.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author changjiang.tang Date:2/21/15 Time:9:25 PM
 */
@Service
public class TestService {

    @Resource
    TestDao testDao;

    public boolean delete(String key) {
        return testDao.delete(key) == 1;
    }

}
