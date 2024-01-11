export interface ElencoTeamType {
    west: West;
    east: East;
}

export interface East {
    atlantic: Atlantic;
    central: Atlantic;
    southeast: Atlantic;
}

export interface Atlantic {
    teams: Team[];
}

export interface Team {
    id: number;
    nickname: string;
    name: string;
    logo: string;
    favourite: boolean;
}

export interface West {
    northwest: Atlantic;
    pacific: Atlantic;
    southwest: Atlantic;
}
