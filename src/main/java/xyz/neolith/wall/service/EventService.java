package xyz.neolith.wall.service;

import xyz.neolith.wall.domain.Event;
import xyz.neolith.wall.domain.Fwlog;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
public interface EventService {
    List<Fwlog> allFwlogsInOneEvent(Long eventId);
    List<Event> list(Integer pageNum, Integer itemNum);
}
