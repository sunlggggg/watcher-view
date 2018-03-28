package xyz.neolith.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.neolith.wall.constants.StatisticsType;
import xyz.neolith.wall.domain.StatisticsResult;
import xyz.neolith.wall.mapper.StatisticsResultMapper;
import xyz.neolith.wall.service.StatisticsResultService;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/27
 */
@Service("statisticsResultService")
public class StatisticsResultServiceImpl implements StatisticsResultService {

    @Autowired
    private StatisticsResultMapper statisticsResultMapper;

    @Override
    public List<StatisticsResult> list(StatisticsType type, Integer size) {

        return statisticsResultMapper.list(statisticsResultMapper.getLast().getEndTime(), type ,size);
    }
}
