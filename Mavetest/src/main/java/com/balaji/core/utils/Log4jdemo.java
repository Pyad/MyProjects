package com.balaji.core.utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4jdemo {

	public static void main(String[] args) {
		
//		BasicConfigurator.configure();
		final Logger log = LogManager.getLogger(Log4jdemo.class);

        System.err.println("Initialisied Logger");
        log.trace("TRACE");
        log.debug("DEBUG");
        log.info("INFO");
        log.warn("WARN");
        log.error("ERROR");
        log.fatal("FATAL");

        System.err.println("END");

	}

}
