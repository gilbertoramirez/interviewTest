package com.solutions.coherent.interviewTest.configuration;

import com.solutions.coherent.interviewTest.util.DbMemoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

public class ShutdownHook implements SmartLifecycle {

    @Autowired
    public static DBMemory dbMemory;
    private volatile boolean running = false;

    @Override
    public void start() {
        DbMemoryUtil.getRecords(dbMemory);
        running = true;
    }

    @Override
    public void stop() {
        finalization();
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public void finalization() {
        System.out.println("Finalizado");
        DbMemoryUtil.setRecords();
    }
}