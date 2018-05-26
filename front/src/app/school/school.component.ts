import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';
import {School} from '../entities/School';

@Component({
  selector: 'app-school',
  templateUrl: './school.component.html',
  styleUrls: ['./school.component.css']
})
export class SchoolComponent implements OnInit {

  school = {
    name: '',
    directory: ''
  };

  constructor(private api: ApiService) { }

  ngOnInit() {
  }

  addSchool() {
    this.api.post<School>('schools/add', this.school).subscribe(data => {
      console.log(data);
    }, error => {
      console.warn(error);
    });
  }

}
