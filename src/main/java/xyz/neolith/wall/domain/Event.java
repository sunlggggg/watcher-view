package xyz.neolith.wall.domain;



import xyz.neolith.wall.constants.EventType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * @author sunlggggg
 * @date 2017/1/12
 */
public class Event {

    private Long id;

    private Date startTime;

    private Date lastTime;

    private Boolean isFinished;

    private EventType attackType;

    private Set<Fwlog> fwlogs = new HashSet<>();


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }


    public EventType getAttackType() {
        return attackType;
    }

    public void setAttackType(EventType attackType) {
        this.attackType = attackType;
    }


    public Set<Fwlog> getFwlogs() {
        return fwlogs;
    }

    public void setFwlogs(Set<Fwlog> fwlogs) {
        this.fwlogs = fwlogs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (startTime != null ? !startTime.equals(event.startTime) : event.startTime != null) return false;
        if (lastTime != null ? !lastTime.equals(event.lastTime) : event.lastTime != null) return false;
        if (isFinished != null ? !isFinished.equals(event.isFinished) : event.isFinished != null) return false;
        if (attackType != null ? !attackType.equals(event.attackType) : event.attackType != null) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startTime.hashCode();
        result = 31 * result + lastTime.hashCode();
        result = 31 * result + isFinished.hashCode();
        result = 31 * result + attackType.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + fwlogs.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", lastTime=" + lastTime +
                ", isFinished=" + isFinished +
                ", attackType=" + attackType +
                ", fwlogs=" + fwlogs +
                '}';
    }
}
