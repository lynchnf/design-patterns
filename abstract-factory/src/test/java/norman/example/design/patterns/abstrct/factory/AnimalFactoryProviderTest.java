package norman.example.design.patterns.abstrct.factory;

import norman.example.design.patterns.abstrct.factory.animal.Animal;
import norman.example.design.patterns.abstrct.factory.animal.Cow;
import norman.example.design.patterns.abstrct.factory.animal.Duck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalFactoryProviderTest {
    @Test
    void mammals() {
        AbstractAnimalFactory factory = AnimalFactoryProvider.getFactory("mammal");
        assertEquals("MammalFactory", factory.getClass().getSimpleName());
        Animal animal = factory.create("cow");
        assertEquals("moo", animal.makeSound());
        assertEquals("Cow", animal.getClass().getSimpleName());
        Cow cow = (Cow) animal;
        assertEquals("runs like a cow", cow.runs());
    }

    @Test
    void birds() {
        AbstractAnimalFactory factory = AnimalFactoryProvider.getFactory("bird");
        assertEquals("BirdFactory", factory.getClass().getSimpleName());
        Animal animal = factory.create("duck");
        assertEquals("quack", animal.makeSound());
        assertEquals("Duck", animal.getClass().getSimpleName());
        Duck duck = (Duck) animal;
        assertEquals("flys like a duck", duck.flys());
    }
}
