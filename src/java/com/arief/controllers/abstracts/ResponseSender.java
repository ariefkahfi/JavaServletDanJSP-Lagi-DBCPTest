/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arief.controllers.abstracts;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arief
 */
public interface ResponseSender {
    //public void sendResponse(HttpServletResponse response) throws IOException;
    public void sendErrorResponseForSqlError(HttpServletResponse response , String shortMessage) throws IOException;
    public void sendResponseWithData(HttpServletResponse response , Object data) throws IOException;
}
