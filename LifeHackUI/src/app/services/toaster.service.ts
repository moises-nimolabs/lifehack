import {BehaviorSubject, Observable} from 'rxjs';
import {filter} from 'rxjs/operators';
import {Toast} from '../models/toast';
import {ToastType} from '../models/toast.type';
import {Injectable} from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class ToasterService {
  subject: BehaviorSubject<Toast>;
  toast$: Observable<Toast>;

  constructor() {
    this.subject = new BehaviorSubject<Toast>(null);
    this.toast$ = this.subject.asObservable()
      .pipe(filter(toast => toast !== null));
  }

  show(type: ToastType, title?: string, body?: string, delay?: number): void {
    this.subject.next({type, title, body, delay});
  }
}
