package com.sinheung.gearcal;

/**
 * Created by ShinHeung on 2017-02-25.
 */

public class GearCal {

    public static double od(double module, double teeth) {
        return od(module, teeth, 0, 0);
    }

    public static double od(double module, double teeth, double addTeeth) {
        return od(module, teeth, 0, addTeeth);
    }

    public static double od(double module, double teeth , double torsionAngleDeg, double addTeeth) {
        double torsionAngleRad = toRadian(torsionAngleDeg);

        return (module * teeth) / Math.cos(torsionAngleRad) + (2 * module * addTeeth);
    }

    public static double pcd(double module, double teeth) {
        return pcd(module, teeth, 0);
    }

    public static double pcd(double module, double teeth, double torsionAngleDeg) {
        double torsionAngleRad = toRadian(torsionAngleDeg);
        double result = module * teeth / Math.cos(torsionAngleRad);

        return result;
    }

    public static double zm(double pressAngleDeg, double teeth) {
        double result = (pressAngleDeg * teeth) / 180 + 0.5;
        double roundResult = Math.round(result);

        return roundResult < 3 ? roundResult : roundResult + 1;
    }

    public static double sm(double module, double teeth, double zm, double pressAngleDeg) {
        return sm(module, teeth, zm, pressAngleDeg, 0, 0);
    }

    public static double sm(double module, double teeth, double zm, double pressAngleDeg, double addTeeth) {
        return sm(module, teeth, zm, pressAngleDeg, 0, addTeeth);
    }

    public static double sm(double module, double teeth, double zm, double pressAngleDeg, double torsionAngleDeg, double addTeeth) {
        double pressAngleRad = toRadian(pressAngleDeg);
        double torsionAngleRad = toRadian(torsionAngleDeg);
        double frontPressAngleDeg = Math.atan(Math.tan(pressAngleRad) / Math.cos(torsionAngleRad));
        double frontPressAngleRad = toDegree(frontPressAngleDeg);

        double result = module * Math.cos(pressAngleRad) * (Math.PI * (zm - 0.5) + (teeth * inv(frontPressAngleRad))) + (2 * addTeeth * module * Math.sin(pressAngleRad));

        return result;
    }

    public static double inv(double deg) {
        double rad = toRadian(deg);
        return Math.tan(rad) - rad;
    }

    public static double toRadian(double degree) {
        return Math.toRadians(degree);
    }

    public static double toDegree(double radian) {
        return Math.toDegrees(radian);
    }
}
