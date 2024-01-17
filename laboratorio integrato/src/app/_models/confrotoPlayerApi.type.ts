export interface ConfrontoPlayerType {
    player1:           Player;
    player2:           Player;
    comparisonPlayers: ComparisonPlayer[];
    dataPlayers:       DataPlayer[];
}

export interface ComparisonPlayer {
    name:        string;
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
    idPlayer: number;
    name:     string;
    logo:     string;
}
