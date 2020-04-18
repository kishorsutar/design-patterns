package com.kishor.adapter

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DomainTests {

    @Test
    fun verifyClientAdapter() {
        val sut = Client()
        val list = listOf<Vehicle>(CarObject(3, 29), CarObject(2, 58))
        assertEquals(list[0].getWindowCount(), sut.getVehicleList()[0].getWindowCount())
    }

    @Test
    fun verifyCostOfAllVehicle() {
        val sut = Client()
        val list = listOf(ScooterAdapter(EScooterObject(5)), BikeAdapter(BikeObject(44)), BikeAdapter(BikeObject(22)), CarObject(3, 29), CarObject(2, 58))
        var expected = 0
        for (vehicleObj in list) {
            expected += vehicleObj.calculateVehicleCost()
        }
        var result = 0
        for (vehicleObj in sut.getVehicleList()) {
            result += vehicleObj.calculateVehicleCost()
        }
        assertEquals(expected, result)
    }


}