package org.example;

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
}