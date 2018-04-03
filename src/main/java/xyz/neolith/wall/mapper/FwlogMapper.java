package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.neolith.wall.domain.Fwlog;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
@Mapper
public interface FwlogMapper {
    @Select("SELECT * FROM fwlog WHERE id = #{id};")
    Fwlog findById(Long id);
}
