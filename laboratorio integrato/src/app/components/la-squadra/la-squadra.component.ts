import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-la-squadra',
  templateUrl: './la-squadra.component.html',
  styleUrls: ['./la-squadra.component.scss']
})
export class LaSquadraComponent {
  @Input() data: any[] = [];

  numeroElementiDaVisualizzare = 3;
  slicedPlayers: any[] =[];

  ngOnInit() {
    this.aggiornaSlicedPlayers();
  }

  mostraAltri() {
    this.numeroElementiDaVisualizzare += 3;
    this.aggiornaSlicedPlayers();
  }
  nascondi() {
    this.numeroElementiDaVisualizzare = 3;
    this.aggiornaSlicedPlayers();
  }
  aggiornaSlicedPlayers() {
    if (this.data && this.data.length > 0 && this.data[0].players) {
      this.slicedPlayers = this.data[0].players.slice(0, this.numeroElementiDaVisualizzare);
    } else {
      this.slicedPlayers = [];
    }
  }

  
}
