package org.rsimulator.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.rsimulator.core.config.DIModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Test4.
 *
 * @author Magnus Bjuvensjö
 */
public class Test4 {
    private Simulator simulator;

    @Before
    public void init() {
        Injector injector = Guice.createInjector(new DIModule());
        simulator = injector.getInstance(Simulator.class);
    }

    @Test
    public void test() {
        String rootPath = getClass().getResource("/test4").getPath();
        String rootRelativePath = ".";
        String request = "Hello Simulator, says Test4!";
        String contentType = "txt";
        try {
            SimulatorResponse simulatorResponse = simulator
                    .service(rootPath, rootRelativePath, request, contentType);
            simulator.service(rootPath, rootRelativePath, request, contentType);
            assertEquals("Hello Test4, says GlobalRequest.groovy!", simulatorResponse.getResponse());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
