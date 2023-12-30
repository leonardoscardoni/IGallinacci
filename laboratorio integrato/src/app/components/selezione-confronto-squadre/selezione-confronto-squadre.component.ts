import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-selezione-confronto-squadre',
  templateUrl: './selezione-confronto-squadre.component.html',
  styleUrls: ['./selezione-confronto-squadre.component.scss']
})
export class SelezioneConfrontoSquadreComponent {
  @Input() data: any;
  searchInput: string = ''; // Cambiato in searchInput

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

  // Metodo per gestire l'input dell'utente
  onSearchInputChange(): void {
    // Puoi aggiungere ulteriori logiche qui se necessario
    // ad esempio, puoi convertire tutto in maiuscolo per una corrispondenza case-insensitive
    this.searchInput = this.searchInput.toUpperCase();
  }

  // Nuovo metodo per resettare la sequenza di lettere
  resetSearchInput(): void {
    this.searchInput = '';
  }
}
