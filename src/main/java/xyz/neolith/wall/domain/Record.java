package xyz.neolith.wall.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sunlggggg
 * @date 2018/3/29
 */
public class Record implements Serializable {


    private Long userId;

    private String title;


    private Date createTime;

    private Long id;

    private String recordInfo;

    public Record() {}

    public Record(Date createTime, String title, String recordInfo, Long userId) {
        this.title = title;
        this.createTime = createTime;
        this.recordInfo = recordInfo;
        this.userId = userId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(String recordInfo) {
        this.recordInfo = recordInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
