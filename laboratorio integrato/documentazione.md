# Documentazione frontend
#### Gruppo Gallinacci - Alessio Strano, Clara Cosentino, Lorenzo Apicella

---
---

#### Introduzione
Il progetto NBA Last Shot è stato sviluppato utilizzando il framework Angular e con l'obiettivo di fornire agli utenti una piattaforma intuitiva per visualizzare i risultati e le statistiche relative all’ NBA. La documentazione qui di seguito fornisce una panoramica delle librerie e dei framework utilizzati, affronta alcune problematiche incontrate durante lo sviluppo e descrive le soluzioni adottate.

---

#### Librerie e framework
Il progetto fa ampio uso di librerie e framework per garantire un'esperienza utente ricca e interattiva. Le principali librerie sono:

##### Dayjs
Utilizzata per la gestione e la manipolazione delle date, garantendo una visualizzazione chiara e coerente delle informazioni temporali.

##### PrimeNg
Utilizzata per implementare dropdown interattive, migliorando l'usabilità delle funzionalità di selezione all'interno della piattaforma.

##### Flowbite
Utilizzata per la creazione della navbar, fornendo un'interfaccia responsive.

##### Tailwind
Framework utilizzato per lo styling, garantendo una presentazione coerente e accattivante dell'interfaccia grafica.

---

#### Problematiche affrontate
Durante lo sviluppo del progetto, sono state affrontate diverse problematiche. Di seguito vengono discusse alcune delle principali sfide e le relative soluzioni implementate

##### Token nelle chiamate POST
Durante le chiamate POST, è emerso il problema di non poter utilizzare il token come variabile. Il token è quindi stato inserito andando a prelevarlo direttamente dal local storage in tutte le chiamate.

##### Gestione dell’impaginazione dei componenti card-confronto-dati
Le card di confronto dati (presenti ad esempio nella sezione statistiche del dettaglio di una partita già giocata) sono utilizzate in molte pagine e impaginate sempre nello stesso modo. L’idea iniziale era quella di creare un componente contenitore-card-confronto-dati che avrebbe ciclato sull’array ritornato dal backend e creato un componente card-confronto-dati per ciascun elemento dell’array. A dettare l’impaginazione (flex) di queste card sarebbe quindi stato contenitore-card-confronto-dati.
Questo non ci è stato possibile a causa della variazione continua del nome dell'array restituito dall'API e su cui bisognava ciclare. La difficoltà risiedeva nel fatto che non eravamo in grado di trasmettere dinamicamente al componente il nome esatto dell'array su cui avrebbe dovuto iterare per costruire le card. Passandolo come input non funzionava.

##### Complessità della Logica delle Pagine di Confronto Giocatori e Confronto Team
La logica delle pagine confronto giocatori e confronto team era troppo complessa e ci ha reso difficile l’utilizzo di un unico componente utilizzato per entrambe.

##### Token nelle chiamate POST
Durante le chiamate POST, è emerso il problema di non poter utilizzare il token come variabile. Il token è quindi stato inserito andando a prelevarlo direttamente dal local storage in tutte le chiamate.

##### Gestione dell’impaginazione dei componenti card-confronto-dati
Le card di confronto dati (presenti ad esempio nella sezione statistiche del dettaglio di una partita già giocata) sono utilizzate in molte pagine e impaginate sempre nello stesso modo. L’idea iniziale era quella di creare un componente contenitore-card-confronto-dati che avrebbe ciclato sull’array ritornato dal backend e creato un componente card-confronto-dati per ciascun elemento dell’array. A dettare l’impaginazione (flex) di queste card sarebbe quindi stato contenitore-card-confronto-dati.
Questo non ci è stato possibile a causa della variazione continua del nome dell'array restituito dall'API e su cui bisognava ciclare. La difficoltà risiedeva nel fatto che non eravamo in grado di trasmettere dinamicamente al componente il nome esatto dell'array su cui avrebbe dovuto iterare per costruire le card. Passandolo come input non funzionava.

##### Codice del popup di login
Alcune pagine sono state studiate per i soli utenti loggati: questo ci ha portati a dover implementare un popup di login che compare nel caso in cui un utente non loggato voglia accedere a quella determinata pagina.
La mancanza di tempo ha portato all'inserimento manuale del codice del pop-up di login, senza l'utilizzo di un componente. 
Se avessimo utilizzato un componente non saremmo riusciti, una volta effettuato il login, a riportare l’utente sulla pagina richiesta originariamente.

##### Modifica stato stellina dell’elenco giocatori
Nell'elenco dei giocatori, è stata riscontrata la possibile modifica grafica del valore di tutte le stelline quando se ne preme una per modificarne lo stato. Questo problema è attualmente sotto valutazione e, con più tempo, si può fornire una soluzione accurata e coerente.
La problematica è solo a livello grafico / estetico e non a livello di logica (le chiamate POST per la gestione delle stelline vanno a buon fine).

##### Filtro nell’elenco dei giocatori
Per evitare risposte troppo “corpose” da parte del backend, nella pagina dell’elenco dei giocatori è stata implementata la visualizzazione dei giocatori solo quando è applicato un filtro. Questo approccio contribuisce a migliorare le prestazioni complessive della piattaforma.

---

#### Conclusioni
La piattaforma affronta in modo efficace le sfide specifiche dell'integrazione e della visualizzazione dei dati NBA. Le soluzioni implementate riflettono l'impegno per garantire un'esperienza utente ottimale nonostante le complessità riscontrate durante lo sviluppo.