package org.example;

import org.example.models.History;
import org.example.models.Processors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/processors/CPUprcrProcessorTimePercent")
public class Controller {
    private final RestTemplate restTemplate;

    @Autowired
    public Controller (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/max")
    public void getMaxValue (@RequestParam("history") int history) {

    }

    @GetMapping("/min")
    public void getMinValue (@RequestParam("history") int history) {

    }

    @GetMapping("/avg")
    public void getAvgValue (@RequestParam("history") int history) {

    }

    /**
     * Retrieve processors data.
     * @return A Processors object.
     */
    public Processors getProcessors() {
        return restTemplate.getForObject("https://xdemo.sentrysoftware.com/rest/namespace/NT_CPU", Processors.class);
    }

    /**
     * Retrieve history values for a given processor.
     * @param id Processor's id.
     * @param history Number of history values requested.
     * @return A History object.
     */
    public History getHistoryValues(String id, int history) {
        History hist = restTemplate.getForObject("https://xdemo.sentrysoftware.com/rest/console/NT_CPU/" + id + "/CPUprcrProcessorTimePercent?max=" + history, History.class);
        hist.setId(id);
        return hist;
    }
}