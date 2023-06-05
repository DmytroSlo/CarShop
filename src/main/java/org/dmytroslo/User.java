package org.dmytroslo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class User {
    private String name;
    private String lName;
    private String login;
    private String password;
    private int age;
    private Role role;

    public User(){}
    public User(String name, String lName, String login, String password, int age, Role role){
        this.name = name;
        this.lName = lName;
        this.login = login;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public void createAccount() throws FileNotFoundException {
        PrintWriter save = new PrintWriter("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\users\\" + login + ".txt");
        save.println("Name: " + name +
                "\nLast name: " + lName +
                "\nLogin: " + login +
                "\nPassword: " + password +
                "\nAge: " + age +
                "\nRole: " + role);

        save.close();

        System.out.println("Nowy " + role + ", został utworzony!" +
                "\nName: " + name);
    }

    public boolean isNotEmpty(String login) throws FileNotFoundException {

        File file = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\users\\" + login + ".txt");

        boolean isNotEmpty = false;

        if (file.exists()) isNotEmpty = true;

        setGet(login);

        return isNotEmpty;
    }

    public void setGet(String login) throws FileNotFoundException {
        File file = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\users\\" + login + ".txt");

        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.startsWith("Name: ")){
                String[] nameUser = line.split("Name: ");
                setName(nameUser[1]);
            }

            if(line.startsWith("Password: ")){
                String[] passwordUser = line.split("Password: ");
                setPassword(passwordUser[1]);
            }

            if(line.startsWith("Role: ")){
                String[] rol = line.split("Role: ");
                Role r = Role.valueOf(rol[1]);
                setRole(r);
            }
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean currentPassword(String login, String password) throws FileNotFoundException {
        File file = new File("D:\\Programowanie\\03.06.2023\\CarShop\\src\\main\\java\\org\\dmytroslo\\users\\" + login + ".txt");

        boolean acceptLogin = false;

        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.startsWith("Password: ")){
                String[] w = line.split("Password: ");
                String currentPassword = w[1];
                if(currentPassword.equals(password)){
                    acceptLogin = true;
                }
            }
        }

        return acceptLogin;
    }


    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static class Builder{
        private String name;
        private String lName;
        private String login;
        private String password;
        private int age;
        private Role role;

        public Builder(){}
        public Builder(String name, String lName, String login, String password, int age, Role role){
            this.name = name;
            this.lName = lName;
            this.login = login;
            this.password = password;
            this.age = age;
            this.role = role;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setlName(String lName) {
            this.lName = lName;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setRole(Role role){
            this.role = role;
            return this;
        }

        public User build(){
            return new User(name, lName, login, password, age, role);
        }
    }
}
