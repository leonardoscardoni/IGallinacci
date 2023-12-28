import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-dati-generali',
  templateUrl: './dati-generali.component.html',
  styleUrls: ['./dati-generali.component.scss'],
 
})
export class DatiGeneraliComponent {
  @Input() data: any[] = [];
  @Input() dati: any[] = [];
  @Input() titolo: string = '';
}
