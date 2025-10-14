public class PlanetApp {

    // --- Enum Definition ----
    public enum Planet {
        MERCURY ("Mercury", 1, 58.0, 2439.7, 1407.5),
        VENUS   ("Venus",   2, 108.0, 6051.8, 5832.5),
        EARTH   ("Earth",   3, 150.0, 6371.0,   23.9),
        MARS    ("Mars",    4, 228.0, 3389.5,   24.6),
        JUPITER ("Jupiter", 5, 778.0, 69911.0,   9.9),
        SATURN  ("Saturn",  6, 1430.0, 58232.0,  10.7),
        URANUS  ("Uranus",  7, 2870.0, 25362.0,  17.2),
        NEPTUNE ("Neptune", 8, 4495.0, 24622.0,  16.1);

        private final String name;
        private final int orderFromSun;
        private final double distanceFromSun; // in million km
        private final double radiusKm;
        private final double rotationHours;

        Planet(String name, int orderFromSun, double distanceFromSun, double radiusKm, double rotationHours) {
            this.name = name;
            this.orderFromSun = orderFromSun;
            this.distanceFromSun = distanceFromSun;
            this.radiusKm = radiusKm;
            this.rotationHours = rotationHours;
        }

        public String getName() { return name; }
        public int getOrderFromSun() { return orderFromSun; }
        public double getDistanceFromSun() { return distanceFromSun; }
        public double getRadiusKm() { return radiusKm; }
        public double getRotationHours() { return rotationHours; }

        @Override
        public String toString() {
            return String.format(
                    "%s (Order: %d, Distance: %.0f million km, Radius: %.0f km, Rotation: %.1f hours)",
                    name, orderFromSun, distanceFromSun, radiusKm, rotationHours
            );
        }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        System.out.printf("%-8s | %-5s | %-18s | %-14s | %-15s%n",
                "Planet", "Order", "Distance (million km)", "Radius (km)", "Rotation (hours)");
        System.out.println("--------------------------------------------------------------------------");

        for (Planet p : Planet.values()) {
            System.out.printf("%-8s | %-5d | %-18.0f | %-14.0f | %-15.1f%n",
                    p.getName(), p.getOrderFromSun(), p.getDistanceFromSun(), p.getRadiusKm(), p.getRotationHours());
        }
    }
}