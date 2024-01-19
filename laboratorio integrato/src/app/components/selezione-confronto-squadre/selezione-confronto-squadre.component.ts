import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';
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

  constructor(private http: HttpClient, private router: Router) {}

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
  isModal2Open = false;

  openModal2() {
    this.isModal2Open = true;
  }

  closeModal2() {
    this.isModal2Open = false;
  }


  loginObj: any = {
    email: "",
    password: "",
};
mostraPassword: boolean = false;

@ViewChild("passwordInput", { static: true }) passwordInput!: ElementRef;
toggleMostraPassword(): void {
    this.mostraPassword = !this.mostraPassword;

    // Aggiorna il tipo dell'input a seconda dello stato
    const inputElement = this.passwordInput.nativeElement as HTMLInputElement;
    inputElement.type = this.mostraPassword ? "text" : "password";
}



onLogin() {
    this.http
        /* this.loginObj contiene i dati inseriti dall'utente nel form e infatti sono i dati che vengono inviati in post a quell url */
        .post("http://localhost:8090/user/login", this.loginObj)
        /* Il response body è questo in caso di pw sbagliata
        {
            "message": "UserName or Password is Wrong",
            "result": false,
            "data": null
        }
        Invece questo in caso di pw corretta
        {
            "message": "Login Success",
            "result": true,
            "data": {
                "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MDQ0OTY2MTAsImlzcyI6IlRlc3QuY29tIiwiYXVkIjoiVGVzdC5jb20ifQ.hcL2zJQCr9BEvqYRj4Gxu1KIyA3PuNsVyasZmFlHMao"
            }
        }
        Con questa api, per avere result true bisogna mettere
        {
            "EmailId": "chetan@gmail.com",
            "Password": "admin"
        }
        */
        .subscribe((res: any) => {
            if (res.success) {
                console.log("entraaaa");
                alert("login ok");
                console.log(res);
                /* In questo modo ti salvi nel local storage il token che hai nel response body e lo chiami loginToken.
                Per vedere il loginToken salvato vado in ispeziona, application, localstorage, localhost*/
                localStorage.setItem("loginToken", res.token);
                localStorage.setItem("name", res.name);
                localStorage.setItem("scadenzaToken", res.expireDate);
                /* Ti porta alla route home */
                this.goToConfrontoTeam()
            } else {
                if (res.message == "Email not found") {
                    this.router.navigateByUrl("/register");
                }
            }
        });
}
}
