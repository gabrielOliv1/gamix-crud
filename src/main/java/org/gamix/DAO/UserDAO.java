package org.gamix.DAO;

import org.gamix.models.User;

import java.util.Objects;

public class UserDAO {

    private final User[] vector = new User[10];

    // findAll

    public void findAllUsers() {

        for (User user : vector) {
            System.out.println(
                    "Username:" + user.getUsername() + "\n" +
                            "Email:" + user.getEmail() + "\n" +
                            "Icon: " + user.getIcon() + "\n" +
                            "password: " + user.getPasswordUser().getPassword() + "\n"
            );
        }
    }

    // findByEmail

    public void findByEmail(String email) {
        for (User user : vector) {
            if (user.getEmail().equals(email)) {
                System.out.println(
                        "Username:" + user.getUsername() + "\n" +
                                "Email:" + user.getEmail() + "\n" +
                                "Icon: " + user.getIcon() + "\n" +
                                "password: " + user.getPasswordUser().getPassword() + "\n"
                );
            }
        }
    }

    public void findByUsername(String username) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i].getUsername().equals(username)) {
                System.out.println(
                        "Username:" + vector[i].getUsername() + "\n" +
                                "Email:" + vector[i].getEmail() + "\n" +
                                "Icon: " + vector[i].getIcon() + "\n" +
                                "password: " + vector[i].getPasswordUser().getPassword() + "\n"
                );

                break;
            }
        }
    }
    // update user

    public void updateUser(Integer id, User partialUserInput) {
        for (User user : vector) {
            if (user.getId().equals(id)) {
                user.partialUserInput(partialUserInput);

                break;
            }
        }
    }

    public void deleteAccount(Integer id) {
        int indexToExclude = -1;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] != null && Objects.equals(vector[i].getId(), id)) {
                indexToExclude = i;
                break;
            }
        }

        if (indexToExclude >= 0) {
            for (int i = indexToExclude; i < vector.length; i++) {
                vector[i] = vector[i + 1];
            }

            vector[vector.length - 1] = null;
        }
    }

}
