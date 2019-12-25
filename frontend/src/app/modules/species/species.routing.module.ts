import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SpeciesListComponent } from './page/species-list/species-list.component';
import { SpeciesDetailsComponent } from './page/species-details/species-details.component';


const routes: Routes = [
    { path: 'species', component: SpeciesListComponent },
    { path: 'species/:speciesId', component: SpeciesDetailsComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class SpeciesRoutingModule { }