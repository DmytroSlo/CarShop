package org.dmytroslo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.dmytroslo.Role.*;

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

    public void start(String login) throws FileNotFoundException {
        User user = new User();
        user.setGet(login);
        while(true){
            if(user.getRole() == CLIENT){
                Scanner scan = new Scanner(System.in);
                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu");

                int result = scan.nextInt();
                switch (result){
                    case 1:
                        readData();
                        break;
                    case 2:
                        System.out.println("W trakcie \\ Create this function");
                        break;
                    case 3:
                        System.out.println("Danne salonu \\ Create this function");
                        break;
                    default:
                        break;
                }


            } else if(user.getRole() == PERSONAL){
                Scanner scan = new Scanner(System.in);

                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu" +
                        "\n4. Danne klientów" +
                        "\n5. Dodawanie nowego samochodu");

                int result = scan.nextInt();
                switch (result){
                    case 1:
                        readData();
                        break;
                    case 2:
                        System.out.println("W trakcie \\ Create this function");
                        break;
                    case 3:
                        System.out.println("Danne salonu \\ Create this function");
                        break;
                    case 4:
                        System.out.println("Danne klientów \\ Create this function");
                        break;
                    case 5:
                        System.out.println("Dodawanie nowego samochodu \\ Create this function");
                        break;
                    default:
                        break;
                }
            } else if(user.getRole() == ADMINISTRATOR){
                Scanner scan = new Scanner(System.in);

                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu" +
                        "\n4. Danne klientów" +
                        "\n5. Dodawanie nowego samochodu" +
                        "\n6. Usuwanie samochodów" +
                        "\n7. Rejestracjia nowego użytkownika");

                int result = scan.nextInt();
                switch (result){
                    case 1:
                        readData();
                        break;
                    case 2:
                        System.out.println("W trakcie \\ Create this function");
                        break;
                    case 3:
                        System.out.println("Danne salonu \\ Create this function");
                        break;
                    case 4:
                        System.out.println("Danne klientów \\ Create this function");
                        break;
                    case 5:
                        System.out.println("Dodawanie nowego samochodu \\ Create this function");
                        break;
                    case 6:
                        System.out.println("Usuwanie samochodów \\ Create this function");
                        break;
                    case 7:
                        newUser();
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N");
                        String res = scanner.nextLine();
                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                    default:
                        break;
                }

            } else if(user.getRole() == BOSS){
                Scanner scanner = new Scanner(System.in);

                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu" +
                        "\n4. Danne klientów" +
                        "\n5. Dodawanie nowego samochodu" +
                        "\n6. Usuwanie samochodów" +
                        "\n7. Rejestracjia nowego użytkownika" +
                        "\n8. Zmiana nazwy salonu");

                int result = scanner.nextInt();
                switch (result){
                    case 1:
                        readData();
                        break;
                    case 2:
                        System.out.println("W trakcie \\ Create this function");
                        break;
                    case 3:
                        System.out.println("Danne salonu \\ Create this function");
                        break;
                    case 4:
                        System.out.println("Danne klientów \\ Create this function");
                        break;
                    case 5:
                        System.out.println("Dodawanie nowego samochodu \\ Create this function");
                        break;
                    case 6:
                        System.out.println("Usuwanie samochodów \\ Create this function");
                        break;
                    case 7:
                        newUser();
                        Scanner scan = new Scanner(System.in);
                        System.out.println("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N");
                        String res = scan.nextLine();
                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                    case 8:
                        System.out.println("Zmiana nazwy salonu \\ Create this function");
                        break;
                    default:
                        break;
                }
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

        return infoCar.info(car.get(number - 1));
    }

    public void newUser() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Podaj imię: ");
        String name = scan.nextLine();

        System.out.print("Podaj nazwisko: ");
        String lName = scan.nextLine();

        System.out.print("Podaj login: ");
        String login = scan.nextLine();

        System.out.print("Poday hasło: ");
        String password = scan.nextLine();

        System.out.print("Podaj wiek: ");
        int age = scan.nextInt();

        System.out.println("Wybierz role dla użytkownika:" +
                "\n1. Client" +
                "\n2. Pracownik" +
                "\n3. Administrator");

        int rol = scan.nextInt();
        Role role = CLIENT;
        switch (rol){
            case 1:
                role = CLIENT;
                break;
            case 2:
                role = PERSONAL;
                break;
            case 3:
                role = ADMINISTRATOR;

        }

        User user = new User.Builder().setName(name)
                .setlName(lName)
                .setLogin(login)
                .setPassword(password)
                .setAge(age)
                .setRole(role).build();

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
