package xyz.neolith.wall.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.neolith.wall.service.EventService;
import xyz.neolith.wall.service.IPCollectionService;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
@RestController
@RequestMapping("/event")
public class EventController {

    private Gson gson = new Gson();

    @Autowired
    private EventService eventService;

    @GetMapping("/list/{pageNum}&{itemNum}")
    public String getIPCollection(@PathVariable Integer pageNum, @PathVariable Integer itemNum ){
        return gson.toJson(eventService.list(pageNum,itemNum));
    }

    @GetMapping("/list/allFwlogs/{eventId}")
    public String getAllFwlogsInOneEvent(@PathVariable Long eventId ){
        return gson.toJson(eventService.allFwlogsInOneEvent(eventId));
    }
}
