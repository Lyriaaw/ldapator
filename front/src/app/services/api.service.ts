import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ApiService {

  url = 'https://cors-anywhere.herokuapp.com/https://f34063cd.ngrok.io/';

  constructor(private http: HttpClient) { }

  get<T>(uri): Observable<T> {
    return this.http.get<T>(this.url + uri);
  }

  post<T>(uri, body): Observable<T> {
    return this.http.post<T>(this.url + uri, body);
  }

  put<T>(uri, body): Observable<T> {
    return this.http.put<T>(this.url + uri, body);
  }

  delete<T>(uri): Observable<T> {
    return this.http.delete<T>(this.url + uri);
  }

  test() {
    console.log('Hello ???');
  }

}
