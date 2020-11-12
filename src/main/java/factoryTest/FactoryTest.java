package factoryTest;

public class FactoryTest {
    public static void main(String[] args) {

        // create a new Car Factory
        CarFactory carFactory = new CarFactory();

        // create a specific car object using car factory based on string given
        Drivable fiat = carFactory.getCar("Fiat");
        fiat.drive();

        Drivable porsche = carFactory.getCar("Porsche");
        porsche.drive();

        Drivable bmw = carFactory.getCar("BMW");
        bmw.drive();



    }
}
