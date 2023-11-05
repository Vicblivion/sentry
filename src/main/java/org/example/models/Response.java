package org.example.models;

public class Response {
    private String name;
    private float value;

    public Response(String id, float value) {
        this.name = id;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
