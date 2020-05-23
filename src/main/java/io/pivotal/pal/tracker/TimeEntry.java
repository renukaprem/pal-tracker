package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    Long id ;
    Long projectId;
    long userId;
    LocalDate localDate;
    int hours;

    public TimeEntry(Long projectId, long userId, LocalDate localDate, int hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.localDate = localDate;
        this.hours = hours;
    }

    public TimeEntry(Long id, Long projectId, long userId, LocalDate localDate, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.localDate = localDate;
        this.hours = hours;
    }

    public TimeEntry() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return localDate;
    }

    public void setDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours  ) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntry)) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return getUserId() == timeEntry.getUserId() &&
                getHours() == timeEntry.getHours() &&
                Objects.equals(getId(), timeEntry.getId()) &&
                Objects.equals(getProjectId(), timeEntry.getProjectId()) &&
                Objects.equals(getDate(), timeEntry.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectId(), getUserId(), getDate(), getHours());
    }
}
