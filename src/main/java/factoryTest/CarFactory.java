package factoryTest;

public class CarFactory {

    public Drivable getCar(String car){
        if (car == null) {
            return null;
        }

        // this factory returns a new car object based ion the given string
        switch (car){
            case "Fiat":
                return new Fiat();
            case "BMW":
                return new BMW();
            case "Porsche":
                return new Porsche();
            default:
                try {
                    throw new Exception("Not a valid car name");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
