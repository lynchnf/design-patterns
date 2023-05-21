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

import static org.junit.jupiter.api.Assertions.assertTrue;

class BetterSingletonTest {
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
        List<Future<BetterSingleton>> futures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_INSTANCES; i++) {
            Future<BetterSingleton> future = executorService.submit(BetterSingleton::getInstance);
            futures.add(future);
        }

        // Resolve our potential singletons into actual singletons.
        List<BetterSingleton> singletons = new ArrayList<>();
        for (Future<BetterSingleton> future : futures) {
            BetterSingleton singleton = future.get();
            singletons.add(singleton);
        }

        // Are all our "singletons" the same object?
        BetterSingleton firstSingleton = null;
        boolean allGood = true;
        for (BetterSingleton singleton : singletons) {
            if (firstSingleton == null) {
                firstSingleton = singleton;
            } else {
                if (firstSingleton != singleton) {
                    LOGGER.debug(
                            "BetterSingletons " + firstSingleton + " and " + singleton + " are not the same object.");
                    allGood = false;
                }
            }
        }

        // We expect this to succeed.
        assertTrue(allGood);
    }
}
