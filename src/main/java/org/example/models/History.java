package org.example.models;

import java.util.List;

public class History {
    private String id;
    private List<HistoryValues> history;

    public List<HistoryValues> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryValues> history) {
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
