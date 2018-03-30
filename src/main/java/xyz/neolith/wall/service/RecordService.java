package xyz.neolith.wall.service;

import xyz.neolith.wall.domain.Record;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/29
 */
public interface RecordService {
    int update (Record record ) ;

    int save(Record record);

    List<Record> list(Integer pageNum, Integer itemNum );

}
