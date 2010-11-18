package org.rsimulator.core.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.rsimulator.core.config.DIModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Test3.
 * 
 * @author Magnus Bjuvensjö
 */
public class Test3 {
    private Controller controller;

    @Before
    public void init() {
        Injector injector = Guice.createInjector(new DIModule());
        controller = injector.getInstance(Controller.class);
    }

    @Test
    public void test() {
        String rootPath = "src/test/resources";
        String rootRelativePath = "";
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "xmlns:hel=\"http://www.rsimulator.org/SayHello/\"><soapenv:Header/><soapenv:Body>"
                + "<hel:SayHelloRequest><from>Test3</from><to>Controller</to><greeting>Hello</greeting>"
                + "</hel:SayHelloRequest></soapenv:Body></soapenv:Envelope>";
        String contentType = "xml";
        try {
            ControllerResponse controllerResponse = controller
                    .service(rootPath, rootRelativePath, request, contentType);
            controller.service(rootPath, rootRelativePath, request, contentType);
            assertNotNull(controllerResponse);
            assertNotNull(controllerResponse.getResponse());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
