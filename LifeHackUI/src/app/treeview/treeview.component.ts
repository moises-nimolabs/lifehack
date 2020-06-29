import {Component, OnInit, Input} from '@angular/core';
import {Goal} from '../models/goal';

@Component({
  selector: 'app-treeview',
  templateUrl: './treeview.component.html',
  styleUrls: ['./treeview.component.css']
})
export class TreeviewComponent implements OnInit {
  @Input() goals: Goal[];

  ngOnInit(): void {
  }

  onClick(item: Goal): void {
    if (item.canExpand && item.canExpand()) {
      if (item.expanded) {
        item.expanded = !item.expanded;
        return;
      } else {
        if (item.goals) {
          if (item.goals.length > 0) {
            item.expanded = true;
          } else {
            item.expanded = false;
          }
        }
      }
    }
  }
}
