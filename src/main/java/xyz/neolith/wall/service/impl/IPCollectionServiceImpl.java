package xyz.neolith.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.neolith.wall.domain.IPCollection;
import xyz.neolith.wall.mapper.IPCollectionMapper;
import xyz.neolith.wall.service.IPCollectionService;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
@Service("iPCollectionService")
public class IPCollectionServiceImpl implements IPCollectionService {
    @Autowired
    private IPCollectionMapper ipCollectionMapper ;

    @Override
    public List<IPCollection> list(Integer pageNum, Integer itemNum) {
        int startId = itemNum*(pageNum - 1);//该页开始ID
        return ipCollectionMapper.list(startId,itemNum);
    }
}
