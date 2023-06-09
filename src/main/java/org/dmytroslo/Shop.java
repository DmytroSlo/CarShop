package org.dmytroslo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

    public void start(String login) throws IOException {
        User user = new User();
        user.setGet(login);
        while(true){
            if(user.getRole() == CLIENT){
                Scanner scan = new Scanner(System.in);
                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu");

                System.out.print(": ");
                int result = scan.nextInt();
                Scanner scanner = new Scanner(System.in);
                String res = "";
                switch (result){
                    case 1:
                        readData();

                        System.out.println("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 2:
                        shearchModelAndMarkCar();

                        System.out.println("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 3:
                        setInfo();

                        System.out.println("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
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

                System.out.print(": ");
                int result = scan.nextInt();

                Scanner scanner = new Scanner(System.in);
                String res = "";
                switch (result){
                    case 1:
                        readData();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 2:
                        shearchModelAndMarkCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 3:
                        setInfo();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 4:
                        clientsDate(false);

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 5:
                        addCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
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

                System.out.print(": ");
                int result = scan.nextInt();

                Scanner scanner = new Scanner(System.in);
                String res = "";
                switch (result){
                    case 1:
                        readData();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 2:
                        shearchModelAndMarkCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 3:
                        setInfo();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 4:
                        clientsDate(false);

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 5:
                        addCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 6:
                        deleteCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 7:
                        newUser();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();
                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                    default:
                        break;
                }

            } else if(user.getRole() == BOSS){
                Scanner scan = new Scanner(System.in);

                System.out.println("Menu:" +
                        "\n1. Katalog samochodowy;" +
                        "\n2. Wyszukiwanie samochoda" +
                        "\n3. Danne salonu" +
                        "\n4. Danne klientów" +
                        "\n5. Dodawanie nowego samochodu" +
                        "\n6. Usuwanie samochodów" +
                        "\n7. Rejestracjia nowego użytkownika" +
                        "\n8. Zmiana nazwy salonu");

                System.out.print(": ");
                int result = scan.nextInt();

                Scanner scanner = new Scanner(System.in);
                String res = "";
                switch (result){
                    case 1:
                        readData();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 2:
                        shearchModelAndMarkCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 3:
                        setInfo();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 4:
                        clientsDate(true);

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 5:
                        addCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 6:
                        deleteCar();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();

                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 7:
                        newUser();

                        System.out.println("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N");
                        res = scanner.nextLine();
                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    case 8:
                        saveData();

                        System.out.print("Oby cofnąć się do poprzedniego menu wybierz - Y." +
                                "\nDla zakonczenia - N" +
                                ": ");
                        res = scanner.nextLine();
                        if(!res.equals("Y")){
                            System.out.println("Do zobaczenia " + user.getName() + "!");
                            return;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void setInfo() throws FileNotFoundException {
        File file = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\infoCompani.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
        }
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
        File folder = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\carlist");

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

        File folderDeleted = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\carlist\\" + car.get(number - 1));
        folderDeleted.delete();
    }

    @Override
    public void shearchModelAndMarkCar() throws FileNotFoundException {
        Map<String, String> carShearch = new HashMap<>();

        File folder = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\carlist");
        File[] listOfFile = folder.listFiles();

        for(File file : listOfFile) {
            if(file.isFile() && file.getName().endsWith(".txt")){
                String[] split = file.getName().split(".txt");
                String[] car = {split[0]};
                for (String i : car) {
                    String[] modelMark = i.split(" ");
                    carShearch.put(modelMark[1], modelMark[0]);
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Wprowadz pierwsze litery Marki lub Mddeli samochodu!");
        String input = scan.nextLine();

        int v = 1;

        List<String> car = new ArrayList<>();

        for(Map.Entry<String, String> i : carShearch.entrySet()){
            if(i.getKey().startsWith(input) || i.getValue().startsWith(input)){
                System.out.println(v++ + ". " + i.getValue() + " " + i.getKey());
                car.add(i.getValue() + " " + i.getKey() + ".txt");
            }
        }

        System.out.println("Wybierz samochód z listy: ");
        int number = scan.nextInt();
        Car carInfo = new Car();
        carInfo.info(car.get(number - 1));
    }

    @Override
    public void saveData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nową nazwe firmy: ");
        String newName = scanner.nextLine();

        File file = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\infoCompani.txt");
        StringBuilder content = new StringBuilder();

        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.startsWith("NameCompani: ")){
                line = "NameCompani: " + newName;
            }
            content.append(line).append("\n");
        }
        scan.close();

        FileWriter save = new FileWriter(file);
        save.write(content.toString());
        save.close();

        System.out.println("Nazwa firmy zmieniona na: " + newName);
    }

    @Override
    public void readData() throws FileNotFoundException {
        Car infoCar = new Car();

        File folder = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\carlist");

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
    }

    public void clientsDate(boolean ho) throws FileNotFoundException {
        File folder = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\users");

        File[] listOfUsers = folder.listFiles();
        List<String> users = new ArrayList<>();

        for(File file : listOfUsers) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                users.add(file.getName());
            }
        }

        List<String> name = new ArrayList<>();
        List<String> lName = new ArrayList<>();

        for(String el : users) {
            File userFolder = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\users\\" + el);
            Scanner scanner = new Scanner(userFolder);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.startsWith("Name: ")){
                    String[] n = line.split("Name: ");
                    name.add(n[1]);
                }

                if(line.startsWith("Last name: ")){
                    String[] n = line.split("Last name: ");
                    lName.add(n[1]);
                }
            }
        }

        int j = 0;
        int value = 1;

        System.out.println("Lista klientów");
        for(int i = 0; i < name.size(); i++) {
                System.out.println(value++ + ". " + name.get(i) + " " + lName.get(j++));
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("Wybierz klienta którego chcesz zobaczyć: ");
        int input = scan.nextInt();

        File userFolder = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\users\\" + users.get(input - 1));
        Scanner scanner = new Scanner(userFolder);

        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
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
