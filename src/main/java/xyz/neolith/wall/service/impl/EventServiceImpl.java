package xyz.neolith.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.neolith.wall.domain.Event;
import xyz.neolith.wall.domain.Fwlog;
import xyz.neolith.wall.mapper.EventMapper;
import xyz.neolith.wall.mapper.FwlogMapper;
import xyz.neolith.wall.mapper.RelationMapper;
import xyz.neolith.wall.service.EventService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
@Service("eventService")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private FwlogMapper fwlogMapper;

    @Autowired
    private RelationMapper relationMapper;

    @Transactional
    @Override
    public List<Fwlog> allFwlogsInOneEvent(Long eventId) {
        List<Long> allFwlogIdsInOneEvent = relationMapper.allFwlogIds(eventId);
        List<Fwlog> allFwlogsInOneEvent = new ArrayList<>();
        for(Long ids:allFwlogIdsInOneEvent){
            allFwlogsInOneEvent.add(fwlogMapper.findById(ids));
        }
        return allFwlogsInOneEvent;
    }

    @Override
    public List<Event> list(Integer pageNum, Integer itemNum) {
        int startId = itemNum*(pageNum - 1);//该页开始ID
        return eventMapper.list(startId,itemNum);
    }
}
