import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header-bg-titolo',
  templateUrl: './header-bg-titolo.component.html',
  styleUrls: ['./header-bg-titolo.component.scss']
})
export class HeaderBgTitoloComponent {
  @Input() data:any;

  isModalOpen = false;
  selectedTeam1: { nome: string; immagine: string } = { nome: '', immagine: '' };
  selectedTeam2: { nome: string; immagine: string } = { nome: '', immagine: '' };
  selectedPlus: string | null = null;
  plusNumber1 = 'plus1';
  plusNumber2 = 'plus2';

  openModal(plusNumber: string) {
    this.selectedPlus = plusNumber; // Memorizza quale "+" è stato cliccato
    this.isModalOpen = true;
  }

  selectTeam(team: { nome: string; immagine: string }) {
    if (this.selectedPlus === 'plus1') {
      this.selectedTeam1 = team;
    } else if (this.selectedPlus === 'plus2') {
      this.selectedTeam2 = team;
    }
    this.isModalOpen = false;
    this.selectedPlus = null; // Resetta selectedPlus dopo la chiusura della modale
  }

  closeModal() {
    this.isModalOpen = false;
    this.selectedPlus = null; // Resetta selectedPlus quando si chiude la modale senza selezionare una squadra
  }
}
