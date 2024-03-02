import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.next();

        System.out.print("Enter your last name: ");
        String lastName = scanner.next();

        EmailBackProgram email = new EmailBackProgram(firstName, lastName);
        System.out.println(email.showInfo());
    }
}

class EmailBackProgram {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "xyzemail.com";

    public EmailBackProgram(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

        this.email = constructEmail();
        this.alternateEmail = generateAlternateEmails();
    }

    private String setDepartment() {
        System.out.print(
                "Welcome!! " + firstname + "." + " You are Our New Employee." + " \nChoose Department Codes\n1 Software Development\n2 Artificial Intelligence\n3 Cybersecurity\n4 Data Science\n5 UX/UI Design\n6 Cloud Computing\n7 Robotics\n0 None\nEnter Department Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        switch (depChoice) {
            case 1:
                return "Software Development";
            case 2:
                return "Artificial Intelligence";
            case 3:
                return "Cybersecurity";
            case 4:
                return "Data Science";
            case 5:
                return "UX/UI Design";
            case 6:
                return "Cloud Computing";
            case 7:
                return "Robotics";
            default:
                return "None";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*^";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    private String constructEmail() {
        String departmentPart = department.isEmpty() ? "" : department.toLowerCase().replace(" ", "") + ".";
        return firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + departmentPart + companySuffix;
    }

    private String generateAlternateEmails() {
        String[] suggestions = new String[3];
        for (int i = 0; i < 3; i++) {
            suggestions[i] = firstname.toLowerCase() + "." + lastname.toLowerCase() + i + "@" + department.toLowerCase().replace(" ", "") + "." + companySuffix;
        }
        return String.join("\n", suggestions);
    }

    private String generateAlternatePasswords() {
        String[] suggestions = new String[3];
        for (int i = 0; i < 3; i++) {
            suggestions[i] = randomPassword(defaultPasswordLength);
        }
        return String.join("\n", suggestions);
    }

    public String showInfo() {
        return "Display Name: " + firstname + " " + lastname +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb" +
                "\nAlternate Email Suggestions:\n" + alternateEmail +
                "\nAlternate Password Suggestions:\n" + generateAlternatePasswords();
    }
}