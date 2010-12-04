package org.rsimulator.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.rsimulator.core.config.CoreModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Test1.
 * 
 * @author Magnus Bjuvensjö
 */
public class Test1 {
    private Simulator simulator;

    @Before
    public void init() {
        Injector injector = Guice.createInjector(new CoreModule());
        simulator = injector.getInstance(Simulator.class);
    }

    @Test
    public void test() {
        String rootPath = getClass().getResource("/").getPath();
        String rootRelativePath = ".";
        String request = "Hello Simulator, says Test1!";
        String contentType = "txt";
        try {
            SimulatorResponse simulatorResponse = simulator.service(rootPath, rootRelativePath, request, contentType);
            assertEquals("Hello Test1, says Simulator!", simulatorResponse.getResponse());

            // to test cache
            simulatorResponse = simulator.service(rootPath, rootRelativePath, request, contentType);
            assertEquals("Hello Test1, says Simulator!", simulatorResponse.getResponse());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
