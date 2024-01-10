import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-dati-principali',
  templateUrl: './dati-principali.component.html',
  styleUrls: ['./dati-principali.component.scss']
})
export class DatiPrincipaliComponent {
  @Input() title: string = '';
  @Input() dato: any;
  @Input() percentuale: string = '';
}
