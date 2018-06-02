import { Component, OnInit } from '@angular/core';
import {ApiService} from '../services/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  form = {
    email: '',
    password: ''
  };

  constructor(private api: ApiService) { }

  ngOnInit() {
  }


  login() {
    this.api.post<any>('login', this.form).subscribe(data => {
      console.log(data);
    });
  }

}
