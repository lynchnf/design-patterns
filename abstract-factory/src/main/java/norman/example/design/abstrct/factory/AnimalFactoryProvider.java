package norman.example.design.abstrct.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalFactoryProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalFactoryProvider.class);

    public static AbstractAnimalFactory getFactory(String factoryType) {
        LOGGER.debug("Create animal factory with type: " + factoryType + ".");
        if (factoryType.equalsIgnoreCase("mammal")) {
            return new MammalFactory();
        } else if (factoryType.equalsIgnoreCase("bird")) {
            return new BirdFactory();
        } else {
            return null;
        }
    }
}
