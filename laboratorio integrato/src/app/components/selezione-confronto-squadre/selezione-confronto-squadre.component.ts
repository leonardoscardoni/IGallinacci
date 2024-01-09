import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-selezione-confronto-squadre',
  templateUrl: './selezione-confronto-squadre.component.html',
  styleUrls: ['./selezione-confronto-squadre.component.scss']
})
export class SelezioneConfrontoSquadreComponent {
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
}
