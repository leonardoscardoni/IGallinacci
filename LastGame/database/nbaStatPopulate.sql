USE `nbastat`;
--
-- Dump dei dati per la tabella `arena`
--

INSERT INTO `arena` (`nameArena`, `city`, `state`, `country`) VALUES
('Ball Arena', 'Denver', 'CO', NULL),
('Chase Center', 'San Francisco', 'CA', NULL),
('crypto.com Arena', 'Los Angeles', 'CA', NULL),
('Delta Center', 'Salt Lake City', 'UT', NULL),
('Gainbridge Fieldhouse', 'Indianapolis', 'IN', NULL),
('Golden 1 Center', 'Sacramento', 'CA', NULL),
('Kaseya Center', 'Miami', 'FL', NULL),
('Paycom Center', 'Oklahoma City', 'OK', NULL),
('Rocket Mortgage FieldHouse', 'Cleveland', 'OH', NULL),
('Scotiabank Arena', 'Toronto', 'ON', NULL),
('State Farm Arena', 'Atlanta', 'GA', NULL),
('Wells Fargo Center', 'Philadelphia', 'PA', NULL);

-- --------------------------------------------------------
--
-- Dump dei dati per la tabella `team`
--

INSERT INTO `team` (`id`, `name`, `nickname`, `code`, `city`, `logo`, `allstar`, `conference`, `division`) VALUES
(2, 'Boston Celtics', 'Celtics', 'BOS', 'Boston', 'https://upload.wikimedia.org/wikipedia/fr/thumb/6/65/Celtics_de_Boston_logo.svg/1024px-Celtics_de_Boston_logo.svg.png', 0, 'East', 'Atlantic'),
(6, 'Chicago Bulls', 'Bulls', NULL, 'CHI', 'https://upload.wikimedia.org/wikipedia/fr/thumb/d/d1/Bulls_de_Chicago_logo.svg/1200px-Bulls_de_Chicago_logo.svg.png', 0, 'East', 'Central'),
(7, 'Cleveland Cavaliers', 'Cavaliers', NULL, 'CLE', 'https://upload.wikimedia.org/wikipedia/fr/thumb/0/06/Cavs_de_Cleveland_logo_2017.png/150px-Cavs_de_Cleveland_logo_2017.png', 0, 'East', 'Central'),
(11, 'Golden State Warriors', 'Warriors', 'GSW', 'Golden State', 'https://upload.wikimedia.org/wikipedia/fr/thumb/d/de/Warriors_de_Golden_State_logo.svg/1200px-Warriors_de_Golden_State_logo.svg.png', 0, 'West', 'Pacific'),
(14, 'Houston Rockets', 'Rockets', NULL, 'HOU', 'https://upload.wikimedia.org/wikipedia/fr/thumb/d/de/Houston_Rockets_logo_2003.png/330px-Houston_Rockets_logo_2003.png', 0, 'West', 'Southwest'),
(15, 'Indiana Pacers', 'Pacers', NULL, 'IND', 'https://upload.wikimedia.org/wikipedia/fr/thumb/c/cf/Pacers_de_l%27Indiana_logo.svg/1180px-Pacers_de_l%27Indiana_logo.svg.png', 0, 'East', 'Central'),
(16, 'LA Clippers', 'Clippers', NULL, 'LAC', 'https://upload.wikimedia.org/wikipedia/fr/d/d6/Los_Angeles_Clippers_logo_2010.png', 0, 'West', 'Pacific'),
(27, 'Philadelphia 76ers', '76ers', NULL, 'PHI', 'https://upload.wikimedia.org/wikipedia/fr/4/48/76ers_2016.png', 0, 'East', 'Atlantic');

-- --------------------------------------------------------
--
-- Dump dei dati per la tabella `game`
--

INSERT INTO `game` (`id`, `season`, `gameDate`, `startTime`, `stage`, `totPeriods`, `nameArena`, `id_visitor`, `id_home`) VALUES
(12897, 2023, '2023-12-19', '01:00:00', 2, 4, 'Rocket Mortgage FieldHouse', 14, 7),
(12910, 2023, '2023-12-20', '04:00:00', 2, 4, 'Chase Center', 2, 11);

-- --------------------------------------------------------
--
-- Dump dei dati per la tabella `statsgame`
--

INSERT INTO `statsgame` (`idTeam`, `idGame`, `win`, `lose`, `seriesWin`, `seriesLose`, `pointsPeriod`, `fastBreakPoint`, `pointsInPaint`, `biggestLead`, `secondChancePoints`, `pointsOffTurnovers`, `longestRun`, `points`, `fgm`, `fga`, `fgp`, `ftm`, `fta`, `ftp`, `tpm`, `tpa`, `tpp`, `offReb`, `defReb`, `totReb`, `assists`, `pFouls`, `steals`, `turnovers`, `blocks`, `plusMinus`, `min`) VALUES
(2, 12910, 0, 0, 0, 0, '[40, 25, 32, 24, 5]', NULL, NULL, NULL, NULL, NULL, NULL, 126, 47, 114, 85.7, 15, 17, 88.2, 17, 58, 29.3, 18, 37, 55, 28, 13, 6, 8, 5, -6, '240:00'),
(7, 12897, 0, 0, 0, 0, '[33, 24, 42, 23, 13]', NULL, NULL, NULL, NULL, NULL, NULL, 135, 47, 98, 48, 22, 34, 64.7, 19, 48, 39.6, 15, 24, 39, 29, 25, 7, 12, 8, 5, '240:00'),
(11, 12910, 0, 0, 0, 0, '[30, 32, 24, 35, 11]', NULL, NULL, NULL, NULL, NULL, NULL, 132, 50, 109, 45.9, 12, 14, 85.7, 20, 50, 40, 18, 41, 59, 29, 15, 4, 10, 5, 6, '240:00'),
(14, 12897, 0, 0, 0, 0, '[34, 25, 39, 24, 8]', NULL, NULL, NULL, NULL, NULL, NULL, 130, 47, 102, 64.7, 24, 27, 88.9, 12, 33, 36.4, 15, 32, 47, 34, 32, 9, 14, 5, -5, '240:00');

