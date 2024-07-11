import java.util.Scanner;

class Person {
    String name;
    String gender;
    int age;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
    }
}

interface StudentInfo {
    void setStudent(String sid, String className);
    void displayStudent();
}

interface BookInfo {
    void setBook(String bid, String subject);
    void displayBook();
}

class Student extends Person implements StudentInfo {
    String sid;
    String className;
    String address;

    public Student(String name, String gender, int age, String address) {
        super(name, gender, age);
        this.address = address;
    }

    public void setStudent(String sid, String className) {
        this.sid = sid;
        this.className = className;
    }

    public void displayStudent() {
        super.show();
        System.out.println("Address: " + address);
        System.out.println("Student Id: " + sid);
        System.out.println("Class: " + className);
    }
}

class Book extends Person implements BookInfo {
    String bid;
    String subject;

    public Book(String name, String author, int genre) {
        super(name, author, genre);
    }

    public void setBook(String bid, String subject) {
        this.bid = bid;
        this.subject = subject;
    }

    public void displayBook() {
        super.show();
        System.out.println("Book Id: " + bid);
        System.out.println("Subject: " + subject);
    }
}

public class LibraryManagement {
    static final int MAX_COUNT = 50;
    static Student[] s = new Student[MAX_COUNT];
    static Book[] b = new Book[MAX_COUNT];
    static int scount, bcount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Library Management System");
            System.out.println();
            System.out.println("1. Add a Student ");
            System.out.println("2. Add a Book ");
            System.out.println("3. Show Student details ");
            System.out.println("4. Show Book details ");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    System.out.println();
                    break;
                case 2:
                    addBook();
                    System.out.println();
                    break;
                case 3:
                    showStudent();
                    System.out.println();
                    break;
                case 4:
                    showBook();
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void addStudent() {
        if (scount >= MAX_COUNT) {
            System.out.println("You cannot add more students");
            return;
        }

        System.out.println("Enter the student details: ");

        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter gender: ");
        String gender = sc.next();
        System.out.println("Enter address: ");
        String address = sc.next();
        System.out.println("Enter studentId: ");
        String sid = sc.next();
        System.out.println("Enter class: ");
        String className = sc.next();

        Student sobj = new Student(name, gender, age, address);
        sobj.setStudent(sid, className);
        s[scount++] = sobj;
        System.out.println("Student now added ");
        System.out.println();
    }

    public static void addBook() {
        if (bcount >= MAX_COUNT) {
            System.out.println("You cannot add more books");
            return;
        }

        System.out.println("Add Books here now ");

        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter author: ");
        String author = sc.next();
        System.out.println("Enter genre (as a number): ");
        int genre = sc.nextInt();
        System.out.println("Enter bookId: ");
        String bid = sc.next();
        System.out.println("Enter Subject: ");
        String subject = sc.next();

        Book bobj = new Book(name, author, genre);
        bobj.setBook(bid, subject);
        b[bcount++] = bobj;
        System.out.println("Book is now added");
        System.out.println();
    }

    public static void showStudent() {
        if (scount == 0) {
            System.out.println("No Students");
            return;
        }

        System.out.println("Student Details: ");
        System.out.println();
        for (int i = 0; i < scount; i++) {
            s[i].displayStudent();
            System.out.println();
        }
    }

    public static void showBook() {
        if (bcount == 0) {
            System.out.println("No Books");
            return;
        }

        System.out.println("Books Details: ");
        System.out.println();
        for (int i = 0; i < bcount; i++) {
            b[i].displayBook();
            System.out.println();
        }
    }
}