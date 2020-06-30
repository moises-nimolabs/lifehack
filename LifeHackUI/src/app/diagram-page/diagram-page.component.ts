import {Component, OnInit} from '@angular/core';
import {Goal} from '../models/goal';
import {environment} from '../../environments/environment';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-diagram-page',
  templateUrl: './diagram-page.component.html',
  styleUrls: ['./diagram-page.component.css']
})
export class DiagramPageComponent implements OnInit {
  goals: Goal[];

  constructor(private http: HttpClient) {
  }

  addObserver(item: Goal): void {
    item.canExpand = () => {
      return true;
    };

    if (item.goals) {
      item.goals.forEach((sub) => {
        this.addObserver(sub);
      });
    }
  }


  ngOnInit(): void {
    this.http.get<Goal>(`${environment.apiEndpoint}/goals`)
      .subscribe((data: Goal) => {
        this.goals = [data];
        this.goals.forEach((item) => {
          this.addObserver(item);
        });
      });
  }

}
