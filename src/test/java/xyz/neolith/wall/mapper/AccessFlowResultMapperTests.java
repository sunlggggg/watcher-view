package xyz.neolith.wall.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xyz.neolith.wall.domain.User;

/**
 * @author sunlggggg
 * @date 2018/3/26
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessFlowResultMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccessFlowResultMapper accessFlowResultMapper;

    @Test
    public void listFindByLength() {
        System.out.println(accessFlowResultMapper.list(60).size());
    }

    @Test
    public void testInset() {
        userMapper.insert("winterchen", "123456", "12345678910");
        User u = userMapper.findUserByEmail("12345678910");
        Assert.assertEquals("winterchen", u.getName());
    }

    @Test
    @Transactional
    public void testTransactional(){
        userMapper.insert("张三", "123456", "18600000000");
        int a = 1/0;
        userMapper.insert("李四", "123456", "13500000000");
        User u = userMapper.findUserByEmail("12345678910");
        Assert.assertEquals("winterchen", u.getName());
    }

}
