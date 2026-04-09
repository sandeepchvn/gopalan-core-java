package service;

import exception.StudentNotFoundException;
import model.Student;

public interface StudentService {

	void addStudent(Student student);

	void viewAllStudents();

	Student findStudentByID(int id) throws StudentNotFoundException;

	void updateStudentByID(int id) throws StudentNotFoundException;

	void deleteStudentByID(int id) throws StudentNotFoundException;
}
