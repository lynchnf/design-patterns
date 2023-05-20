package norman.example.design.patterns.abstrct.factory.animal;

public class Cow implements Mammal {
    @Override
    public String makeSound() {
        return "moo";
    }

    @Override
    public String runs() {
        return "runs like a cow";
    }
}
