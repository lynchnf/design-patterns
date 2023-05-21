package norman.example.design.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.function.Consumer;

public class IteratorService<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(IteratorService.class);

    public int iterateAndDoSomething(Iterator<T> iterator, Consumer<T> consumer) {
        int count = 0;
        while (iterator.hasNext()) {
            T next = iterator.next();
            LOGGER.debug("Doing the thing to object \"" + next + "\" of type " + next.getClass().getName() + ".");
            consumer.accept(next);
            count++;
        }
        return count;
    }
}
