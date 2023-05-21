package norman.example.design.abstrct.factory;

import norman.example.design.abstrct.factory.animal.Animal;

public interface AbstractAnimalFactory<T extends Animal> {
    T create(String animalType);
}
