import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-garden-list',
  templateUrl: './garden-list.component.html'
})
export class GardenListComponent implements OnInit {

  gardens=[
    {id:0, name:"garden 1"},
    {id:1, name:"garden 2"},
    {id:2, name:"garden 3"},
  ]

  gardenId: string;
  garden: any;

  constructor(
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.gardenId = params.get('gardenId');
      this.garden = this.gardens[this.gardenId];
    });
  }

  //onSelect(hero: Garden): void {
  //  this.selectedHero = hero;
  //}
  
}
