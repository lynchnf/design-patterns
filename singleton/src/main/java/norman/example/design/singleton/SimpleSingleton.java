package norman.example.design.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SimpleSingleton {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSingleton.class);
    private static SimpleSingleton INSTANCE;

    private SimpleSingleton() {
        LOGGER.debug("SimpleSingleton constructor.");
		
        // Make it slow to create.
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something bad happened.", e);
        }
    }

    public static SimpleSingleton getInstance() {
        if (INSTANCE == null) {
            LOGGER.debug("Creating a new SimpleSingleton.");
            INSTANCE = new SimpleSingleton();
        }
        return INSTANCE;
    }
}
