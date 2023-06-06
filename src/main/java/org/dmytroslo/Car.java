package org.dmytroslo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {
    private String mark;
    private String model;
    private int powerEngin;
    private int year;
    private int dystance;
    private double power;

    public Car(){}
    public Car(String mark, String model, int powerEngin, int year, int dystance, double power){
        this.mark = mark;
        this.model = model;
        this.powerEngin = powerEngin;
        this.year = year;
        this.dystance = dystance;
        this.power = power;
    }

    public String info(String name) throws FileNotFoundException {

        File file = new File("C:\\Users\\Dmytro.Slobodian.PL03W169\\Desktop\\CarShop\\src\\main\\java\\org\\dmytroslo\\carlist\\" + name);
        Scanner scan = new Scanner(file);

        System.out.println("Car:");
        while(scan.hasNextLine()){
            String el = scan.nextLine();
            System.out.println(el);
        }

        return null;
    }

    public void writeCar() throws FileNotFoundException {
        PrintWriter addCar = new PrintWriter("C:\\Users\\Dmytro.Slobodian.PL03W169\\Desktop\\CarShop\\src\\main\\java\\org\\dmytroslo\\carlist" + mark +" " + model + ".txt");

        addCar.println("Marka: " + mark +
                "\nModel: " + model +
                "\nPower Engin: " + powerEngin +
                "\nYear: " + year +
                "\nDystance: " + dystance + " km" +
                "\nPower: " + power);

        addCar.close();;

        System.out.println("Added new car: " + mark);
    }



    public static class Builder {
        private String mark;
        private String model;
        private int powerEngin;
        private int year;
        private int dystance;
        private double power;

        public Builder() {
        }

        public Builder(String mark, String model, int powerEngin, int year, int dystance, double power) {
            this.mark = mark;
            this.model = model;
            this.powerEngin = powerEngin;
            this.year = year;
            this.dystance = dystance;
            this.power = power;
        }

        public Builder setMark(String mark) {
            this.mark = mark;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setPowerEngin(int powerEngin) {
            this.powerEngin = powerEngin;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setDystance(int dystance) {
            this.dystance = dystance;
            return this;
        }

        public Builder setPower(double power) {
            this.power = power;
            return this;
        }

        public Car build() {
            return new Car(mark, model, powerEngin, year, dystance, power);
        }
    }
}
