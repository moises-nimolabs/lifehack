import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {TreeviewComponent} from './treeview/treeview.component';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {PersonComponent} from './person/person.component';
import {ToasterComponent} from './toaster/toaster.component';
import {ToasterContainerComponent} from './toaster-container/toaster-container.component';
import {DiagramPageComponent} from './diagram-page/diagram-page.component';
import {DiagramModule} from './diagram-page/diagram.module';
import {DiagramRoutingModule} from './diagram-page/diagram-routing.module';
import {RouterModule} from '@angular/router';
import {HomeModule} from './home-page/home.module';
import {HomeRoutingModule} from './home-page/home-routing.module';
import {HomePageComponent} from './home-page/home-page.component';

@NgModule({
  declarations: [
    AppComponent, TreeviewComponent, PersonComponent, ToasterContainerComponent, ToasterComponent, DiagramPageComponent, HomePageComponent
  ],
  imports: [
    HomeModule,
    HomeRoutingModule,
    DiagramModule,
    DiagramRoutingModule,
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'home', redirectTo: '/home', pathMatch: 'full'},
      {path: 'diagram', redirectTo: '/diagram', pathMatch: 'full'}
    ], {useHash: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
