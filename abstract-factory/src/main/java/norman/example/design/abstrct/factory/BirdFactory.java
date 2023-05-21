package norman.example.design.abstrct.factory;

import norman.example.design.abstrct.factory.animal.Bird;
import norman.example.design.abstrct.factory.animal.Duck;
import norman.example.design.abstrct.factory.animal.Turkey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BirdFactory implements AbstractAnimalFactory<Bird> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BirdFactory.class);

    @Override
    public Bird create(String animalType) {
        LOGGER.debug("Create bird with type: " + animalType + ".");
        if (animalType.equalsIgnoreCase("duck")) {
            return new Duck();
        } else if (animalType.equalsIgnoreCase("chicken")) {
            return new Turkey();
        } else {
            return null;
        }
    }
}
