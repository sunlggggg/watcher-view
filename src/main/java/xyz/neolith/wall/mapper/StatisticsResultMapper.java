package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.neolith.wall.constants.StatisticsType;
import xyz.neolith.wall.domain.StatisticsResult;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/27
 */
@Mapper
public interface StatisticsResultMapper {
    @Select("select * from StatisticsResult where endTime = #{endTime} and type = #{type} order by count desc limit #{size}")
    List<StatisticsResult> list(@Param("endTime") Date endTime, @Param("type") StatisticsType type , @Param("size") Integer size );

    @Select("select * from StatisticsResult where id = (select MAX(id) from statisticsresult );")
    StatisticsResult getLast();
}
