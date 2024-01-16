export interface TeamPlayerFilterType {
    teamList:   TeamList[];
    rolePlayer: RolePlayer[];
}

export interface RolePlayer {
    name: string;
}

export interface TeamList {
    idTeam: number;
    name:   string;
}
