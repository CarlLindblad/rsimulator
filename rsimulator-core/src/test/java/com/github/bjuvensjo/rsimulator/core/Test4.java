package com.github.bjuvensjo.rsimulator.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import com.github.bjuvensjo.rsimulator.core.config.CoreModule;

import static org.junit.Assert.assertEquals;

/**
 * Test4.
 *
 * @author Magnus Bjuvensjö
 */
public class Test4 {
    private Simulator simulator;

    @Before
    public void init() {
        Injector injector = Guice.createInjector(new CoreModule());
        simulator = injector.getInstance(Simulator.class);
    }

    @Test
    public void test() {
        String rootPath = getClass().getResource("/test4").getPath();
        String rootRelativePath = ".";
        String request = "Hello Simulator, says Test4!";
        String contentType = "txt";
        SimulatorResponse simulatorResponse = simulator.service(rootPath, rootRelativePath, request, contentType).get();
        assertEquals("Hello Test4, says GlobalRequest.groovy!", simulatorResponse.getResponse());
    }
}
