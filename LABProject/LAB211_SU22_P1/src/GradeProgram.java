
import data.StudentManager;
import java.util.Scanner;

public class GradeProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu mainMnu = new Menu();
        mainMnu.add("Add new Student");
        mainMnu.add("Update Student");
        mainMnu.add("Add new Subject");
        mainMnu.add("Update Subject");
        mainMnu.add("Enter Grade");
        mainMnu.add("Student Grade Report");
        mainMnu.add("Subject Grade Report");
        Menu stMnu = new Menu();
        stMnu.add("Update Student");
        stMnu.add("Delete Student");
        Menu subMnu = new Menu();
        subMnu.add("Update Subject");
        subMnu.add("Delete Subject");
        StudentManager mng = new StudentManager();
        int choice1, choice2;
        do {
            try {
                System.out.println("\n----------STUDENT MANAGEMENT----------");
                choice1 = mainMnu.getChoice();
                switch (choice1) {
                    case 1:
                        int choose1;
                        do {
                            mng.addStudent();
                            try {
                                System.out.print("\nDo you want to continue? (1-Yes/0-No): ");
                                choose1 = sc.nextInt();
                            } catch (Exception e) {
                                choose1 = 0;
                            }
                        } while (choose1 == 1);
                        break;
                    case 2:
                        int choose2;
                        do {
                            choice2 = stMnu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.updateStudent();
                                    break;
                                case 2:
                                    mng.deleteStudent();
                                    break;
                                default:
                                    break;
                            }
                            try {
                                System.out.print("\nDo you want to continue? (1-Yes/0-No): ");
                                choose2 = sc.nextInt();
                            } catch (Exception e) {
                                choose2 = 0;
                            }
                        } while (choose2 == 1);
                        break;
                    case 3:
                        int choose3;
                        do {
                            mng.addSubject();
                            try {
                                System.out.print("\nDo you want to continue? (1-Yes/0-No): ");
                                choose3 = sc.nextInt();
                            } catch (Exception e) {
                                choose3 = 0;
                            }
                        } while (choose3 == 1);
                        break;
                    case 4:
                        int choose4;
                        do {
                            choice2 = subMnu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.updateSubject();
                                    break;
                                case 2:
                                    mng.deleteSubject();
                                    break;
                                default:
                                    break;
                            }
                            try {
                                System.out.print("\nDo you want to continue? (1-Yes/0-No): ");
                                choose4 = sc.nextInt();
                            } catch (Exception e) {
                                choose4 = 0;
                            }
                        } while (choose4 == 1);
                        break;
                    case 5:
                        int choose5;
                        do {
                            mng.addGrade();
                            try {
                                System.out.print("\nDo you want to continue? (1-Yes/0-No): ");
                                choose5 = sc.nextInt();
                            } catch (Exception e) {
                                choose5 = 0;
                            }
                        } while (choose5 == 1);
                        break;
                    case 6:
                        int choose6;
                        do {
                            mng.reportStudent();
                            try {
                                System.out.print("\nDo you want to continue? (1-Yes/0-No): ");
                                choose6 = sc.nextInt();
                            } catch (Exception e) {
                                choose6 = 0;
                            }
                        } while (choose6 == 1);
                        break;
                    case 7:
                        int choose7;
                        do {
                            mng.reportSubject();
                            try {
                                System.out.print("\nDo you want to continue? (1-Yes/0-No): ");
                                choose7 = sc.nextInt();
                            } catch (Exception e) {
                                choose7 = 0;
                            }
                        } while (choose7 == 1);
                        break;
                    default:
                        System.out.println("Goodbye!");
                }
            } catch (Exception e) {
                choice1 = 0;
                System.out.println("Error! Please run the program again!");
            }
        } while (choice1 > 0 && choice1 <= mainMnu.size());
    }
}
