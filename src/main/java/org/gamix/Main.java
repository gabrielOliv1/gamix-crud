package org.gamix;

import java.util.Scanner;

import org.gamix.DAO.UserDAO;
import org.gamix.models.User;

public class Main {
    public static void main(String[] args) {
     
        int choice = 1;
        int totalOptions = 5;

        while (true) {
            showMenu(choice);

            char input = readInput();

            if (input == 'U') {
                if (choice > 1) {
                    choice--;
                }
            } else if (input == 'D') {
                if (choice < totalOptions) {
                    choice++;
                }
            } else if (input == 'E') {
              execute(choice);  
            }
        }
    }

    public static void showMenu(int choice) {
        System.out.println("Selecione a opção desejada: ");   
        System.out.println("[1] Opção 1" + (choice == 1 ? "<--" : ""));
        System.out.println("[2] Opção 2" + (choice == 1 ? "<--" : ""));
    }

    public static char readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            return ' ';
        } else {
            return input.charAt(0);
        }
    }

    public static void execute(int choice) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();

       switch(choice) {
        case 1:
            userDAO.findAllUsers();
            break;
        case 2:
            System.out.println("Informe o nome do usuário: ");
            String usernameParameter = scanner.nextLine();
            userDAO.findByUsername(usernameParameter);
            break;
        case 3:
            System.out.println("Informe o email do usuário: ");
            String emailParameter = scanner.nextLine();
            userDAO.findByEmail(emailParameter);
            break;
        case 4:
            System.out.println("Informe o ID do usuário: ");
            Integer idParameter = scanner.nextInt();

            System.out.println("Novo username (ou pressione ENTER para manter este campo): ");
            String newUsername = scanner.nextLine();

            System.out.println("Novo email (ou pressione ENTER para manter este campo): ");
            String newEmail = scanner.nextLine();

            System.out.println("Novo icon (ou pressione ENTER para manter este campo): ");
            String newIcon = scanner.nextLine();

            User partialUserInput = new User();
            partialUserInput.setUsername(newUsername);
            partialUserInput.setEmail(newEmail);
            partialUserInput.setIcon(newIcon);

            userDAO.updateUser(idParameter, partialUserInput);
            break;
        case 5:
            System.out.println("Informe o ID da conta a ser excluída: ");
            Integer idToDelete = scanner.nextInt();
            userDAO.deleteAccount(idToDelete);
            break;
        default:
            System.out.println("Escolha inválida: ");
       }
        System.exit(0);
    }
}