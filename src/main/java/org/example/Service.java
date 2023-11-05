package org.example;

import org.example.models.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@org.springframework.stereotype.Service
public class Service {
    private final Controller controller;

    @Autowired
    public Service(Controller controller) {
        this.controller = controller;
    }

    /**
     * Retrieve history for all processors.
     * @param subnodes All processors' id.
     * @param history Number of HistoryValue to retrieve.
     * @return List of histories.
     */
    public List<History> getHistories(List<String> subnodes, int history) {
        List<History> histories = new ArrayList<>();
        for (String id : subnodes) {
            try {
                histories.add(getHistoryValues(id, history).get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        return histories;
    }

    /**
     * Retrieve history asynchronously.
     * @param id Processors's id.
     * @param history Number of HistoryValue to retrieve.
     * @return A History Object.
     */
    @Async
    public CompletableFuture<History> getHistoryValues(String id, int history) {
        return CompletableFuture.completedFuture(controller.getHistoryValues(id, history));
    }
}
