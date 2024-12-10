import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

class Student
 {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course)
  {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and setters
    public int getId()
    {
	 return id;
    }
    public void setId(int id)
   {
	 this.id = id; 
    }
    public String getName()
    {

	 return name; 
    }
    public void setName(String name) 
    { 
	this.name = name; 
    }
    public int getAge() 
    { 
	return age;
     }
    public void setAge(int age)
    { 
	this.age = age;
    }
    public String getCourse() 
    {
	 return course; 
     }
    public void setCourse(String course) 
    { 
	this.course = course;
     }



    @Override
    public String toString()
   {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }
}

public class V218027 
{
    private Vector<Student> students = new Vector<>();

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // View all students
    public void viewStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search for a student by ID
    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    // Update a student details
    public void updateStudent(int id, String newName, int newAge, String newCourse) {
        Student student = searchStudentById(id);
        if (student != null) {
            student.setName(newName);
            student.setAge(newAge);
            student.setCourse(newCourse);
        }
    }

    // Validate ID
    private static boolean isValidId(int id) {
        return id > 0;
    }

    // Validate Name
    private static boolean isValidName(String name) {
        return name != null && name.length() > 0 && Pattern.matches("[a-zA-Z ]+", name);
    }

    // Validate Age
    private static boolean isValidAge(int age) {
        return age > 0 && age <= 120; // Assuming valid age range from 1 to 120
    }

    // Validate Course
    private static boolean isValidCourse(String course) {
        return course != null && course.length() > 0;
    }

    public static void main(String[] args) {
        V218027 sms = new V218027();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (!isValidId(id)) {
                        System.out.println("Invalid ID. Please enter a positive integer.");
                        break;
                    }
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    if (!isValidName(name)) {
                        System.out.println("Invalid Name. Please enter a valid name with letters and spaces only.");
                        break;
                    }
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    if (!isValidAge(age)) {
                        System.out.println("Invalid Age. Please enter a valid age between 1 and 120.");
                        break;
                    }
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    if (!isValidCourse(course)) {
                        System.out.println("Invalid Course. Please enter a non-empty course name.");
                        break;
                    }
                    sms.addStudent(new Student(id, name, age, course));
                    break;
                case 2:
                    sms.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    Student student = sms.searchStudentById(id);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    if (!isValidId(id)) {
                        System.out.println("Invalid ID. Please enter a positive integer.");
                        break;
                    }
                    sms.deleteStudent(id);
                    break;
                case 5:
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    if (!isValidId(id)) {
                        System.out.println("Invalid ID. Please enter a positive integer.");
                        break;
                    }
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    if (!isValidName(name)) {
                        System.out.println("Invalid Name. Please enter a valid name with letters and spaces only.");
                        break;
                    }
                    System.out.print("Enter New Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                    if (!isValidAge(age)) {
                        System.out.println("Invalid Age. Please enter a valid age between 1 and 120.");
                        break;
                    }
                    System.out.print("Enter New Course: ");
                    course = scanner.nextLine();
                    if (!isValidCourse(course)) {
                        System.out.println("Invalid Course. Please enter a non-empty course name.");
                        break;
                    }
                    sms.updateStudent(id, name, age, course);
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        }
    }
}
