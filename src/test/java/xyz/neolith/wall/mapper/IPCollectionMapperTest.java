package xyz.neolith.wall.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sunlggggg
 * @date 2018/3/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IPCollectionMapperTest {

    @Autowired
    private IPCollectionMapper ipCollectionMapper;

    @Test
    public void list() {
        System.out.println(ipCollectionMapper.list(2).size());
    }
}