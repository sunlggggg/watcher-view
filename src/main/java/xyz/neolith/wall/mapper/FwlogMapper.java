package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.neolith.wall.domain.Fwlog;

import java.util.Date;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
@Mapper
public interface FwlogMapper {
    @Select("SELECT * FROM fwlog WHERE id = #{id};")
    Fwlog findById(Long id);

    @Select("SELECT DISTINCT originalSrcIp FROM fwlog WHERE timestamp >= #{startTime} and timestamp <= #{endTime} ;")
    List<String> findByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime );
}
