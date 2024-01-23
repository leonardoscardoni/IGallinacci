export interface ConfrontoPlayerType {
    player1:           Player;
    player2:           Player;
    comparisonPlayers: ComparisonPlayer[];
    dataPlayers:       DataPlayer[];
}

export interface ComparisonPlayer {
    firstname:   string;
    lastname:    string;
    age:         number;
    country:     string;
    weight:      number;
    height:      number;
    team:        string;
    debut:       number;
    college:     string;
    affiliation: string;
    role:        string;
}

export interface DataPlayer {
    dataName:    string;
    dataPlayer1: number;
    dataPlayer2: number;
}

export interface Player {
    favourite: boolean;
    idPlayer:  number;
    firstname: string;
    lastname:  string;
    logo:      string;
}
