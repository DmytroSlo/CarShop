package org.dmytroslo;

import java.io.FileNotFoundException;

public interface ISklep {
    String setInfo();
    void addCar() throws FileNotFoundException;
    void deleteCar();
    void shearchModelAndMarkCar() throws FileNotFoundException;
    void saveData();
    String readData() throws FileNotFoundException;
}
