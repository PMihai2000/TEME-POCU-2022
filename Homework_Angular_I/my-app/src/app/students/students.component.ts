import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { studentsMocks, nameList } from 'src/assets/student-mock';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css'],
})
export class StudentsComponent implements OnInit {
  titlePassedStudents: string = 'Passed students';
  titleRejectedStudents: string = 'Rejected students';
  passedStudentsList: Student[] = [];
  rejectedStudentsList: Student[] = [];

  constructor() {}

  ngOnInit(): void {
    this.passedStudentsList = studentsMocks.filter(
      (student) => student.gradeAvg >= 5
    );
    this.rejectedStudentsList = studentsMocks.filter(
      (student) => student.gradeAvg < 5
    );
  }

  //// Functie utilizata pentru varianta fara list-component
  // addStudent() {
  //   const newStudent: Student = {
  //     lastname: nameList[Math.floor(nameList.length * Math.random())],
  //     firstname: nameList[Math.floor(nameList.length * Math.random())],
  //     gradeAvg: ((Math.random() * 10) % 9) + 1,
  //   };

  //   if (newStudent.gradeAvg >= 5.0) {
  //     this.passedStudentsList.push(newStudent);
  //   } else {
  //     this.rejectedStudentsList.push(newStudent);
  //   }
  // }
  addPassedStudent() {
    const newStudent: Student = {
      lastname: nameList[Math.floor(nameList.length * Math.random())],
      firstname: nameList[Math.floor(nameList.length * Math.random())],
      gradeAvg: ((Math.random() * 10) % 4) + 6,
    };
    this.passedStudentsList.push(newStudent);
  }

  addRejectedStudent() {
    const newStudent: Student = {
      lastname: nameList[Math.floor(nameList.length * Math.random())],
      firstname: nameList[Math.floor(nameList.length * Math.random())],
      gradeAvg: ((Math.random() * 10) % 4) + 0.9,
    };
    this.rejectedStudentsList.push(newStudent);
  }
}
