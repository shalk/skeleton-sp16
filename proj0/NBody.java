
public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readLine();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int count = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[count];
        int index = 0;
        while(index < count){
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets[index] = new Planet(xPos, yPos, xVel, yVel, mass, img);
            index++;
        }
        return planets;
    }
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = NBody.readPlanets(filename);
        double radius = NBody.readRadius(filename);
        double time = 0;
        // StdDraw.setScale(-radius, radius);
        // StdAudio.play("audio/2001.mid");
        while(time <= T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            // StdDraw.clear();
            // StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p: planets) {
            //   p.draw();
            }
            // StdDraw.show(10);
            time = time + dt;
        }
        System.out.printf("%d\n", planets.length);
        System.out.printf("%.2e\n", radius);
        for (Planet p: planets) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName
            );
        }
    }

}