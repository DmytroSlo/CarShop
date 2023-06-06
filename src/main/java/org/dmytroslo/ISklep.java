package org.dmytroslo;

import java.io.FileNotFoundException;

public interface ISklep {
    void setInfo() throws FileNotFoundException;
    void addCar() throws FileNotFoundException;
    void deleteCar();
    void shearchModelAndMarkCar() throws FileNotFoundException;
    void saveData();
    String readData() throws FileNotFoundException;
}
