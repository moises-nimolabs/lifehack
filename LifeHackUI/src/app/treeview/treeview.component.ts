import { Component, OnInit, Input } from '@angular/core';

export class Item {
  id: number;
  name: string;
  goals: Item[];
}

@Component({
  selector: 'app-treeview',
  templateUrl: './treeview.component.html',
  styleUrls: ['./treeview.component.css']
})
export class TreeviewComponent implements OnInit {
  @Input() items: Item;
  ngOnInit() { }
  onExpand(item) {
    console.log('click');
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
