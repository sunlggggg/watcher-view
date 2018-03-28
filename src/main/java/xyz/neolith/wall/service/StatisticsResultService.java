package xyz.neolith.wall.service;

import xyz.neolith.wall.constants.StatisticsType;
import xyz.neolith.wall.domain.StatisticsResult;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/27
 */
public interface StatisticsResultService {
    List<StatisticsResult> list(StatisticsType type , Integer size );
}
