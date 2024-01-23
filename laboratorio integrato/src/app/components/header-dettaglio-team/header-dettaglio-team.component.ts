import { HttpClient } from '@angular/common/http';
import { Component, Input } from '@angular/core';
import { map } from 'rxjs';
import { TeamDetailType } from 'src/app/_models/TeamDetailApi.type';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-header-dettaglio-team',
  templateUrl: './header-dettaglio-team.component.html',
  styleUrls: ['./header-dettaglio-team.component.scss']
})
export class HeaderDettaglioTeamComponent {

  @Input() data: TeamDetailType | undefined;
  isFavourite!: boolean;
  constructor(private apiService: ApiService) {}
  data2: any = {} as any;

  toggleFavourite(id:any) {
      this.apiService.getFavouriteTeam(id).subscribe((data) => {
          this.data2 = data;
          console.log(this.data);
          console.log(id);
      });
      this.isFavourite = !this.isFavourite;
  }
}
