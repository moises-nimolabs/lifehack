import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DiagramPageComponent} from './diagram-page.component';


const routes: Routes = [{
  path: 'diagram',
  component: DiagramPageComponent,
  data: {
    title: 'Diagram'
  }
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DiagramRoutingModule { }
