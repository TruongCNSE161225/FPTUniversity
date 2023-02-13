
import data.HospitalMng;
import java.util.Scanner;

public class MngProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu mainMnu = new Menu();
        mainMnu.add("Show information");
        mainMnu.add("Add new");
        mainMnu.add("Update information");
        mainMnu.add("Delete");
        mainMnu.add("Search information");
        mainMnu.add("Store data to file");
        mainMnu.add("Record medical examination");

        Menu showMenu = new Menu();
        showMenu.add("Show doctor list");
        showMenu.add("Show department list");

        Menu addMenu = new Menu();
        addMenu.add("Add new doctor");
        addMenu.add("Add new department");
        addMenu.add("Add new patient");

        Menu upMenu = new Menu();
        upMenu.add("Update doctor");
        upMenu.add("Update department");

        Menu deMenu = new Menu();
        deMenu.add("Delete doctor");
        deMenu.add("Delete department");

        Menu searchMenu = new Menu();
        searchMenu.add("Search doctor by name");
        searchMenu.add("Search department by ID");

        Menu storeMenu = new Menu();
        storeMenu.add("Store list doctor to doctor.dat file");
        storeMenu.add("Store list department to department.dat file");

        HospitalMng mng = new HospitalMng();

        int choice1, choice2;
        do {
            try {
                System.out.println("\n----------HOSPITAL MANAGEMENT----------");
                choice1 = mainMnu.getChoice();
                switch (choice1) {
                    case 1:
                        int choose1;
                        do {
                            System.out.println("\n----------SHOW INFORMATION----------");
                            choice2 = showMenu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.showDoctorList();
                                    break;
                                case 2:
                                    mng.showDepList();
                                    break;
                                default:
                                    break;
                            }
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
                            System.out.println("\n----------ADD NEW----------");
                            choice2 = addMenu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.addDoctor();
                                    break;
                                case 2:
                                    mng.addDepartment();
                                    break;
                                case 3:
                                    mng.addPatient();
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
                            System.out.println("\n----------UPDATE INFORMATION----------");
                            choice2 = upMenu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.updateDoctor();
                                    break;
                                case 2:
                                    mng.updateDepartment();
                                    break;
                                default:
                                    break;
                            }
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
                            System.out.println("\n----------DELETE----------");
                            choice2 = deMenu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.deleteDoctor();
                                    break;
                                case 2:
                                    mng.deleteDepartment();
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
                            System.out.println("\n----------SEARCH INFORMATION----------");
                            choice2 = searchMenu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.searchDoctor();
                                    break;
                                case 2:
                                    mng.searchDepartment();
                                    break;
                                default:
                                    break;
                            }
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
                            System.out.println("\n----------STORE DATA TO FILE----------");
                            choice2 = storeMenu.getChoice();
                            switch (choice2) {
                                case 1:
                                    mng.storeDoctorListToFile();
                                    break;
                                case 2:
                                    mng.storeDepListToFile();
                                    break;
                                default:
                                    break;
                            }
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
                            System.out.println("\n----------RECORD MEDICAL EXAMINATION----------");
                            mng.RecordMedical();
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
