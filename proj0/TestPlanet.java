public class TestPlanet {
    public static void main(String[] args) {
        Planet origin = new Planet(0.0, 0.0, 0.0, 0.0, 5, "Sun.jpg");
        Planet earth = new Planet(3.0, 4.0, 3.0, 4.0, 5.0, "Eerth.jpg");
        double fx = origin.calcForceExertedByX(earth);
        double fy = origin.calcForceExertedByY(earth);
        System.out.println("fx:" + fx);
        System.out.println("fy:" + fy);
    }
} 