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
    public float getMaxValue() {
        float max = 0;
        for (HistoryValue h : this.history) {
            if (h.getValue() > max) {
                max = h.getValue();
            }
        }
        return max;
    }

    /**
     * Put the min value into value.
     */
    public float getMinValue() {
        float min = Float.MAX_VALUE;
        for (HistoryValue h : this.history) {
            if (h.getValue() < min) {
                min = h.getValue();
            }
        }
        return min;
    }

    /**
     * Put the average value into value.
     */
    public float getAvgValue() {
        float avg = 0;
        for (HistoryValue h : this.history) {
            avg += h.getValue();
        }
        return avg/this.history.size();
    }
}
