import { Component, Input } from '@angular/core';
import { TeamDetailType } from 'src/app/_models/TeamDetailApi.type';

@Component({
  selector: 'app-posizione-in-classifica',
  templateUrl: './posizione-in-classifica.component.html',
  styleUrls: ['./posizione-in-classifica.component.scss']
})
export class PosizioneInClassificaComponent {
  @Input() data: TeamDetailType = {} as TeamDetailType

 
}
