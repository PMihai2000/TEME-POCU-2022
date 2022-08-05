import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';
import { Student } from '../model/student';
import { nameList } from 'src/assets/student-mock';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  @Input() titleList: string = ``;
  @Input() data: Student[] = [];
  @Output() generate = new EventEmitter<string>();

  constructor() {}

  ngOnInit(): void {}

  addStudent() {
    this.generate.emit(this.titleList);
  }
}
