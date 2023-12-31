import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { addDays, subDays, format } from 'date-fns';
import { MatchDataService } from '../../match-data.service';
@Component({
  selector: 'app-calendario-partite',
  templateUrl: './calendario-partite.component.html',
  styleUrls: ['./calendario-partite.component.scss']
})
export class CalendarioPartiteComponent implements AfterViewInit {
  today: Date = new Date();
  startDate: Date = subDays(this.today, 10);
  endDate: Date = addDays(this.today, 10);

  daysOfWeek: string[] = ['Dom', 'Lun', 'Mar', 'Mer', 'Gio', 'Ven', 'Sab'];

  getDaysArray(startDate: Date, endDate: Date) {
    const daysArray = [];
    let currentDate = new Date(startDate);

    while (currentDate <= endDate) {
      daysArray.push({
        date: new Date(currentDate),
        dayOfWeek: this.daysOfWeek[currentDate.getDay()],
        dayOfMonth: currentDate.getDate(),
      });
      currentDate.setDate(currentDate.getDate() + 1);
    }

    return daysArray;
  }

  formatDate(date: Date): string {
    return format(date, 'MMM d, y');
  }
 
   formatDateApi(date: Date): string {
    return format(date, 'yyyy-MM-dd');
  }

  handleDateClick(clickedDate: Date): string {
    console.log(this.formatDateApi(clickedDate))  
    return this.formatDateApi(clickedDate)
  }

  a: any[] = [];

  constructor(private matchDataService: MatchDataService) {}

  ngOnInit() {
    this.a = this.matchDataService.getMatches();
  }


  @ViewChild('carouselContent', { static: false })
  carouselContent!: ElementRef;

  ngAfterViewInit() {
    // Ottieni l'elemento e calcola la posizione di scorrimento desiderata
    const element: HTMLElement = this.carouselContent.nativeElement;
    const halfVisibleWidth = element.offsetWidth / 2;
    const desiredScrollPosition = element.scrollWidth / 2 - halfVisibleWidth;
  
    // Imposta la posizione di scorrimento
    element.scrollLeft = desiredScrollPosition;
  }

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
