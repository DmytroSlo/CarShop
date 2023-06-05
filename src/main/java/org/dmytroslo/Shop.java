package org.dmytroslo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop implements ISklep {
    private String shopName;
    private String adres;
    private List<String> listCar = new ArrayList<>();
    public Shop(){}
    public Shop(String shopName, String adres, List<String> listCar){
        this.shopName = shopName;
        this.adres = adres;
        this.listCar = listCar;
    }

    public void start(){
        User user = new User();
        while(true){
            if(user.getRole() == Role.CLIENT){
                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu");
            } else if(user.getRole() == Role.PERSONAL){
                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu" +
                        "\n4. Danne klientów" +
                        "\n5. Dodawanie nowego samochodu");
            } else if(user.getRole() == Role.ADMINISTRATOR){
                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu" +
                        "\n4. Danne klientów" +
                        "\n5. Dodawanie nowego samochodu" +
                        "\n6. Usuwanie samochodów" +
                        "\n7. Rejestracjia nowego użytkownika");
            } else if(user.getRole() == Role.BOSS){
                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu" +
                        "\n4. Danne klientów" +
                        "\n5. Dodawanie nowego samochodu" +
                        "\n6. Usuwanie samochodów" +
                        "\n7. Rejestracjia nowego użytkownika" +
                        "\n8. Zmiana nazwy salonu");
            }
        }
    }

    @Override
    public String setInfo() {

        return null;
    }

    @Override
    public void addCar() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj marke: ");
        String mark = scan.nextLine();

        System.out.print("Podaj model: ");
        String model = scan.nextLine();

        System.out.print("Poday moć silnika: ");
        int powerEng = scan.nextInt();

        System.out.print("Wpisz rocznik: ");
        int year = scan.nextInt();

        System.out.print("Poday przebieg: ");
        int dystance = scan.nextInt();


        System.out.print("Podaj moć [Example 1,4]: ");
        double moc = scan.nextDouble();

        System.out.println("Zatwierdz:" +
                "\nMark: " + mark +
                "\nModel: " + model +
                "\nPower Engin: " + powerEng +
                "\nYear: " + year +
                "\nDystance: " + dystance +
                "\nPower: " + moc);
        String accept = scan.nextLine();

        Car addCar = new Car.Builder().setMark(mark)
                .setModel(model)
                .setPowerEngin(powerEng)
                .setYear(year)
                .setDystance(dystance)
                .setPower(moc).build();

        addCar.writeCar();
    }

    @Override
    public void deleteCar() {

    }

    @Override
    public String shearchModelAndMarkCar() {
        return null;
    }

    @Override
    public void saveData() {

    }

    @Override
    public String readData() throws FileNotFoundException {
        Car infoCar = new Car();

        File folder = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\carlist\\");

        List<String> car = new ArrayList<>();

        File[] listOfFiles = folder.listFiles();

        for(File file : listOfFiles) {
            if(file.isFile() && file.getName().endsWith(".txt")){
                car.add(file.getName());
            }
        }

        int i = 1;

        Scanner scan = new Scanner(System.in);
        System.out.println("Wybierz samochód");
        for(String c : car){
            String[] name = c.split(".txt");
            System.out.println(i++ + ". Car: " + name[0]);
        }

        System.out.print("Podaj numer: ");
        int number = scan.nextInt();

        infoCar.info(car.get(number - 1));

        return infoCar.info(car.get(number - 1));
    }

    public void newUser() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj swoje imię: ");
        String name = scan.nextLine();

        System.out.print("Podaj nazwisko: ");
        String lName = scan.nextLine();

        System.out.print("Podaj login: ");
        String login = scan.nextLine();

        System.out.print("Poday hasło: ");
        String password = scan.nextLine();

        System.out.print("Podaj swój wiek: ");
        int age = scan.nextInt();

        User user = new User.Builder().setName(name)
                .setlName(lName)
                .setLogin(login)
                .setPassword(password)
                .setAge(age)
                .setRole(Role.ADMINISTRATOR).build();

        user.createAccount();
    }

    public String nameCompani() throws FileNotFoundException {
        File file = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\infoCompani.txt");
        Scanner scan = new Scanner(file);

        String nameComapni = "";
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.startsWith("NameCompani: ")){
                String[] n = line.split("NameCompani: ");
                nameComapni = n[1];
            }
        }

        return nameComapni;
    }
}
