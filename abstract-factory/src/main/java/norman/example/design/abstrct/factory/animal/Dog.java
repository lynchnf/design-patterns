package norman.example.design.abstrct.factory.animal;

public class Dog implements Mammal {
    @Override
    public String makeSound() {
        return "bark";
    }

    @Override
    public String runs() {
        return "runs like a dog";
    }
}
