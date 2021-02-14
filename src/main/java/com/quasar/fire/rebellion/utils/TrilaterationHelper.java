package com.quasar.fire.rebellion.utils;


import com.quasar.fire.rebellion.entity.Location;
import com.quasar.fire.rebellion.entity.Message;

public class TrilaterationHelper {
    Message m1, m2, m3;

    public TrilaterationHelper(Message message1, Message message2, Message message3){
        this.m1 = message1;
        this.m2 = message2;
        this.m3 = message3;
    }

    public Location getLocation(){
        return new Location(getPosX(),getPosY());
    }

    private double getPosX(){
        return (C()*E() - F()*B()) / (E()*A() - B()*D());
    }

    private double getPosY(){
        return (C()*D() - A()*F()) / (B()*D() - A()*E());
    }

    private double A(){
        return -2*m1.getSatellite().getPosX() + 2*m2.getSatellite().getPosX();
    }

    private double B(){
        return -2*m1.getSatellite().getPosY() + 2*m2.getSatellite().getPosY();
    }

    private double C(){
        return sq(m1.getDistance())-sq(m2.getDistance())
                -sq(m1.getSatellite().getPosX())
                +sq(m2.getSatellite().getPosX())
                -sq(m1.getSatellite().getPosY())
                +sq(m2.getSatellite().getPosY());
    }

    private double D(){
        return -2*m2.getSatellite().getPosX() + 2*m3.getSatellite().getPosX();
    }

    private double E(){
        return -2*m2.getSatellite().getPosY() + 2*m3.getSatellite().getPosY();
    }

    private double F(){
        return sq(m2.getDistance())-sq(m3.getDistance())
                -sq(m2.getSatellite().getPosX())
                +sq(m3.getSatellite().getPosX())
                -sq(m2.getSatellite().getPosY())
                +sq(m3.getSatellite().getPosY());
    }

    private double sq(double num){
        return Math.pow(num, 2);
    }
}
