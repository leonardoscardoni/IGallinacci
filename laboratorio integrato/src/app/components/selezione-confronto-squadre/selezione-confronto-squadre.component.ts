import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-selezione-confronto-squadre',
  templateUrl: './selezione-confronto-squadre.component.html',
  styleUrls: ['./selezione-confronto-squadre.component.scss']
})
export class SelezioneConfrontoSquadreComponent {
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

  selectTeam(team: { nome: string; immagine: string ; id:number }) {
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

  constructor(private router: Router) {}

  goToConfrontoTeam() {
    // Verifica che ci siano squadre selezionate
    if (this.selectedTeam1 && this.selectedTeam2) {
      // Naviga alla rotta con i parametri dinamici
      this.router.navigate(['/dettaglio-confronto-team', this.selectedTeam1.id, this.selectedTeam2.id]);
    } else {
      // Puoi gestire il caso in cui non ci siano squadre selezionate
      console.error('Seleziona entrambe le squadre prima di procedere.');
    }
  }
  
}
