package org.gamix.DAO;

import org.gamix.models.User;

public class UserDAO {

    private User vector[] = new User[10];
    private int userCount = 0;
    private int idCount = 1;

    public void insertUser(User user) {
        if (userCount < vector.length) {
            user.setId(idCount++);
            vector[userCount++] = user;
        } else {
            System.out.println("Sua lista está cheia");
        }
    }

    public User login(String usernameOrEmail, String password) {
        for (User user : vector) {
            if (user != null && (user.getUsername().equals(usernameOrEmail) || user.getEmail().equals(usernameOrEmail)) &&
                user.getPasswordUser().getPassword().equals(password)) {
                return user;
            }
        }
        return null; 
    }

    public void findAllUsers() {
        for (User user : vector) {
            if (user != null) {
            	System.out.println("\n" + "--------------------------------------");
                System.out.println("ID: " + user.getId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Icon: " + user.getIcon());
                System.out.println("Password: " + user.getPasswordUser().getPassword());
                System.out.println("--------------------------------------");
            }
        }
    }

    public void findByEmail(String email) {
        for (User user : vector) {
            if (user != null && user.getEmail().equals(email)) {
            	System.out.println("\n" + "--------------------------------------");
                System.out.println("ID: " + user.getId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Icon: " + user.getIcon());
                System.out.println("Password: " + user.getPasswordUser().getPassword());
                System.out.println("--------------------------------------");
            } 
        }
    }

    public void findByUsername(String username) {
        for (User user : vector) {
            if (user != null && user.getUsername().equals(username)) {
            	System.out.println("\n" + "--------------------------------------");
                System.out.println("ID: " + user.getId());
                System.out.println("Username: " + user.getUsername());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Icon: " + user.getIcon());
                System.out.println("Password: " + user.getPasswordUser().getPassword());
                System.out.println("--------------------------------------");
            }
        }
    }

    public void updateUser(Integer id, User partialUserInput) {
    	boolean exist = false;
        for (User user : vector) {
            if (user != null && user.getId().equals(id)) {
                user.partialUserInput(partialUserInput);
                exist = true;
                break;
            }
        }
        if (exist == false) {
        	System.out.println("Não existe usuário com esse ID");
        }
    }

    public void deleteAccount(Integer id) {
    	boolean exist = false;
        for (int i = 0; i < userCount; i++) {
            if (vector[i] != null && vector[i].getId().equals(id)) {
                vector[i] = null;
                exist = true;
                System.out.println("Conta excluída com sucesso!");
                userCount--;
          
                for (int j = i; j < userCount; j++) {
                    vector[j] = vector[j + 1];
                }
                vector[userCount] = null; 
                break;
            }
        }
        if (exist == false) {
        	System.out.println("Não existe usuário com esse ID");
        }
    }

    
}
