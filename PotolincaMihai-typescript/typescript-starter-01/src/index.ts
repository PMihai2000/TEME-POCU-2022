import "./styles.css";
import {Student} from "./student";
class CatalogApp {
  button: HTMLElement = document.getElementById(`add-button`) as HTMLElement;
  inputNume: HTMLInputElement = document.getElementById(`input-nume`) as HTMLInputElement;
  inputPrenume: HTMLInputElement = document.getElementById(`input-prenume`) as HTMLInputElement;
  inputNota: HTMLInputElement = document.getElementById("input-nota") as HTMLInputElement;
  studentsList: HTMLElement = document.getElementById(`list-students`) as HTMLElement;
  studentsPromoted: HTMLTableElement = document.getElementById(
    `table-students-promoted`
  ) as HTMLTableElement;
  studentsUnpromoted: HTMLTableElement = document.getElementById(
    `table-students-unpromoted`
  ) as HTMLTableElement;
  students: Student[] = [];

  constructor() {
    this.renderStudents();

    this.button.onclick = () => {
      if (
        this.inputNume.value != `` &&
        this.inputPrenume.value != `` &&
        this.inputNota.valueAsNumber >= 1 &&
        this.inputNota.valueAsNumber <= 10
      ) {
        const newStudent: Student = {
          nume: this.inputNume.value,
          prenume: this.inputPrenume.value,
          nota: this.inputNota.valueAsNumber,
        };
        this.addStudent(newStudent);
      }
    };
  }

  clearListAndInputs(): void {
    this.inputNume.value = ``;
    this.inputPrenume.value = ``;
    this.inputNota.value = ``;
    this.studentsList.innerHTML = ``;
    this.studentsPromoted.innerHTML = `<thead>
    <tr>
      <th colspan="3">Studenti promovati</th>
    </tr>
    <tr>
      <th>Nume</th>
      <th>Prenume</th>
      <th>Nota</th>
    </tr>
  </thead>`;
    this.studentsUnpromoted.innerHTML = `<thead>
  <tr>
    <th colspan="3">Studenti restantieri</th>
  </tr>
  <tr>
    <th>Nume</th>
    <th>Prenume</th>
    <th>Nota</th>
  </tr>
</thead>`;
  }

  renderStudents(): void {
    this.clearListAndInputs();

    for (let i = 0; i < this.students.length; i++) {
      const text: string = `${this.students[i].nume} ${this.students[i].prenume} ${this.students[i].nota}`;
      const li: HTMLLIElement = document.createElement(`li`) as HTMLLIElement;
      const tr: HTMLTableRowElement = document.createElement(`tr`) as HTMLTableRowElement;
      tr.className = "tr-student-info";
      tr.innerHTML = `<td>${this.students[i].nume}</td><td>${this.students[i].prenume}</td><td>${this.students[i].nota}</td>`;

      if (this.students[i].nota < 5) {
        this.studentsUnpromoted.appendChild(tr);
      } else {
        this.studentsPromoted.appendChild(tr);
      }

      li.innerText = text;
      this.studentsList.appendChild(li);
    }
  }

  addStudent(student: Student) {
    this.students.push(student);
    this.renderStudents();
  }
}

const app = new CatalogApp();
