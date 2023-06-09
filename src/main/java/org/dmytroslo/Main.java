package org.dmytroslo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Shop shop = new Shop();
        User user = new User();

        Scanner scan = new Scanner(System.in);
        System.out.println("Witamy w: " + shop.nameCompani() +
                "\nDla kontynowania, wymagana jest autoryzacjia!");

        System.out.print("Login: ");
        String login = scan.nextLine();

        System.out.print("Password: ");
        String password = scan.nextLine();

        while(true) {
            if (user.isNotEmpty(login) && user.currentPassword(login, password)) {
                System.out.println("Witaj " + user.getName() + " w naszym salonie!");
                shop.start(login);
                break;
            } else if (user.isNotEmpty(login) && !user.currentPassword(login, password)) {
                System.out.print("Złe wpisałeś hasło!");
                break;
            } else if (!user.isNotEmpty(login)) {
                System.out.println("Takiego użytkownika nie ma w systemie." +
                        "\nSkontaktuj się z przedstawicielami serwisa dla zalorzenia konta!");
                break;
            }
        }
    }
}