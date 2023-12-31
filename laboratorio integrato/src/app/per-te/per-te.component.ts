import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-per-te',
  templateUrl: './per-te.component.html',
  styleUrls: ['./per-te.component.scss']
})
export class PerTeComponent {

  a = [
    {
      id: 0,
      match: {
        date: '2023-01-01',
        location: 'Stadium A',
        squadra1: {
          name: 'Lakers',
          point: 103,
        },
        squadra2: {
          name: 'Bulls',
          point: 95,
        }
      }
    },
    {
      id: 1,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'celtic',
          point: 102
        },
        squadra2: {
          name: 'raptor',
          point: 140
        }
      }
    },
    {
      id: 2,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'altro',
          point: 75
        },
        squadra2: {
          name: 'qualcosa',
          point: 121
        }
      }
    },
    {
      id: 3,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'altro',
          point: 175
        },
        squadra2: {
          name: 'qualcosa',
          point: 173
        }
      }
    },
    {
      id: 4,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'altro',
          point: 20
        },
        squadra2: {
          name: 'qualcosa',
          point: 57
        }
      }
    },
  ];


  
  getBackgroundColor(point1: number, point2: number): string {
    return point1 > point2 ? ' ' : 'opacity-[40%]';
}

@ViewChild('carouselContent') carouselContent!: ElementRef;

scrollAmount = 200; // Regola la quantità di scorrimento

scroll(direction: number) {
  const currentScrollLeft = this.carouselContent.nativeElement.scrollLeft;
  const newScrollLeft = currentScrollLeft + direction * this.scrollAmount;
  this.carouselContent.nativeElement.scrollTo({
    left: newScrollLeft,
    behavior: 'smooth'
  });
}



}
