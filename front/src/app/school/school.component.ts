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
    directory: 'fzefzf'
  };

  response = {
    secretHash: '',
    name: ''
  };

  answered = false;

  constructor(private api: ApiService) { }

  ngOnInit() {
  }

  addSchool() {
    this.api.post<any>('schools/add', this.school).subscribe(data => {
      this.response = data;
      this.answered = true;
    }, error => {
      console.warn(error);
    });
  }

}
