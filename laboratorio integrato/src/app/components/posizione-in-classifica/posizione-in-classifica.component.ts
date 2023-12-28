import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-posizione-in-classifica',
  templateUrl: './posizione-in-classifica.component.html',
  styleUrls: ['./posizione-in-classifica.component.scss']
})
export class PosizioneInClassificaComponent {
  @Input() data: any[] = [];
}
