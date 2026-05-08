class Student {

    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void calculateGrade() {

        if (marks >= 90)
            System.out.println("Grade: A");

        else if (marks >= 75)
            System.out.println("Grade: B");

        else if (marks >= 50)
            System.out.println("Grade: C");

        else
            System.out.println("Grade: Fail");
    }

    void display() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);

        calculateGrade();

        System.out.println("---------------------------");
    }
}