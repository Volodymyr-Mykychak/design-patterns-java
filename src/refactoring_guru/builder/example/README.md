# Builder Pattern Example

The Builder Pattern is a creational design pattern that allows for the step-by-step construction of complex objects. This pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations. This is useful when you need to create different types or representations of a product using the same construction process.

## Overview

In this example, we demonstrate the Builder Pattern through the construction of two products:

1. **Car**
2. **Car Manual**

The `Builder` interface defines the steps required to build a product. Concrete builders implement these steps to construct specific products. The `Director` class orchestrates the building process by specifying the sequence of the steps.

### Components

- **Builder Interface**: Defines the methods required to build a product.
    - `setCarType(CarType type)`
    - `setSeats(int seats)`
    - `setEngine(Engine engine)`
    - `setTransmission(Transmission transmission)`
    - `setTripComputer(TripComputer tripComputer)`
    - `setGPSNavigator(GPSNavigator gpsNavigator)`

- **Concrete Builders**:
    - `CarBuilder`: Builds a `Car` object.
    - `CarManualBuilder`: Builds a `Manual` object.

- **Products**:
    - `Car`: Represents a car with various features such as engine, transmission, and GPS navigator.
    - `Manual`: Represents a user manual for a car.

- **Director**: Specifies the order of the building steps. It works with a builder object to construct the desired product.

### Usage

The `Demo` class provides an example of how to use the Builder Pattern. It demonstrates constructing both a `Car` and a `Car Manual` using the `Director` and various builders.

#### Example

```java
public class Demo {

    public static void main(String[] args) {
        Director director = new Director();

        // Create and configure a Car
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        // Create and configure a Car Manual
        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
