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

  logged = false;
  loading = false;

  user = {
    commonName: '',
    surName: ''
  };

  message = '';

  constructor(private api: ApiService) { }

  ngOnInit() {
  }


  login() {
    this.loading = true;
    this.api.post<any>('login', this.form).subscribe(data => {
      setTimeout(() => {
        this.user = data;
        this.logged = true;
        this.loading = false;
      });
    }, error => {
      console.warn('error');
      this.message = 'invalid credentials';
      this.loading = false;
    });
  }

}
