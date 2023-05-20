package norman.example.design.patterns.abstrct.factory.animal;

public class Turkey implements Bird {
    @Override
    public String makeSound() {
        return "gobble";
    }

    @Override
    public String flys() {
        return "As God as my witness, I thought turkeys could fly.";
    }
}
