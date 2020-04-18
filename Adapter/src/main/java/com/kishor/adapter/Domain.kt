package com.kishor.adapter

interface Vehicle {
    fun getWindowCount() : Int
    fun calculateVehicleCost() : Int
    fun getEngineCost() : Int
}

class CarObject(private val numberOfWindows: Int = 0, private val engineSize: Int = 10): Vehicle {

    override fun getWindowCount() : Int {
        return numberOfWindows
    }

    override fun calculateVehicleCost() : Int{
        return numberOfWindows * 200 + getEngineCost()
    }

    override fun getEngineCost() : Int {
        return engineSize * 10
    }
}

class Client {
    fun getVehicleList() : List<Vehicle> {

        val mutableVehicleList = mutableListOf<Vehicle>()
        val vehicle1 = CarObject(3, 29)
        val vehicle2 = CarObject(2, 58)

        val bike = BikeObject(44)
        val bike2 = BikeObject(22)

        val eScooter = EScooterObject(5)

        mutableVehicleList.add(vehicle1)
        mutableVehicleList.add(vehicle2)
        mutableVehicleList.add(BikeAdapter(bike))
        mutableVehicleList.add(BikeAdapter(bike2))
        mutableVehicleList.add(ScooterAdapter(eScooter))

        return mutableVehicleList
    }
}

class BikeObject(private val engineSize: Int = 5) {

    fun engineCost() : Int {
        return engineSize * 10
    }
    fun getBikePrice() : Int {
        return engineCost() + 500
    }

}
class BikeAdapter(private val bike: BikeObject) : Vehicle {

    override fun getWindowCount(): Int {
        return 0
    }
    override fun calculateVehicleCost(): Int {
        return bike.getBikePrice()
    }

    override fun getEngineCost(): Int {
        return bike.engineCost()
    }

}
class EScooterObject(private val batterySize: Int = 2) {

    fun batteryCost() : Int {
        return batterySize * 2
    }
    fun getScooterCost() : Int {
        return batteryCost() + 10
    }

}

class ScooterAdapter(private val eScooter: EScooterObject) : Vehicle {

    override fun getWindowCount(): Int {
        return 0
    }

    override fun calculateVehicleCost(): Int {
        return eScooter.getScooterCost() + getEngineCost()
    }

    override fun getEngineCost(): Int {
        return eScooter.batteryCost()
    }
}
