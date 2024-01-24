
interface CarBuilder {
    … interface methods here
}

The key difference is that within an interface definition, we implement nothing:

interface CarBuilder {

    // A CarBuilder must be able to assemble a CarDoor
    CarDoor assembleCarDoor();

    // A CarBuilder must be able to assemble a Wheel
   Wheel assembleWheel(double radius);

}

Notice how the methods defined by this interface feature a return type, a name, parameters, and (again) nothing else. It’s up to classes that implement these interface roles to fill in the method code.

The interface itself has no clue how (or which) classes will ever implement its requirements, but it promises they will (somehow).

Interfaces may also define data that remains relevant to all implementations of the interface, data that may not be modified.

interface CarBuilder {
    double MAX_WHEEL_RADIUS_CM = 60.0;
    ...
}

When a class implements an interface, it inherits this data as well.

Implement an Interface
Let’s see how a class might implement the interface above. We’ll travel back in time to 1930 when all cars were built by hand:

// Note the `implements CarBuilder`
class AutoWorker extends Person implements CarBuilder {
    ...
}

The class above, AutoWorker, has a parent type of Person and fulfills the role of CarBuilder. While a class may inherit from only one other class, it may implement any number of interfaces:

class AutoWorker extends Person implements CarBuilder, CarMechanic, Employee {
    ...
}

To fulfill these interface roles, a class must implement the methods prescribed by each interface by overriding the method definitions:

class AutoWorker extends Person implements CarBuilder {
    public AutoWorker(String name, int age, int salary) {
        ...
    }

    …

    // CarBuilder Interface begins

    @Override
    public CarDoor assembleCarDoor() {
        // Put together the car door here
        …
        return carDoor;
    }

    @Override
    public Wheel assembleWheel(double radius) {

        ...
        if (radius > MAX_WHEEL_RADIUS_CM) {
            // modify wheel radius
        }
        // Put a wheel together here
        …
        return wheel;
    }
}