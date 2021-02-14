package com.quasar.fire.rebellion.utils;


import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Satellite;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;

import java.util.List;
import java.util.Objects;

public class TrilaterationHelper {
    final Satellite s1, s2, s3;

    public TrilaterationHelper(List<Satellite> satellites) throws TrilaterationException {
        validateSatellites(satellites);
        this.s1 = satellites.get(0);
        this.s2 = satellites.get(1);
        this.s3 = satellites.get(2);
    }

    public Location getLocation() throws TrilaterationException {
        Location location = new Location(getPosX(),getPosY());
        validateLocation(location);
        return location;
    }

    private boolean distancesMatch(Satellite satellite, Location location){
        return Math.abs(
                satellite.getMessage().getDistance() - getDistance(satellite.getLocation(), location)
        ) < 0.001d;
    }

    private double getDistance(Location l1, Location l2){
        return Math.hypot(l2.getPosX() - l1.getPosX(), l2.getPosY() - l1.getPosY());
    }

    private double getPosX(){
        return (C()*E() - F()*B()) / (E()*A() - B()*D());
    }

    private double getPosY(){
        return (C()*D() - A()*F()) / (B()*D() - A()*E());
    }

    private double A(){
        return -2*s1.getPosX() + 2*s2.getPosX();
    }

    private double B(){
        return -2*s1.getPosY() + 2*s2.getPosY();
    }

    private double C(){
        return sq(s1.getMessage().getDistance())-sq(s2.getMessage().getDistance())
                -sq(s1.getPosX())
                +sq(s2.getPosX())
                -sq(s1.getPosY())
                +sq(s2.getPosY());
    }

    private double D(){
        return -2*s2.getPosX() + 2*s3.getPosX();
    }

    private double E(){
        return -2*s2.getPosY() + 2*s3.getPosY();
    }

    private double F(){
        return sq(s2.getMessage().getDistance())-sq(s3.getMessage().getDistance())
                -sq(s2.getPosX())
                +sq(s3.getPosX())
                -sq(s2.getPosY())
                +sq(s3.getPosY());
    }

    private double sq(double num){
        return Math.pow(num, 2);
    }

    private void validateLocation(Location location) throws TrilaterationException {
        if (!(distancesMatch(s1, location) || distancesMatch(s2,location) || distancesMatch(s3, location)))
            throw new TrilaterationException("Satellite information is invalid: No cruiser could be found.");
    }

    private void validateSatellites(List<Satellite> satellites) throws TrilaterationException {
        if (!(satellites.size() == 3))
            throw new TrilaterationException("Expected 3 satellites but received " + satellites.size());
        if (satellites.stream().anyMatch(sat -> Objects.isNull(sat.getMessage())))
            throw new TrilaterationException("Not all satellites have messages yet.");
    }
}
