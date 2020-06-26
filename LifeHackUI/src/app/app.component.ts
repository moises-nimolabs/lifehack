import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LifeHackUI';
  public list = [
    {
      id: 16,
      "sequence": 1,
      "name": "What do you plan to do",
      "goals": [
        {
          id: 18,
          sequence: 2,
          name: "I'm going to the Gym",
          goals: [
            {
              id: 19,
              sequence: 3,
              name: "I want to be an Instructor",
              goals: [
                {
                  id: 23,
                  sequence: 4,
                  name: "Poor",
                  goals: null
                }
              ]
            },
            {
              id: 0,
              sequence: 3,
              name: "I want to be a Fighter",
              goals: [
                {
                  id: 22,
                  sequence: 4,
                  name: "I am Rich",
                  goals: null
                }
              ]
            }
          ]
        },
        {
          id: 17,
          sequence: 2,
          name: "I'm going to the School",
          goals: [
            {
              id: 20,
              sequence: 3,
              name: "I want to be Academic",
              goals: [
                {
                  id: 23,
                  sequence: 4,
                  name: "I am Poor",
                  goals: null
                }
              ]
            },
            {
              id: 21,
              sequence: null,
              name: "I want to be a professional",
              goals: [
                {
                  id: 22,
                  sequence: 4,
                  name: "I am Rich",
                  goals: null
                }
              ]
            }
          ]
        }
      ]
    }
  ];
}
