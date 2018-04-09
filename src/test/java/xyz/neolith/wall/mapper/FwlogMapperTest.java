package xyz.neolith.wall.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author sunlggggg
 * @date 2018/4/6
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FwlogMapperTest {

    @Autowired
    private FwlogMapper fwlogMapper;
    @Test
    public void findById() {
    }

    @Test
    public void findByTime() throws ParseException {
        //2018-03-27 14:32:45
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date st = df.parse("2018-03-27 14:32:45");
        Date et = df.parse("2018-03-27 14:33:55");
        fwlogMapper.findByTime(st,et);
    }
}