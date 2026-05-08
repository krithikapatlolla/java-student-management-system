import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    
    static void saveToFile(ArrayList<Student> students) {

        try {

            FileWriter fw = new FileWriter("students.txt");

            for (Student s : students) {

                fw.write(s.id + "," + s.name + "," + s.marks + "\n");
            }

            fw.close();

        } catch (Exception e) {

            System.out.println("Error Saving File");
        }
    }


    static void loadFromFile(ArrayList<Student> students) {

        try {

            File file = new File("students.txt");

            if (!file.exists())
                return;

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int marks = Integer.parseInt(data[2]);

                students.add(new Student(id, name, marks));
            }

            fileScanner.close();

        } catch (Exception e) {

            System.out.println("Error Loading File");
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

     
        loadFromFile(students);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Search Student By Name");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                
                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    students.add(new Student(id, name, marks));

                    saveToFile(students);

                    System.out.println("Student Added Successfully!");

                    break;

                
                case 2:

                    if (students.isEmpty()) {

                        System.out.println("No Students Found!");
                    }

                    else {

                        for (Student s : students) {

                            s.display();
                        }
                    }

                    break;

                
                case 3:

                    System.out.print("Enter Student ID: ");

                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {

                        if (s.id == searchId) {

                            s.display();

                            found = true;
                        }
                    }

                    if (!found) {

                        System.out.println("Student Not Found!");
                    }

                    break;

                
                case 4:

                    System.out.print("Enter Student ID to Delete: ");

                    int deleteId = sc.nextInt();

                    boolean deleted = students.removeIf(s -> s.id == deleteId);

                    if (deleted) {

                        saveToFile(students);

                        System.out.println("Student Deleted Successfully!");
                    }

                    else {

                        System.out.println("Student Not Found!");
                    }

                    break;

                
                case 5:

                    System.out.print("Enter Student ID to Update: ");

                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Student s : students) {

                        if (s.id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextInt();

                            updated = true;

                            saveToFile(students);

                            System.out.println("Student Updated Successfully!");
                        }
                    }

                    if (!updated) {

                        System.out.println("Student Not Found!");
                    }

                    break;

                
                case 6:

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");

                    String searchName = sc.nextLine();

                    boolean foundName = false;

                    for (Student s : students) {

                        if (s.name.equalsIgnoreCase(searchName)) {

                            s.display();

                            foundName = true;
                        }
                    }

                    if (!foundName) {

                        System.out.println("Student Not Found!");
                    }

                    break;

                
                case 7:

                    System.out.println("Exiting Program...");

                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}