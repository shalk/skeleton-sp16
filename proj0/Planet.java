public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double G = 6.67e-11;
        double r = this.calcDistance(p);
        return G * mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - xxPos;
        double f = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return f * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - yyPos;
        double f = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        int index = 0;
        double fx = 0;
        while (index < planets.length) {
            if (!this.equals(planets[index])) {
                fx = fx + this.calcForceExertedByX(planets[index]);
            }
            index = index + 1;
        }
        return fx;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        int index = 0;
        double fy = 0;
        while (index < planets.length) {
            if (!this.equals(planets[index])) {
                fy = fy + this.calcForceExertedByY(planets[index]);
            }
            index = index + 1;
        }
        return fy;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel = ax * dt + xxVel;
        yyVel = ay * dt + yyVel;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
    /*
    public boolean equals(Planet p) {
        if (p.xxPos == xxPos && p.yyPos == yyPos) {
            return true;
        }
        return false;
    }
    */
}