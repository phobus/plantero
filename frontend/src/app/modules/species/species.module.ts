import { NgModule } from '@angular/core';
import { SpeciesRoutingModule } from './species.routing.module';
import { SpeciesDetailsComponent } from './page/species-details/species-details.component';
import { SpeciesListComponent } from './page/species-list/species-list.component';

@NgModule({
    imports: [
      SpeciesRoutingModule
    ],
    declarations: [ 
      SpeciesDetailsComponent,
      SpeciesListComponent
    ],
    providers: [],
  })
export class SpeciesModule { }