import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GardenRoutingModule } from './garden.routing.module';
import { GardenListComponent } from './page/garden-list/garden-list.component';

@NgModule({
    imports: [
      CommonModule,
      GardenRoutingModule
    ],
    declarations: [ 
      GardenListComponent
    ],
    providers: [],
  })
export class GardenModule { }