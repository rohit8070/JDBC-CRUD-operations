package com.mycompany.myapp.main;

import java.util.Scanner;
import com.mycompany.myapp.employee.Student;
import com.mycompany.myapp.employeedao.StudentDao;

public class mainapp {

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n Student Management...");
			System.out.println("1 = create 2 = read 3 = delete 4 update gmail");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			if (choice > 4 || choice < 0) {
				break;
			}
			switch (choice) {
			case 1:
				System.out.println("Enter rollno, Enter name, Enter password, Enter gamil ");
				int rollno = sc.nextInt();
				sc.nextLine();
				String name = sc.nextLine();
				String password = sc.nextLine();
				String email = sc.nextLine();

				Student student = new Student(rollno, name, password, email);
				StudentDao.createStudent(student);
				
				break;
			case 2:
				StudentDao.showAllStudent();
				break;
			case 3:
				System.out.println("Enter roll no to delete record");
				rollno = sc.nextInt();
				StudentDao.deleteRecord(rollno);
				break;
			case 4:
				System.out.println("Enter roll no to update email");
				rollno = sc.nextInt();
				System.out.println("Enter new email id ");
				String newEmail = sc.next();
				StudentDao.updateEmail(rollno, newEmail);
				break;
			}
		}

	}

}
