import { Component, Input, OnInit } from '@angular/core';
import { TeamDetailType } from 'src/app/_models/TeamDetailApi.type';

@Component({
  selector: 'app-la-squadra',
  templateUrl: './la-squadra.component.html',
  styleUrls: ['./la-squadra.component.scss']
})

export class LaSquadraComponent implements OnInit {
  @Input() data: TeamDetailType = {} as TeamDetailType

  numeroElementiDaVisualizzare = 3;

  ngOnInit() {
  }
  
  get slicedPlayers(): any[] {
    if (this.data.players && this.data.players.length > 0) {
      return this.data.players.slice(0, this.numeroElementiDaVisualizzare);
    } else {
      return [];
    }
  }

  mostraAltri() {
    this.numeroElementiDaVisualizzare = this.data.players.length;
  }

  nascondi() {
    this.numeroElementiDaVisualizzare = 3;
  }
}
