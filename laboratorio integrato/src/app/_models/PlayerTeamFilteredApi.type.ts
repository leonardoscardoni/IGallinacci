export interface PlayerTeamFilteredType {
    idTeam:   number;
    nickname: string;
    name:     string;
    logo:     string;
    season:   number;
    players:  Player[];
}

export interface Player {
    idPlayer:  number;
    name:      string;
    ruolo:     string;
    number:    number | null;
    country:   Country | null;
    favourite: boolean;
}

export enum Country {
    Australia = "Australia",
    Japan = "Japan",
    Usa = "USA",
}

export enum Ruolo {
    Ala = "Ala",
    Centro = "Centro",
    Guardia = "Guardia",
    GuardiaAla = "Guardia-Ala",
}
