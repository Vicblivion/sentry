package org.example;

import org.example.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/processors/CPUprcrProcessorTimePercent")
public class Controller {
    private final RestTemplate restTemplate;
    private final Service service;

    @Autowired
    public Controller (RestTemplate restTemplate, Service service) {
        this.restTemplate = restTemplate;
        this.service = service;
    }

    /**
     * Get max value for each processor.
     * @param history Number HistoryValue needed.
     * @return ResponseEntity with max value for each processor.
     */
    @GetMapping("/max")
    public ResponseEntity<List<Response>> getMaxValue (@RequestParam("history") int history) {
        return new ResponseEntity<>(service.getMaxValue(history), HttpStatus.OK);
    }

    /**
     * Get min value for each processor.
     * @param history Number HistoryValue needed.
     * @return ResponseEntity with min value for each processor.
     */
    @GetMapping("/min")
    public ResponseEntity<List<Response>> getMinValue (@RequestParam("history") int history) {
        return new ResponseEntity<>(service.getMinValue(history), HttpStatus.OK);
    }

    /**
     * Get average value for each processor.
     * @param history Number HistoryValue needed.
     * @return ResponseEntity with average value for each processor.
     */
    @GetMapping("/avg")
    public ResponseEntity<List<Response>> getAvgValue (@RequestParam("history") int history) {
        return new ResponseEntity<>(service.getAvgValue(history), HttpStatus.OK);
    }
}