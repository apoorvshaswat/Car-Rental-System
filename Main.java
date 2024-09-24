import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        while (true) {
            System.out.println("\nCar Rental System Menu:");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. List Rented Cars");
            System.out.println("5. Search Car by Model");
            System.out.println("6. Reset System");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    carRentalSystem.viewAvailableCars();
                    break;
                case 2:
                    System.out.print("Enter the Car ID to rent: ");
                    String rentCarId = scanner.next();
                    System.out.print("Enter rental duration in days: ");
                    int rentalDays = scanner.nextInt();
                    if (carRentalSystem.validateRentalDays(rentalDays)) {
                        carRentalSystem.rentCar(rentCarId, rentalDays);
                    } else {
                        System.out.println("Error: Rental days must be greater than zero.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the Car ID to return: ");
                    String returnCarId = scanner.next();
                    carRentalSystem.returnCar(returnCarId);
                    break;
                case 4:
                    carRentalSystem.listRentedCars();
                    break;
                case 5:
                    System.out.print("Enter the model to search: ");
                    String searchModel = scanner.next();
                    carRentalSystem.searchByModel(searchModel);
                    break;
                case 6:
                    carRentalSystem.resetSystem();
                    break;
                case 7:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }
}
