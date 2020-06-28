import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Goal} from './models/goal';
import { environment } from './../environments/environment';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'LifeHackUI';
  public list;

  constructor(private http: HttpClient) {  }

  ngOnInit(): void {
    this.http.get<Goal>(`${environment.apiEndpoint}/goals`)
      .subscribe((data: Goal) => {
        console.log(data);
        this.list = [data];
      });
  }
}
