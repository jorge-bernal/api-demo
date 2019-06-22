package me.jorgebernal.api_demo.documents;

import java.time.LocalDateTime;
import java.util.List;

public class Event {

    private final String id;

    private LocalDateTime localDateTime;

    private List<Author> authorList;

    private Boolean underage;

    private Boolean isBuild = false;

    public Event(String id) {
        this.id = id;
    }

    public Event(String id, LocalDateTime localDateTime, List<Author> authorList, Boolean underage) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.authorList = authorList;
        this.underage = underage;
        this.isBuild = true;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Boolean getUnderage() {
        return underage;
    }

    public void setUnderage(Boolean underage) {
        this.underage = underage;
    }

    public Boolean getBuild() {
        return isBuild;
    }

    public void setBuild(Boolean build) {
        isBuild = build;
    }
}
