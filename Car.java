class Car {
    private String carId;
    private String model;
    private boolean isRented;

    public Car(String carId, String model) {
        this.carId = carId;
        this.model = model;
        this.isRented = false;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
