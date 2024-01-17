import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
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
  selectedTeam1: { nome: string; immagine: string; id:number } = {
    nome: '', immagine: '',
    id: 0
  };
  selectedTeam2: { nome: string; immagine: string; id:number } = {
    nome: '', immagine: '',
    id: 0
  };
  selectedPlus: string | null = null;
  plusNumber1 = 'plus1';
  plusNumber2 = 'plus2';

  openModal(plusNumber: string) {
    this.selectedPlus = plusNumber;
    this.isModalOpen = true;
  }

  selectTeam(team: { nome: string; immagine: string ; id:number}) {
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
  constructor(private router: Router,private apiService: ApiService) {}

  goToConfrontoTeam() {
    // Verifica che ci siano squadre selezionate
    if (this.selectedTeam1 && this.selectedTeam2) {
      // Naviga alla rotta con i parametri dinamici
      this.router.navigate(['/dett-confronto-giocatori', this.selectedTeam1.id, this.selectedTeam2.id]);
    } else {
      // Puoi gestire il caso in cui non ci siano squadre selezionate
      console.error('Seleziona entrambe le squadre prima di procedere.');
    }
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



data2: PlayerTeamFilteredType = {} as PlayerTeamFilteredType
  PlayerFilter(idTeam:number) {
      this.apiService.getPlayerFilter(idTeam).subscribe((data) => {
        this.data2 = data;
        console.log(this.data2)

      });
    }
}
