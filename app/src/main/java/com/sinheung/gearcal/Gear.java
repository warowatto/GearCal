package com.sinheung.gearcal;

/**
 * Created by ShinHeung on 2017-02-25.
 */

public class Gear {

    double module;
    double teeth;
    double pressAngleDeg;

    double torsionAngleDeg = 0;
    double addTeeth = 0;

    public Gear(double module, double teeth, double pressAngleDeg) {
        this.module = module;
        this.teeth = teeth;
        this.pressAngleDeg = pressAngleDeg;
    }

    public Gear(double module, double teeth, double pressAngleDeg, double torsionAngleDeg, double addTeeth) {
        this.module = module;
        this.teeth = teeth;
        this.pressAngleDeg = pressAngleDeg;
        this.torsionAngleDeg = torsionAngleDeg;
        this.addTeeth = addTeeth;
    }

    public double getOD() {
        return GearCal.od(module, teeth, pressAngleDeg, addTeeth);
    }

    public double zm() {
        return GearCal.zm(pressAngleDeg, teeth);
    }

    public double sm(double zm) {
        return GearCal.sm(module, teeth, zm, pressAngleDeg, torsionAngleDeg, addTeeth);
    }
}
