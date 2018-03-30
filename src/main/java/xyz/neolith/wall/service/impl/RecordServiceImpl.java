package xyz.neolith.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.neolith.wall.domain.Record;
import xyz.neolith.wall.mapper.RecordMapper;
import xyz.neolith.wall.service.RecordService;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/29
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;
    //添加事务
    @Override
    @Transactional
    public List<Record> list(Integer pageNum, Integer itemNum) {
        int start = itemNum*(pageNum - 1);
        return recordMapper.list(start, itemNum);
    }

    @Override
    public int update(Record record) {
        return recordMapper.update(record);
    }

    @Override
    public int save(Record record) {
        return recordMapper.save(record.getCreateTime(),record.getTitle(), record.getRecordInfo(),record.getUserId());
    }
}
