import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { addDays, subDays, format } from 'date-fns';
import { CalendarType } from 'src/app/_models/calendarApi.type';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-calendario-partite',
  templateUrl: './calendario-partite.component.html',
  styleUrls: ['./calendario-partite.component.scss']
})
export class CalendarioPartiteComponent implements AfterViewInit {
  today: Date = new Date();
  startDate: Date = subDays(this.today, 10);
  endDate: Date = addDays(this.today, 10);
  data: CalendarType = {} as CalendarType
  selectedDate: Date | null = null;

  daysOfWeek: string[] = ['Dom', 'Lun', 'Mar', 'Mer', 'Gio', 'Ven', 'Sab'];

  @ViewChild('carouselContent', { static: false })
  carouselContent!: ElementRef;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.selectedDate = this.today;
    this.fetchData(this.today);
  }

  ngAfterViewInit() {
    // Imposta la posizione di scorrimento
    const element: HTMLElement = this.carouselContent.nativeElement;
    const halfVisibleWidth = element.offsetWidth / 2.2;
    const desiredScrollPosition = element.scrollWidth / 2 - halfVisibleWidth;
    element.scrollLeft = desiredScrollPosition;
  }

  scrollAmount = 200;

  scroll(direction: number) {
    const currentScrollLeft = this.carouselContent.nativeElement.scrollLeft;
    const newScrollLeft = currentScrollLeft + direction * this.scrollAmount;
    this.carouselContent.nativeElement.scrollTo({
      left: newScrollLeft,
      behavior: 'smooth'
    });
  }

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

  formatTimeFromApiData(gameData: any): string {
    const apiTime = gameData.time;
    return format(new Date(`1970-01-01T${apiTime}`), 'HH:mm');
  }

  formatDate(date: Date): string {
    return format(date, 'MMM d, y');
  }

  formatDateApi(date: Date): string {
    return format(date, 'yyyy-MM-dd');
  }

  handleDateClick(clickedDate: Date): void {
    this.selectedDate = clickedDate;
    this.fetchData(clickedDate);
  }

  fetchData(date: Date): void {
    const formattedDate = this.formatDateApi(date);
    this.apiService.getCalendarApi(formattedDate).subscribe((data: CalendarType) => {
      this.data = data;
      console.log(this.data);
    });
  }
}
