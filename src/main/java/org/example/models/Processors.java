package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Processors {
    private List<String> subnodes = new ArrayList<>();

    public List<String> getSubnodes() {
        return subnodes;
    }

    public void setSubnodes(String[] subnodes) {
        for (String subnode : subnodes) {
            if (!subnode.equals("CPU__Total")) {
                this.subnodes.add(subnode);
            }
        }
    }
}
