package org.dmytroslo;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ISklep {
    void setInfo() throws FileNotFoundException;
    void addCar() throws FileNotFoundException;
    void deleteCar();
    void shearchModelAndMarkCar() throws FileNotFoundException;
    void saveData() throws IOException;
    String readData() throws FileNotFoundException;
}
