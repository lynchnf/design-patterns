package norman.example.design.patterns.abstrct.factory;

import norman.example.design.patterns.abstrct.factory.animal.Cow;
import norman.example.design.patterns.abstrct.factory.animal.Dog;
import norman.example.design.patterns.abstrct.factory.animal.Mammal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MammalFactory implements AbstractAnimalFactory<Mammal> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MammalFactory.class);

    @Override
    public Mammal create(String animalType) {
        LOGGER.debug("Creating a mammal with type: " + animalType + ".");
        if (animalType.equalsIgnoreCase("cow")) {
            return new Cow();
        } else if (animalType.equalsIgnoreCase("dog")) {
            return new Dog();
        } else {
            return null;
        }
    }
}
