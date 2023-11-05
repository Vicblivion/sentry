package org.example.models;

import java.util.List;

public class History {
    private String id;
    private float value;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Put the max value into value.
     */
    public void setMaxValue() {
        float max = 0;
        for (HistoryValue h : this.history) {
            if (h.getValue() > max) {
                max = h.getValue();
            }
        }
        this.value = max;
    }

    /**
     * Put the min value into value.
     */
    public void setMinValue() {
        float min = Float.MAX_VALUE;
        for (HistoryValue h : this.history) {
            if (h.getValue() < min) {
                min = h.getValue();
            }
        }
        this.value = min;
    }

    /**
     * Put the average value into value.
     */
    public void setAvgValue() {
        float avg = 0;
        for (HistoryValue h : this.history) {
            avg += h.getValue();
        }
        this.value = avg/this.history.size();
    }
}
