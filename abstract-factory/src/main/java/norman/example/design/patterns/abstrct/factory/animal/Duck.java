package norman.example.design.patterns.abstrct.factory.animal;

public class Duck implements Bird {
    @Override
    public String makeSound() {
        return "quack";
    }

    @Override
    public String flys() {
        return "flys like a duck";
    }
}
