import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ClassificaType } from "src/app/_models/classificaApi.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-classifica",
    templateUrl: "./classifica.component.html",
    styleUrls: ["./classifica.component.scss"],
})
export class ClassificaComponent {

   data: ClassificaType = {} as ClassificaType;

    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    stagione: any;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.stagione = params.get("stagione");
            console.log("stagione:", this.stagione);
            this.apiService.getClassifica(this.stagione).subscribe((data) => {
                this.data = data;
                console.log("qeust", data);
            });
        });
    }


}
