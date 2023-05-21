package norman.example.design.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterSingleton {
    private static final Logger LOGGER = LoggerFactory.getLogger(BetterSingleton.class);

    private BetterSingleton() {
        LOGGER.debug("BetterSingleton constructor.");

        // Make it slow to create.
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something bad happened.", e);
        }
    }

    private static class BetterSingletonHolder {
        public static final BetterSingleton instance = new BetterSingleton();
    }

    public static BetterSingleton getInstance() {
        return BetterSingletonHolder.instance;
    }
}
