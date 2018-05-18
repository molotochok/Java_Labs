package com.company.TrainHierarchy;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractLocomotiveTest {

    @Test
    public void setPower() {
        AbstractLocomotive locomotive = new ElectricLocomotive();
        locomotive.setPower(100);

        assertEquals(100, locomotive.getPower());
    }

    @Test
    public void setMaxSpeed() {
        AbstractLocomotive locomotive = new ElectricLocomotive();
        locomotive.setMaxSpeed(12312);

        assertEquals(12312, locomotive.getMaxSpeed());
    }
}