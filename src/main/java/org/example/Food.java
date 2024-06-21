package org.example;

import java.io.IOException;

public class Food {
    private static Log logger;

    static {
        try {
            logger = new Log("logs/food.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String name;

    public Food(String name) {
        this.name = name;
        logger.logger.info("Creating food with name: " + name);
    }

    public String getName() {
        return name;
    }
}
