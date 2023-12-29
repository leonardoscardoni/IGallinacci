import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { TypeHome } from 'src/app/_models/homeApi.type';

@Component({
  selector: 'app-ultimi-risultati-home',
  templateUrl: './ultimi-risultati-home.component.html',
  styleUrls: ['./ultimi-risultati-home.component.scss']
})
export class UltimiRisultatiHomeComponent {
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


  @Input() data: TypeHome = {} as TypeHome;
  
  getBackgroundColor(point1: number | undefined, point2: number | undefined): string {
    // Imposta un valore predefinito di 0 se il valore è undefined
    const p1 = point1 ?? 0;
    const p2 = point2 ?? 0;
  
    // Ora puoi effettuare la comparazione senza problemi di tipi
    return p1 > p2 ? ' ' : 'opacity-[40%]';
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
