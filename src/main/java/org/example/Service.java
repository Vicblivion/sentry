package org.example;

import org.example.models.History;
import org.example.models.Processors;
import org.example.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@org.springframework.stereotype.Service
public class Service {
    private final RestTemplate restTemplate;

    @Autowired
    public Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Get max value for each processor.
     * @param history Number of HistoryValue.
     */
    public List<Response> getMaxValue(int history) {
        List<Response> responses = new ArrayList<>();
        Processors processors = getProcessors();
        List<History> histories = getHistories(processors.getSubnodes(), history);
        for (History hist : histories) {
            responses.add(new Response(hist.getId(), hist.getMaxValue()));
        }
        Collections.sort(responses, Comparator.comparing(Response::getValue));
        Collections.reverse(responses);
        return responses;
    }

    /**
     * Get min value for each processor.
     * @param history Number of HistoryValue.
     */
    public List<Response> getMinValue(int history) {
        List<Response> responses = new ArrayList<>();
        Processors processors = getProcessors();
        List<History> histories = getHistories(processors.getSubnodes(), history);
        for (History hist : histories) {
            responses.add(new Response(hist.getId(), hist.getMinValue()));
        }
        Collections.sort(responses, Comparator.comparing(Response::getValue));
        Collections.reverse(responses);
        return responses;
    }

    /**
     * Get max value for each processor.
     * @param history Number of HistoryValue.
     */
    public List<Response> getAvgValue(int history) {
        List<Response> responses = new ArrayList<>();
        Processors processors = getProcessors();
        List<History> histories = getHistories(processors.getSubnodes(), history);
        for (History hist : histories) {
            responses.add(new Response(hist.getId(), hist.getAvgValue()));
        }
        Collections.sort(responses, Comparator.comparing(Response::getValue));
        Collections.reverse(responses);
        return responses;
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
        History hist = restTemplate.getForObject("https://xdemo.sentrysoftware.com/rest/console/NT_CPU/" + id + "/CPUprcrProcessorTimePercent?max=" + history, History.class);
        hist.setId(id);
        return CompletableFuture.completedFuture(hist);
    }

    /**
     * Retrieve processors data.
     * @return A Processors object.
     */
    public Processors getProcessors() {
        return restTemplate.getForObject("https://xdemo.sentrysoftware.com/rest/namespace/NT_CPU", Processors.class);
    }
}
