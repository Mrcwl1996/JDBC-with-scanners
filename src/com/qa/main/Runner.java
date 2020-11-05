package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        DatabaseConnector db = new DatabaseConnector();

        String action = "";
        action = getAction();
        // create, read, update, delete, (exit)

        try {
            do {
                switch (action) {
                case "create":
                    System.out.println("Please enter a forename");
                    String forename = scan.nextLine();
                    System.out.println(" Please enter a surname");
                    String surname = scan.nextLine();
                    db.createActor(forename, surname);
                    break;
                case "read":
                    db.readAllActors();
                    break;
                case "update":
                    System.out.println("Please enter the ID of the actor you want to change");
                    int updateId = Integer.parseInt(scan.nextLine());
                    System.out.println("Please enter the new forename");
                    String newForename = scan.nextLine();
                    System.out.println("Please enter the new surname");
                    String newSurname = scan.nextLine();
                    db.updateActor(newForename, newSurname, updateId);
                    break;
                case "delete":
                    System.out.println("Please enter the ID of the actor you want to delete");
                    int deleteId = Integer.parseInt(scan.nextLine());
                    db.deleteActor(deleteId);
                    break;
                default:
                    System.out.println("No matching case-statement");
                }
                action = getAction();
            } while (!action.equals("exit"));
            System.out.println("bye");
        } finally {
            scan.close();
            db.close();
        }
    }

    private static String getAction() {
        System.out.println("Please enter the CRUD method you want");
        return scan.nextLine();
    }

}