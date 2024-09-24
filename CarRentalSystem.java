import java.util.ArrayList;
import java.util.HashMap;

class CarRentalSystem {
    private ArrayList<Car> cars;
    private HashMap<String, Car> rentedCars;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        rentedCars = new HashMap<>();
        initializeCars();
    }

    private void initializeCars() {
        cars.add(new Car("C001", "Toyota Corolla"));
        cars.add(new Car("C002", "Honda Civic"));
        cars.add(new Car("C003", "Ford Focus"));
        cars.add(new Car("C004", "Chevrolet Malibu"));
        cars.add(new Car("C005", "Nissan Altima"));
        cars.add(new Car("C006", "Hyundai Elantra"));
    }

    public void viewAvailableCars() {
        System.out.println("Available Cars:");
        int availableCount = 0;
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.println("Car ID: " + car.getCarId() + ", Model: " + car.getModel() + " (Available)");
                availableCount++;
            }
        }
        System.out.println("Total Available Cars: " + availableCount);
    }

    public void rentCar(String carId, int rentalDays) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isRented()) {
                car.setRented(true);
                rentedCars.put(carId, car);
                double cost = rentalDays * 50; // Example cost calculation
                System.out.println("Car rented successfully: " + car.getModel());
                System.out.println("Total cost for " + rentalDays + " days: $" + cost);
                return;
            }
        }
        System.out.println("Error: Car is already rented or invalid car ID.");
    }

    public void returnCar(String carId) {
        Car car = rentedCars.get(carId);
        if (car != null) {
            car.setRented(false);
            rentedCars.remove(carId);
            System.out.println("Car returned successfully: " + car.getModel());
        } else {
            System.out.println("Error: Invalid car ID or car was not rented.");
        }
    }

    public void listRentedCars() {
        System.out.println("Rented Cars:");
        if (rentedCars.isEmpty()) {
            System.out.println("No cars are currently rented.");
        } else {
            for (Car car : rentedCars.values()) {
                System.out.println("Car ID: " + car.getCarId() + ", Model: " + car.getModel());
            }
        }
    }

    public void resetSystem() {
        for (Car car : cars) {
            car.setRented(false);
        }
        rentedCars.clear();
        System.out.println("System has been reset. All cars are now available.");
    }

    public boolean validateRentalDays(int rentalDays) {
        return rentalDays > 0;
    }

    public void searchByModel(String model) {
        boolean found = false;
        System.out.println("Search Results for model: " + model);
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && !car.isRented()) {
                System.out.println("Car ID: " + car.getCarId() + ", Model: " + car.getModel() + " (Available)");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available cars found for the model: " + model);
        }
    }
}
