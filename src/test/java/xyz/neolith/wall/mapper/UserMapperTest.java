package xyz.neolith.wall.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void findUserByEmail() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void findUserByEmailAndPassword() {
        System.out.println(userMapper.findUserByEmail("1213@qq.com"));
    }
}