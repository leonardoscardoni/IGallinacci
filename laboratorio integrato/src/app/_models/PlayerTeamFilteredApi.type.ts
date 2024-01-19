export interface PlayerTeamFilteredType {
    logged:    boolean;
    favourite: boolean;
    idTeam:    number;
    logo:      string;
    nickname:  string;
    name:      string;
    season:    number;
    players:   Player[];
}

export interface Player {
    favourite: boolean;
    idPlayer:  number;
    firstname: string;
    lastname:  string;
    role:      Role;
    number:    number | null;
    country:   Country | null;
}

export enum Country {
    Australia = "Australia",
    Japan = "Japan",
    Usa = "USA",
}

export enum Role {
    Ala = "Ala",
    Centro = "Centro",
    Guardia = "Guardia",
    GuardiaAla = "Guardia-Ala",
}
