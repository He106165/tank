package com.hpfTank.Observer;

import com.hpfTank.testShow.TankInfo;

public class TankFireHeader implements TankObserver{
    @Override
    public void ActionOnFire(TankEvent event) {
        TankInfo source = event.getSource();
        source.frie();
    }
}
