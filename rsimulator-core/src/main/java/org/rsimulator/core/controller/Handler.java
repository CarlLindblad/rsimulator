package org.rsimulator.core.controller;

import java.io.IOException;

/**
 * Handler.
 *
 * @author Magnus Bjuvensjö
 */
public interface Handler {

    /**
     * Returns a {@link ControllerResponse} for the specified parameters.
     * 
     * @param rootPath the root path
     * @param rootRelativePath the root relative path
     * @param request the request
     * @return a {@link ControllerResponse} for the specified parameters
     * @throws IOException if something goes wrong
     */
    ControllerResponse findMatch(String rootPath, String rootRelativePath, String request) throws IOException;
}
