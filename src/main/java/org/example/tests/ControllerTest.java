package org.example.tests;

import org.example.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private Controller controller;

    private String[] subnodes = new String[] {"CPU_0", "CPU_1", "CPU__Total"};

    @Test
    public void testGetProcessors() {
        assertTrue(Arrays.equals(subnodes, controller.getProcessors().getSubnodes()));
    }
}
