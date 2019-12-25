import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GardenListComponent } from './page/garden-list/garden-list.component';


const routes: Routes = [
    { path: 'garden', component: GardenListComponent },
    { path: 'garden/:gardenId', component: GardenListComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class GardenRoutingModule { }