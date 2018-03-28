package xyz.neolith.wall.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.neolith.wall.constants.StatisticsType;

/**
 * @author sunlggggg
 * @date 2018/3/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsResultMapperTest {

    @Autowired
    StatisticsResultMapper statisticsResultMapper;

    @Test
    public void list() {
        System.out.println(statisticsResultMapper.list(statisticsResultMapper.getLast().getEndTime(), StatisticsType.originalDestIp,10));
        System.out.println(statisticsResultMapper.list(statisticsResultMapper.getLast().getEndTime(), StatisticsType.originalSrcIp,10));
        System.out.println(statisticsResultMapper.list(statisticsResultMapper.getLast().getEndTime(), StatisticsType.originalDestPort,10));
        System.out.println(statisticsResultMapper.list(statisticsResultMapper.getLast().getEndTime(), StatisticsType.originalDestPort,10));
    }

    @Test
    public void getLastTime() {
        System.out.println(statisticsResultMapper.getLast());
    }
}