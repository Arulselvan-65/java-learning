package org.example.ReportCard;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportCard {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Choose an option:\n 1. Add Student \n 2. Get Student \n 3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter number of students: ");
                int count = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < count; i++) {
                    Student stud = new Student();
                    System.out.format("Enter Name of the student %d: ", i + 1);
                    String name = sc.nextLine();
                    System.out.format("Enter Mark of the student %d: ", i + 1);
                    int mark = sc.nextInt();
                    sc.nextLine();
                    stud.setName(name);
                    stud.setRollNum(i + 1);
                    stud.setMark(mark);
                    students.add(stud);
                }
            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No Student record.");
                }
                System.out.println("Enter roll no: ");
                int rollNo = sc.nextInt();
                for (int i = 0; i < students.size(); i++) {
                    if (rollNo == i + 1) {
                        Student stud = students.get(i);
                        System.out.format("Name : %s \nRoll Number : %d \nMark : %d\n",
                                stud.getName(), stud.getRollNum(), stud.getMark());
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exit Successful!!");
                System.exit(0);
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
