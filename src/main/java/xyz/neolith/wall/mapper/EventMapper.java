package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.neolith.wall.domain.Event;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
@Mapper
public interface EventMapper {
    @Select("select * from event ORDER BY startTime DESC LIMIT #{fromId}, #{itemNum}; ")
    List<Event> list(@Param("fromId") Integer fromId , @Param("itemNum") Integer itemNum);
}
