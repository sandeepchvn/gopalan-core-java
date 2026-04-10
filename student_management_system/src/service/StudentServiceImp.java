package service;

import java.util.Scanner;

import exception.StudentCountExceededException;
import exception.StudentNotFoundException;
import model.Student;

public class StudentServiceImp implements StudentService {

	private Student[] students;
	private int count;

	public StudentServiceImp(int size) {
		students = new Student[size];
		count = 0;
	}

	@Override
	public void addStudent(Student student) {
		if (count == students.length) {
			throw new StudentCountExceededException("Storage Full Cannot add more students");
		}
		for (int i = 0; i < count; i++) {
			if (students[i].getId() == student.getId()) {
				throw new IllegalArgumentException("Student with id "+student.getId()+" is already exist");
			}
		}

		students[count++] = student;
		System.out.println("student added successfully");
	}

	@Override
	public void viewAllStudents() {

		if (count == 0) {
			System.out.println("no students records found");
		}

		for (int i = 0; i < count; i++) {
			System.out.println(students[i]);
		}

	}

	@Override
	public Student findStudentByID(int id) throws StudentNotFoundException {

		for (int i = 0; i < count; i++) {
			if (students[i].getId() == id) {
				return students[i];
			}
		}

		throw new StudentNotFoundException("student with id " + id + " not found");
	}

	@Override
	public void updateStudentByID(int id) throws StudentNotFoundException {
		Student student = findStudentByID(id);
		Scanner sc = new Scanner(System.in);

		sc.nextLine(); // clear buffer

		System.out.println("Enter Y to update name:");
		if ("y".equalsIgnoreCase(sc.nextLine())) {
			System.out.println("Enter new Name:");
			student.setName(sc.nextLine());
		}

		System.out.println("Enter Y to update age:");
		if ("y".equalsIgnoreCase(sc.nextLine())) {
			System.out.println("Enter new Age:");
			student.setAge(sc.nextInt());
			sc.nextLine(); // clear buffer
		}

		System.out.println("Enter Y to update course:");
		if ("y".equalsIgnoreCase(sc.nextLine())) {
			System.out.println("Enter new Course:");
			student.setCourse(sc.nextLine());
		}

		System.out.println("Enter Y to update marks:");
		if ("y".equalsIgnoreCase(sc.nextLine())) {
			System.out.println("Enter new Marks:");
			student.setMarks(sc.nextDouble());
			sc.nextLine(); // clear buffer
		}

		System.out.println(" Student updated successfully.");
	}

	@Override
	public void deleteStudentByID(int id) throws StudentNotFoundException {
		int index = -1;

		for (int i = 0; i < count; i++) {
			if (students[i].getId() == id) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			throw new StudentNotFoundException("Student not found with ID: " + id);
		} 

		for (int i = index; i < count - 1; i++) {
			students[i] = students[i + 1];
		}
		students[--count] = null;
		System.out.println("Student deleted successfully.");
	}
}
