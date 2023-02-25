package org.example.Exception;

public class FastagBalnceAlreadyAdded extends RuntimeException{
    public FastagBalnceAlreadyAdded ( String fastagAlreadyRegistered ) {
        super(fastagAlreadyRegistered);
    }
}
