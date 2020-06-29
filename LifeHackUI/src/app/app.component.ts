import {Component, IterableDiffers, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from './../environments/environment';
import {Goal} from './models/goal';
import {PersonGoals} from './models/person.goals';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  personGoals: PersonGoals = {
    person: {
      name: '',
      goals: []
    },
    availableGoals: []
  };

  constructor(private http: HttpClient) { }

  addObserver(item: Goal): void {
    item.canExpand = () => {
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.personGoals.person.goals.length; i++) {
        if (item.id === this.personGoals.person.goals[i].id) {
          return false;
        }
        if (item.sequence === this.personGoals.person.goals[i].sequence) {
          return false;
        }
      }
      this.personGoals.person.goals.push(item);
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
        this.personGoals.availableGoals = [data];
        this.personGoals.availableGoals.forEach((item) => {
          this.addObserver(item);
        });
      });
  }
}
