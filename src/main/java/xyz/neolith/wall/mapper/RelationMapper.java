package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
@Mapper
public interface RelationMapper {
    @Select("SELECT fwlogId FROM relation WHERE eventId = #{eventId}; ")
    List<Long> allFwlogIds(Long eventId);
}
