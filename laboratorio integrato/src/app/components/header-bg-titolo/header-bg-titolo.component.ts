import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header-bg-titolo',
  templateUrl: './header-bg-titolo.component.html',
  styleUrls: ['./header-bg-titolo.component.scss']
})
export class HeaderBgTitoloComponent {
  @Input() data:any;
  @Input() titolo:string = '';
  @Input() desc:string = '';
}
