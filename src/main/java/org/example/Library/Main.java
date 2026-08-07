package org.example.Library;
import org.example.Utils.CommonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static HashMap<String, String> members = new HashMap<>();
    public static HashMap<String, Book> books = new HashMap<>();
    public static HashMap<String, List<String>> memToBook = new HashMap<>();
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while(true) {
            System.out.println(" 1. Add Member\n 2. Get Member\n 3. Add Book\n 4. Get Book\n 5. Lend Book\n " +
                    "6. Get Member Books\n 7. Exit\n Enter your Choice: ");
            Integer choice = sc.nextInt();
            sc.nextLine();
            if (choice.equals(1)) {
                addMember();
            } else if (choice.equals(2)) {
                getMember();
            } else if (choice.equals(3)) {
                addBook();
            } else if (choice.equals(4)) {
                getBook();
            } else if (choice.equals(5)) {
                lendBook();
            } else if (choice.equals(6)) {
                getMemberBooks();
            } else if (choice.equals(7)) {
                System.exit(0);
            } else {
                System.out.println("Invalid Choice!!");
            }
        }
    }

    public static void addMember() {
        System.out.println("Enter Member Name: ");
        String name = sc.nextLine();
        String mId = "M" + (members.size() + 1);
        members.put(mId, name);
        System.out.format("Added Member with id %s!!\n", mId);
    }

    public static void getMember() {
        System.out.println("Enter Member ID: ");
        String id = sc.nextLine();
        if(!members.containsKey(id)) {
            System.out.println("Member Not Found!!");
        } else {
            System.out.format("Member Id: %s\n", id);
            System.out.format("Member Name: %s\n", members.get(id));
        }
    }

    public static void addBook() {
        String bId = "B" + (books.size() + 1);
        System.out.println("Enter Book Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Book Count: ");
        int count = sc.nextInt();
        Book book = new Book(name, count);
        books.put(bId, book);
        System.out.format("Added Book with id %s!!\n", bId);
    }

    public static void getBook() {
        System.out.println("Enter Book ID: ");
        String id = sc.nextLine();
        if(!books.containsKey(id)) {
            System.out.println("Book Not Found!!");
        } else {
            System.out.format("Book Id: %s\n", id);
            System.out.format("Book Name: %s\n", books.get(id).getName());
            System.out.format("Book Count: %s\n", books.get(id).getCount());
        }
    }

    public static void lendBook() {
        System.out.println("Enter Member ID: ");
        String member = sc.nextLine();
        System.out.println("Enter Book ID: ");
        String book = sc.nextLine();
        if(!members.containsKey(member)){
            System.out.println("Member Not Found!!");
            return;
        }
        if(!books.containsKey(book)){
            System.out.println("Book Not Found!!");
            return;
        }
        if(!CommonUtil.checkIsNullOrEmpty(memToBook.get(member)) && memToBook.get(member).contains(book)) {
            System.out.println("Member Already Got the Book!!");
            return;
        }
        Book b = books.get(book);
        if(!memToBook.containsKey(member)) {
            memToBook.put(member, new ArrayList<>());
        }
        if(b.getCount() == 0) {
            System.out.println("Book Not Available!!");
        } else {
            memToBook.get(member).add(book);
            b.setCount(b.getCount() - 1);
            System.out.println("Book Lend Successful!!");
        }
    }

    public static void getMemberBooks() {
        System.out.println("Enter Member ID: ");
        String id = sc.nextLine();
        if(!members.containsKey(id)) {
            System.out.println("Member Not Found!!");
            return;
        }
        List<String> memBooks = memToBook.get(id);
        if(CommonUtil.checkIsNullOrEmpty(memBooks)) {
            System.out.println("Member didn't get books!!");
            return;
        }
        System.out.println("Books got by the Member: ");
        for(int i=0;i<memBooks.size();i++) {
            System.out.format("%d. %s\n", i+1, books.get(memBooks.get(i)).getName());
        }
    }

}
