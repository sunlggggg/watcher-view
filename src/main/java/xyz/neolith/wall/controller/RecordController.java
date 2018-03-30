package xyz.neolith.wall.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.neolith.wall.domain.Record;
import xyz.neolith.wall.service.RecordService;

import java.util.*;

/**
 * @author sunlggggg
 * @date 2018/3/29
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    private static Gson gson = new Gson();

    @GetMapping(value = "/list/{pagenum}&{itemnum}" )
    public String listByPage(@PathVariable(value = "pagenum") Integer pageNum, @PathVariable(value = "itemnum") Integer onePageItemNum){
        Map res = new HashMap();
        res.put("pageInfo",recordService.list(pageNum,onePageItemNum));
        return gson.toJson(res);
    }

    @PostMapping(value = "/" )
    public String postRecord( @RequestBody Map<String,String> map  ) {
        //TODO 权限控制
        recordService.save(new Record(new Date(), map.get("title"), map.get("recordInfo"),0L));
        return "success";
    }

    @PostMapping(value = "/update" )
    public String updateRecord( @RequestBody Map<String,String> map  ) {
        //TODO 权限控制
        recordService.save(new Record(new Date(), map.get("title"), map.get("recordInfo"),0L));
        return "success";
    }



}
