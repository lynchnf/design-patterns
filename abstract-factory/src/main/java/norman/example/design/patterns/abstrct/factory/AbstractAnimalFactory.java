package norman.example.design.patterns.abstrct.factory;

import norman.example.design.patterns.abstrct.factory.animal.Animal;

public interface AbstractAnimalFactory<T extends Animal> {
    T create(String animalType);
}
