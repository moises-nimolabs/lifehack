import {Component, OnInit} from '@angular/core';
import {Toast} from '../models/toast';
import {ToasterService} from '../services/toaster.service';

@Component({
  selector: 'app-toaster-container',
  templateUrl: './toaster-container.component.html',
  styleUrls: ['./toaster-container.component.css']
})
export class ToasterContainerComponent implements OnInit {
  toasts: Toast[] = [];
  toaster: ToasterService;
  constructor(private toasterService: ToasterService) {
    this.toaster = toasterService;
  }

  ngOnInit(): void {
    this.toaster.toast$
      .subscribe(toast => {
        this.toasts = [toast, ...this.toasts];
        setTimeout(() => this.toasts.pop(), toast.delay || 6000);
      });
  }

  remove(index: number): void {
    this.toasts = this.toasts.filter((v, i) => i !== index);
  }
}
