package org.example.tests;

import org.example.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private Controller controller;

    private List<String> subnodes = new ArrayList<>(Arrays.asList("CPU_0", "CPU_1"));

    /**
     * Check if processors are retrieved correctly. Only processors IDs are checked currently.
     */
    @Test
    public void testGetProcessors() {
        assertTrue(subnodes.equals(controller.getProcessors().getSubnodes()));
    }

    /**
     * Check if historyValues are retrieved correctly.
     */
    @Test
    public void testGetHistoryValues() {
        assertNotNull(controller.getHistoryValues("CPU_0", 10));
        assertNotNull(controller.getHistoryValues("CPU_1", 10));
    }
}
