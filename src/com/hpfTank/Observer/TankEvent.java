package com.hpfTank.Observer;

import com.hpfTank.testShow.TankInfo;

public class TankEvent {


    TankInfo tankInfo;

    public TankEvent(TankInfo tankInfo) {
        this.tankInfo = tankInfo;
    }

    public TankInfo getSource(){
        return tankInfo;
    }

}
