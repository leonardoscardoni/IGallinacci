import { Component, ElementRef, ViewChild } from '@angular/core';
import { ApiService } from '../../api.service';
import { TypeHome } from '../../_models/homeApi.type';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent {
  b=[
    {
      name:'golden state warrior'
    },
    {
      name:'los angeles lakers'
    },
    {
      name:'miami heat'
    },
    {
      name:'chicago bulls'
    },
    {
      name:'Toronto Raptors'
    },
    {
      name:'boston celtics'
    },
  ]

  @ViewChild('carouselContent') carouselContent!: ElementRef;

scrollAmount = 450; // Regola la quantità di scorrimento

scroll(direction: number) {
  const currentScrollLeft = this.carouselContent.nativeElement.scrollLeft;
  const newScrollLeft = currentScrollLeft + direction * this.scrollAmount;
  this.carouselContent.nativeElement.scrollTo({
    left: newScrollLeft,
    behavior: 'smooth'
  });
}
constructor(private apiService: ApiService) {}
data: TypeHome = {} as TypeHome

ngOnInit() {
  this.apiService.getHomeApi().subscribe((data:TypeHome) => {
    this.data = data;
    console.log(this.data)
  });
}
}
