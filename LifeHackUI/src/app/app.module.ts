import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {TreeviewComponent} from './treeview/treeview.component';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import { PersonComponent } from './person/person.component';

@NgModule({
  declarations: [
    AppComponent, TreeviewComponent, PersonComponent
  ],
    imports: [
        BrowserModule,
        CommonModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
