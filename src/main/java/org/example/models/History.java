package org.example.models;

import java.util.List;

public class History {
    private String id;
    private List<HistoryValue> history;

    public List<HistoryValue> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryValue> history) {
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
