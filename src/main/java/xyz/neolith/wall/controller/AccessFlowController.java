package xyz.neolith.wall.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.neolith.wall.service.AccessFlowResultService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunlggggg
 * @date 2018/3/25
 */
@RestController
@RequestMapping("/api")
public class AccessFlowController {
    private static Gson gson = new Gson();


    private final AccessFlowResultService accessFlowResultService;

    @Autowired
    public AccessFlowController(AccessFlowResultService accessFlowResultService) {
        this.accessFlowResultService = accessFlowResultService;
    }

    /**
     * 返回60个整数
     *
     * @return {activeData:[]}
     */
    @RequestMapping(value = "/accessFlow")
    public String accessFlow() {
        Map map = new HashMap<>();
        List lastData = accessFlowResultService.list(60);
        for (int i = lastData.size(); i < 60; i++) {
            lastData.add(0);
        }
        map.put("activeData", lastData);
        return gson.toJson(map);
    }

}