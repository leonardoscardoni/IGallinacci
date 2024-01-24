--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `name`, `role`) VALUES
(1, 'andrea.aquilino@edu.itspiemonte.it', '$2a$10$xBfkdyHZCDQPyq78tiR/ou4q2ppdTUuCc98qqegLnUxU6yHB.KAEq', 'andrea', 1), 
(2, 'ilaria.gigliarano@edu.itspiemonte.it', '$2a$10$vKImuUnXqXUFG9EFx1089.plsHDbOUi7I8pITQ.AvO5vitZBfc.Um', 'ilaria', 1),
(3, 'leo.scardoni@gmail.com', '$2a$10$s.FIiryacnn2saw6fu/Sie.JLuSUbtcZVjtY8XVxAlsx590q1kp8S', 'leonardo', 0);

--
-- Dump dei dati per la tabella `blog`
--

INSERT INTO `blog` (`id`, `idUser`, `title`, `subtitle`, `date`, `img`) VALUES
(1, 1, 'L\'Epica Storia del \'Last Shot\' di Michael Jordan', 'Come Michael Jordan ha cambiato la storia del basket con un solo tiro', '2024-01-19', 'https://i.imgur.com/HrVbWac.jpg'),
(2, 1, 'Draymond Green torna in campo!', 'Come il suo ritorno può cambiare le sorti dei Warriors e della NBA', '2024-01-20', 'https://i.imgur.com/0AhY20m.jpg'),
(3, 2, 'La prima tripla doppia in NBA di Paolo Banchero', 'Il fenomeno italiano che fa impazzire la NBA: la sua prima tripla doppia contro i Nuggets', '2024-01-21', 'https://www.nbareligion.com/wp-content/uploads/2022/12/paolo_banchero-1.jpg.webp'),
(4, 2, 'Jaime Jasquez Jr parteciperà allo Slam Dunk Contest', 'Il volo dell’ex UCLA che sfida le leggi della gravità, il suo debutto allo Slam Dunk Contest', '2024-01-22', 'https://i.imgur.com/MYu7dQ7.jpg'),
(5, 1, 'L’infortunio di Haliburton', 'Haliburton out per due settimane, come cambia la situazione dei Pacers', '2024-01-23', 'https://www.nbapassion.com/wp-content/uploads/2024/01/haliburton-infortunio.webp');

--
-- Dump dei dati per la tabella `favteam`
--

INSERT INTO `favteam` (`idUser`, `idTeam`) VALUES
(3, 6);

--
-- Dump dei dati per la tabella `paragraph`
--

INSERT INTO `paragraph` (`idBlog`, `number`, `title`, `content`) VALUES
(1, 1, 'Quando la Leggenda Incontra la Gloria', 'Nel vasto panorama dello sport mondiale, poche storie brillano con la stessa intensità di quella legata al Last Shot di Michael Jordan. Il 14 giugno 1998, nell\'epico Game 6 delle Finals NBA, Jordan scolpì la sua leggenda nel cuore degli appassionati di basket, regalando al mondo uno dei momenti più iconici nella storia dello sport.'),
(1, 2, 'Il Contesto Storico', 'Per comprendere appieno la grandezza del Last Shot, è fondamentale immergersi nel contesto storico. Michael Jordan, ormai considerato il più grande giocatore di basket di tutti i tempi, aveva annunciato il suo ritiro nel 1993, solo per fare il suo ritorno nel 1995. Il Chicago Bulls, guidato da Jordan, aveva già conquistato cinque titoli NBA, ma nel 1998 si trovava di fronte a una sfida cruciale contro gli Utah Jazz.'),
(1, 3, 'La Partita Epica', 'Il Game 6 delle Finals del 1998 è diventato sinonimo di dramma e eccitazione. Con pochi secondi rimasti sul cronometro e il punteggio in parità, il destino del titolo NBA era appeso a un filo. Jordan, con la palla tra le mani, si preparò per quello che diventerà noto come il Last Shot. La tensione nell\'aria era palpabile, e il mondo tenne il respiro mentre il pallone lasciò le mani del leggendario  numero 23.'),
(1, 4, 'La Magia del Last Shot', 'Il tiro di Jordan contro gli Utah Jazz è entrato a pieno titolo nella leggenda sportiva. Con una precisione millimetrica, il pallone attraversò il canestro nel momento esatto in cui scadeva il tempo regolamentare. La celebre immagine di Jordan in sospensione, la lingua fuori, è diventata l\'icona di un\'era. Il Last Shot non fu solo una vittoria per i Bulls ma anche un inno alla determinazione, alla classe e alla magia intrinseca al gioco del basket.'),
(1, 5, 'Eredità e Impatto', ' Il Last Shot non fu solo il culmine di una carriera straordinaria, ma anche il passaggio del testimone a una nuova generazione di giocatori. Michael Jordan aveva dimostrato che il successo richiede non solo talento, ma anche resilienza e la capacità di gestire la pressione nei momenti cruciali. L\'eredità del Last Shot continua a ispirare giocatori di tutto il mondo, che cercano di emulare la maestria e il carattere del grande MJ.'),
(1, 6, 'Conclusione', 'Il Last Shot di Michael Jordan è molto più di un momento epico nel basket; è un capitolo immortale nella storia dello sport. Quella notte del 1998, Jordan ha dimostrato che la grandezza si misura non solo nei titoli, ma anche nei momenti indimenticabili che rimangono scolpiti nella memoria collettiva. Il suo Last Shot rimarrà per sempre un faro luminoso nel vasto panorama dello sport, un\'ispirazione eterna per coloro che sognano di raggiungere le vette più alte.'),
(2, 1, 'Il suo ritorno può cambiare le cose', 'Il suo ritorno può cambiare le cose. Draymond Green è pronto a tornare in campo. L\'ala dei Golden State Warriors è stata squalificata per 12 partite a seguito di un\'espulsione per un fallo antisportivo commesso contro Jusuf Nurkic dei Portland Trail Blazers. L\'assenza di Green è stata un duro colpo per i Warriors, che hanno perso 10 delle 12 partite senza di lui. Il suo ritorno è una grande notizia per la squadra, che sta cercando di tornare ai vertici della classifica NBA. Green è uno dei giocatori più importanti della NBA. È un difensore dominante, un ottimo passatore e un tiratore affidabile. Il suo ritorno è una grande aggiunta per i Warriors, che stanno cercando di conquistare il quarto titolo NBA in otto anni. Le aspettative per Green sono alte. È uno dei giocatori più talentuosi della NBA e ha già dimostrato di poter fare la differenza in gara. Si prevede che Green avrà un impatto immediato sui Warriors. La sua difesa sarà un\'arma importante per la squadra, e il suo passaggio sarà fondamentale per l\'attacco. Green è anche un leader importante per i Warriors. Il suo ritorno darà alla squadra una maggiore fiducia e determinazione.'),
(2, 2, 'Il ritorno di Green può cambiare le cose', 'La squadra avrà di nuovo un leader in difesa, il passaggio sarà più fluido e la squadra avrà una maggiore fiducia in se stessa. I Warriors sono attualmente al decimo posto nella classifica della Western Conference. Se Green potrà restare in campo in forma, i Warriors saranno uno dei favoriti per vincere il titolo NBA.'),
(2, 3, 'Il futuro di Green', 'Il ritorno di Green è una grande notizia per i Warriors, ma anche per lo stesso giocatore. Green ha dimostrato di essere uno dei migliori giocatori della NBA, ma la sua espulsione ha messo in discussione il suo futuro. Green ha ammesso di aver avuto problemi a controllare la sua rabbia e ha dichiarato di essere pronto a lavorare su questo aspetto. Il suo ritorno in campo sarà un\'occasione per mostrare che ha imparato la lezione e che è pronto a continuare a essere un leader per i Warriors. Il ritorno di Green è un momento importante per i Warriors e per la NBA. Green è un giocatore speciale e il suo ritorno può cambiare le cose.'),
(2, 4, 'Conclusione', 'Il ritorno di Draymond Green è una grande notizia per i Golden State Warriors e per la NBA. Green è un giocatore speciale e il suo ritorno può cambiare le cose. I Warriors hanno bisogno di Green per tornare ai vertici della classifica e per competere per il titolo NBA. Green ha bisogno di dimostrare che ha imparato la lezione e che è pronto a continuare a essere un leader per la squadra. Il futuro di Green è nelle sue mani. Se saprà controllare la sua rabbia, potrà continuare a essere uno dei migliori giocatori della NBA e aiutare i Warriors a vincere altri titoli.'),
(3, 1, 'La Prestazione', 'La prestazione di Banchero è stata particolarmente impressionante per diversi motivi. Innanzitutto, ha dimostrato di essere un giocatore in grado di dominare la partita in diversi modi. Ha segnato 32 punti, un numero significativo per un giocatore di 20 anni che gioca al suo primo anno in NBA. Ha anche aggiunto 11 assist, dimostrando di essere un playmaker capace di creare opportunità per i suoi compagni di squadra. Infine, ha catturato 10 rimbalzi, dimostrando di essere un giocatore forte e atletico. In secondo luogo, Banchero ha dimostrato di essere un giocatore in grado di incidere in situazioni difficili. I Magic erano in svantaggio di 18 punti nel terzo quarto, ma Banchero ha guidato la rimonta. Ha segnato 10 punti e aggiunto 8 assist nel quarto quarto, aiutando i Magic a vincere la partita. In terzo luogo, Banchero ha dimostrato di essere un giocatore in grado di competere contro i migliori giocatori della NBA. I Nuggets sono una squadra forte, guidata dal MVP Nikola Jokic. Banchero ha segnato 10 punti contro Jokic, dimostrando di poter competere contro i migliori giocatori del mondo.'),
(3, 2, 'Interviste o dichiarazioni di Banchero o di altri protagonisti della partita', 'Dopo la partita, Banchero ha dichiarato: \"Sono molto contento di aver registrato la mia prima tripla doppia. È stato un momento speciale per me e per la mia famiglia. Sono orgoglioso di aver contribuito alla vittoria dei Magic.\" Il coach degli Orlando Magic, Jamahl Mosley, ha dichiarato: \"Paolo ha giocato una partita fantastica. È stato un leader per noi in entrambe le metà campo. È un giocatore speciale e ha un futuro brillante.\"'),
(3, 3, 'Conclusione', 'Paolo Banchero ha scritto un nuovo capitolo nella storia del basket italiano con la sua prima tripla doppia in carriera contro i Denver Nuggets. La prestazione del giovane talento, che ha realizzato 32 punti, 11 assist e 10 rimbalzi, è stata particolarmente significativa perché è arrivata contro una squadra forte come i Nuggets, guidata dal MVP Nikola Jokic. Banchero ha dimostrato di essere un giocatore completo e in grado di incidere in vari modi, segnando 15 dei suoi punti dalla lunetta, dove è andato 15/19. Ha anche aggiunto due palle rubate e un recupero.'),
(4, 1, 'L’entusiasmo per il debutto di Jaquez allo Slam Dunk Contest', 'L\'entusiasmo è alle stelle nel mondo della pallacanestro, poiché il talentuoso ex giocatore di UCLA, Jaime Jaquez Jr., si prepara a fare il suo debutto allo Slam Dunk Contest NBA durante il prossimo fine settimana delle stelle nello Utah. Dopo una carriera universitaria straordinaria con i Bruins di UCLA, Jaquez si è già guadagnato la fama per le sue schiacciate acrobatiche e creative. La notizia della sua partecipazione al concorso ha scatenato l\'entusiasmo tra i fan della squadra e gli appassionati della NBA.'),
(4, 2, 'Il Talento di Jaquez', 'Jaime Jaquez Jr., attualmente uno dei giocatori più in vista della Eastern Conference, è stato selezionato al numero 18 nel draft NBA del 2023. Ha già dimostrato di essere un contendente di spicco, superando prospetti del calibro di Scoot Henderson e Brandon Miller. I suoi istinti sul campo sono una testimonianza della sua abilità di alto livello, contribuendo a consolidare la sua posizione come giocatore da tenere d\'occhio nella lega.'),
(4, 3, 'La fama di Jaquez', 'La fama di Jaquez non si basa solo sulle statistiche, ma anche sullo spettacolo che offre durante le schiacciate. Durante la sua carriera universitaria, ha stupito gli spettatori con schiacciate provenienti da ogni angolo e posizione immaginabile. La sua versatilità nel realizzare schiacciate a due mani o a una mano è un riflesso della sua abilità atletica straordinaria.'),
(4, 4, 'Un Appuntamento con la Storia', 'Lo Slam Dunk Contest NBA, in programma per sabato 18 febbraio 2024, è diventato un appuntamento imperdibile nel calendario degli appassionati di pallacanestro. La partecipazione di Jaquez promette di aggiungere un tocco di magia al già affascinante spettacolo. I fan di UCLA e della NBA possono aspettarsi schiacciate spettacolari e momenti indimenticabili quando Jaquez alzerà il volo a Salt Lake City.'),
(4, 5, 'Conclusioni', 'Jaime Jaquez Jr. si appresta a scrivere un nuovo capitolo nella sua promettente carriera partecipando allo Slam Dunk Contest NBA. La sua presenza aggiunge un\'anticipazione elettrizzante al fine settimana delle stelle, promettendo un\'esplosione di talento e spettacolo per tutti gli amanti della pallacanestro. Lasciamoci catturare dalle acrobazie aeree di Jaquez mentre si lancia nell\'aria per conquistare il cuore dei fan e lasciare un\'impronta indelebile nella storia della NBA.'),
(5, 1, 'I Pacers saranno in difficoltà?', 'Tyrese Haliburton è uno dei giocatori più importanti degli Indiana Pacers. Il playmaker 22enne è stato scambiato dai Sacramento Kings a gennaio 2023 e da allora è stato un pilastro della squadra, guidandola a una serie di buone prestazioni. Tuttavia, Haliburton ha subito un infortunio alla gamba sinistra durante la partita contro i Boston Celtics del 12 gennaio. La risonanza magnetica ha rivelato uno stiramento di primo grado, che lo costringerà a stare fuori per almeno due settimane.'),
(5, 2, 'L\'impatto dell\'infortunio', 'L\'infortunio di Haliburton è un duro colpo per i Pacers. Il giocatore è il secondo miglior realizzatore della squadra con 17,4 punti a partita, e il miglior assistman con 9,2 assist a partita. Inoltre, è un giocatore fondamentale per la difesa dei Pacers, che lo scorso anno è stata una delle migliori della lega. La squadra di Indiana dovrà quindi trovare il modo di sostituire Haliburton. I candidati principali sono Malcolm Brogdon, Buddy Hield e T.J. McConnell. Brogdon è un giocatore completo che può fare un po\' di tutto, ma è stato infortunato per gran parte della stagione. Hield è un tiratore di classe mondiale, ma non è un playmaker naturale. McConnell è un buon difensore e un buon passatore, ma non è un realizzatore di prim\'ordine.'),
(5, 3, 'Le prospettive dei Pacers', 'I Pacers sono attualmente al 10° posto nella Eastern Conference. Con Haliburton in campo, la squadra aveva buone possibilità di qualificarsi ai playoff. Tuttavia, senza di lui le cose si complicano. I Pacers dovranno vincere più partite delle altre squadre in lotta per i playoff se vogliono centrare l\'obiettivo. Brogdon, Hield e McConnell dovranno essere in grado di assumersi maggiori responsabilità offensive e difensive. Inoltre, la squadra dovrà continuare a giocare bene in difesa.'),
(5, 4, 'Conclusione', 'L\'infortunio di Haliburton è un duro colpo per i Pacers. La squadra dovrà trovare il modo di sostituirlo e dovrà vincere più partite se vuole centrare i playoff.');

--
-- Dump dei dati per la tabella `tagplayer`
--

INSERT INTO `tagplayer` (`idBlog`, `idPlayer`) VALUES
(2, 204),
(2, 398),
(3, 279),
(3, 3414),
(4, 3408),
(4, 3950),
(5, 71),
(5, 236),
(5, 348),
(5, 2595);

--
-- Dump dei dati per la tabella `tagteam`
--

INSERT INTO `tagteam` (`idBlog`, `idTeam`) VALUES
(1, 6),
(1, 40),
(2, 11),
(2, 29),
(3, 9),
(3, 26),
(4, 20),
(5, 2),
(5, 15);
COMMIT;
