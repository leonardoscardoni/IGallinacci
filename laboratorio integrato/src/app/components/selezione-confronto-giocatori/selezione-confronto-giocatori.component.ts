import { Component, Input } from '@angular/core';
import { PlayerTeamFilteredType } from 'src/app/_models/PlayerTeamFilteredApi.type';
import { PlayerMatchType } from 'src/app/_models/playerMatchApi.type';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-selezione-confronto-giocatori',
  templateUrl: './selezione-confronto-giocatori.component.html',
  styleUrls: ['./selezione-confronto-giocatori.component.scss']
})
export class SelezioneConfrontoGiocatoriComponent {
  @Input() data: any;
  searchInput: string = '';

  isModalOpen = false;
  selectedTeam1: { nome: string; immagine: string } = { nome: '', immagine: '' };
  selectedTeam2: { nome: string; immagine: string } = { nome: '', immagine: '' };
  selectedPlus: string | null = null;
  plusNumber1 = 'plus1';
  plusNumber2 = 'plus2';

  openModal(plusNumber: string) {
    this.selectedPlus = plusNumber;
    this.isModalOpen = true;
  }

  selectTeam(team: { nome: string; immagine: string }) {
    if (this.selectedPlus === 'plus1') {
      this.selectedTeam1 = team;
    } else if (this.selectedPlus === 'plus2') {
      this.selectedTeam2 = team;
    }
    this.isModalOpen = false;
    this.selectedPlus = null;
  }

  closeModal() {
    this.isModalOpen = false;
    this.selectedPlus = null;
  }

  onSearchInputChange(): void {
    this.searchInput = this.searchInput.toUpperCase();
  }
  resetSearchInput(): void {
    this.searchInput = '';
  }

  a = {
    squadre: ["squadrettina", "squadrona"],
    ruoli: ["attaccante", "difensore"],
    giocatori: [
        {
            logoSquadra: "/assets/s-l1200.webp",
            nomeGiocatore: "Clara Cosentino",
            nomeSquadra: "squadrettina",
            ruolo: "attaccante",
            provenienza: "italia",
            preferiti: false,
        },
        {
            logoSquadra: "/assets/s-l1200.webp",
            nomeGiocatore: "Lisa Bertinotti",
            nomeSquadra: "squadrona",
            ruolo: "portiere",
            provenienza: "italia",
            preferiti: false,
        },
        {
            logoSquadra: "/assets/s-l1200.webp",
            nomeGiocatore: "Lisa aaaaaaaaaa",
            nomeSquadra: "squadrona",
            ruolo: "difensore",
            provenienza: "italia",
            preferiti: false,
        },
        {
            logoSquadra: "/assets/s-l1200.webp",
            nomeGiocatore: "Lisa Bertinotti",
            nomeSquadra: "squadrona",
            ruolo: "portiere",
            provenienza: "italia",
            preferiti: false,
        },
    ],
};

squadraSelezionata: any;
ruoloSelezionato: any;


ab() {
  console.log('Valore di a:', this.ruoloSelezionato);
  console.log('Valore di ruoloSelezionato:', this.squadraSelezionata);
}

constructor(private apiService: ApiService) {}

data2: PlayerTeamFilteredType = {} as PlayerTeamFilteredType
  ciaociao() {
      this.apiService.getPlayerFilter().subscribe((data) => {
        this.data2 = data;
        console.log(this.data2)

      });
    }
}
