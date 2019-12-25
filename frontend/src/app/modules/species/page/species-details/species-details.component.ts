import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-species-details',
  templateUrl: './species-details.component.html'
})
export class SpeciesDetailsComponent implements OnInit {

  speciesId: string;

  constructor(
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.speciesId = params.get('speciesId');
    });
  }

}
