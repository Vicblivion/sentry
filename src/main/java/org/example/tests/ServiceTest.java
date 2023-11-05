package org.example.tests;

import org.example.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private Service service;

    private List<String> subnodes = new ArrayList<>(Arrays.asList("CPU_0", "CPU_1"));

    /**
     * Check if historyValues are retrieved correctly.
     */
    @Test
    public void testGetHistories() {
        assertNotNull(service.getHistories(subnodes, 10));
    }
}
