package org.example;

import java.io.IOException;
import java.util.Random;

public class Prisoner extends Person {
    private static Log logger;

    static {
        try {
            logger = new Log("logs/prisoner.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int id;

    public Prisoner(String name) {
        super(name);
        this.id = generateId();
        logger.logger.info("Creating prisoner with name: " + name);
        logger.logger.warning("Prisoner created with ID: " + id);
    }

    public int getId() {
        return id;
    }

    private int generateId() {
        return new Random().nextInt(1000);
    }
}
