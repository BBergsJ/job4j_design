package ru.job4j.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jException {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4jException.class.getName());

    public static void main(String[] args) {
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}