class ParkingSystem {
    private int[] availableSpaces;

    public ParkingSystem(int big, int medium, int small) {
        availableSpaces = new int[] {0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (availableSpaces[carType] == 0) {
            return false;
        }
      
        availableSpaces[carType]--;
        return true;
    }
}