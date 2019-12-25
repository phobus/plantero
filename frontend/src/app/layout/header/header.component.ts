import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent implements OnInit {

  links=[
    { name:"Home", icon:"home", href:"home", exact:true  },
    { name:"Species", icon:"venus-mars", href:"species", exact:false },
    { name:"Garden", icon:"pencil-ruler", href:"garden", exact:false },
  ]
  
  constructor() { }

  ngOnInit() {
  }

}
