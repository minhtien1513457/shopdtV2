package com.example.shopdt.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManagerGatewayLogger {
    public static Logger json = LogManager.getLogger("JSON");
    public static Logger client = LogManager.getLogger("CLIENT");
    public static Logger machine = LogManager.getLogger("MACHINE");
    public static Logger endpoint = LogManager.getLogger("ENDPOINT");
    public static Logger info = LogManager.getLogger("INFO");
    public static Logger error = LogManager.getLogger("ERROR");
    public static Logger detailClient = LogManager.getLogger("DETAIL_CLIENT");
}
