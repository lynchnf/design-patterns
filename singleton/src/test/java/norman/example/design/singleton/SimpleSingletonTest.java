package norman.example.design.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SimpleSingletonTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSingletonTest.class);
    private static final int NUMBER_OF_INSTANCES = 100;
    private static final int POOL_SIZE = 10;
    ExecutorService executorService;

    @BeforeEach
    void setUp() {
        executorService = Executors.newFixedThreadPool(POOL_SIZE);
    }

    @Test
    void getInstance() throws Exception {
        // Generate a bunch of potential singletons.
        List<Future<SimpleSingleton>> futures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_INSTANCES; i++) {
            Future<SimpleSingleton> future = executorService.submit(SimpleSingleton::getInstance);
            futures.add(future);
        }

        // Resolve our potential singletons into actual singletons.
        List<SimpleSingleton> singletons = new ArrayList<>();
        for (Future<SimpleSingleton> future : futures) {
            SimpleSingleton singleton = future.get();
            singletons.add(singleton);
        }

        // Are all our "singletons" the same object?
        SimpleSingleton firstSingleton = null;
        boolean allGood = true;
        for (SimpleSingleton singleton : singletons) {
            if (firstSingleton == null) {
                firstSingleton = singleton;
            } else {
                if (firstSingleton != singleton) {
                    LOGGER.debug(
                            "SimpleSingletons " + firstSingleton + " and " + singleton + " are not the same object.");
                    allGood = false;
                }
            }
        }

        // We expect this to fail.
        assertFalse(allGood);
    }
}
