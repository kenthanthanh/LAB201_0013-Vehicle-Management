
/**
 *
 * @author kei ti ti
 */
public class Car extends Vehicle {
 private String type;
        private int yearOfManufacture;
        
        public Car(String id, String name, String color, double price, String brand, String type,
                int yearOfManufacture) {
            super(id, name, color, price, brand);
            this.type = type;
            this.yearOfManufacture = yearOfManufacture;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getYearOfManufacture() {
            return yearOfManufacture;
        }

        public void setYearOfManufacture(int yearOfManufacture) {
            this.yearOfManufacture = yearOfManufacture;
        }

        
      

}