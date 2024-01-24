# Avvio del progetto Last Shot

### Requisiti:

Prima di avviare il progetto **LastShot**, è importante assicurarsi di avere tutti i requisiti pre installati:

-   Node.js
-   Angular CLI (Command Line Interface)
-   JDK 17
-   XAMPP
-   un IDE in grado di eseguire un progetto maven

### Verificare/installare i requsiti:

Se non sei sicuro di avere tutti i requisiti installati segui questi passaggi:

1. _Controlla se hai Node.js installato:_
    - Apri il tuo terminale o prompt dei comandi e digita:
        ```bash
        node -v
        ```
        Questo comando restituirà la versione di Node.js installata. Se il comando non è riconosciuto o se la versione è obsoleta, è necessario installare Node.js.
    - Per installare Node.js ti basta andare sul [sito ufficiale nella sezione download](https://nodejs.org/en/download).
2. _Controlla se hai Angular CLI installato:_
    - Dopo aver verificato l'installazione di Node.js, apri il tuo terminale o prompt dei comandi e digita:
        ```bash
        ng --version
        ```
        Questo comando restituirà la versione di Angular CLI installata. Se il comando non è riconosciuto o se la versione è obsoleta, è necessario installare Angular CLI.
    - Se devi installare Angular CLI ti basta eseguire questo comando:
        ```bash
        npm install -g @angular/cli
        ```
3. _Controlla se hai JDK 17 installato:_
    - Apri il tuo terminale o prompt dei comandi e digita:
        ```bash
        java -version
        ```
        Questo comando restituirà la versione di Java installata. Se il comando non è riconosciuto o se la versione non è la 17, è necessario installare JDK 17.
    - Per installare JDK 17, vai sul sito ufficiale di [Oracle nella sezione download](https://www.oracle.com/it/java/technologies/downloads/#java17), scegli la versione per il tuo sistema operativo e segui l'installazione guidata.
4. _Controlla se hai XAMPP installato:_
    - Apri la barra di ricerca del tuo sistema operativo e digita:
        ```bash
        XAMPP Control Panel
        ```
        Se Xampp è installato dovrebbe apparirti. Altrimenti è necessario installare Xampp.
    - Per installare Xampp, vai sul sito ufficiale di [Apache Friends nella sezione download](https://www.apachefriends.org/it/download.html) scegli la versione per il tuo sistema operativo e segui l'installazione guidata.
5. _Controlla se hai un IDE in grado di eseguire un progetto maven:_
    - Alcuni degli IDE più popolari che supportano Maven sono IntelliJ IDEA e Eclipse. Se non hai un IDE installato o se il tuo IDE non supporta Maven, potrebbe essere necessario installarne uno nuovo.
    - Puoi scaricare IntelliJ IDEA dal sito ufficiale di [JetBrains](https://www.jetbrains.com/idea/download/other.html), Eclipse dal sito ufficiale di [Eclipse](https://eclipseide.org/).

### Passaggi da seguire per eseguire il progetto:

1. _Avvia XAMPP e carica il dump del databse:_
    - Apri la barra di ricerca del tuo sistema operativo e digita:
        ```bash
        XAMPP Control Panel
        ```
        Digita invio per aprire il programma.
    - Accendi i server Apache e MySQL, attendi fino a che lo sfondo di tutti e due diventi verde per procedere.
    - Clicca su admin nel server MySQL.
    - Dovrebbe aprirsi un pagina di phpMyAdmin nel tuo browser predefinito.
    - Controlla di essere nel server 127.0.0.1 e non dentro qualche database.
    - Vai nella scheda SQL e incolla il contenuto del file [nbaStat.sql](/LastGame/database/nbastat.sql) e premi su esegui. Questo codice sql è responsabile per la creazione della struttura del database.
    - Se la creazione del database è andata a buon fine ricarica la barra laterale con elencati i database e dovrebbe comparirne uno nominato **nbaStat**, cliccaci sopra.
    - Vai di nuovo nella scheda SQL e incolla il contenuto del file [nbaStatPopulate.sql](/LastGame/database/nbaStatPopulate.sql) e premi esegui. Questo codice sql è responsabile per il popolamento del database con i dati scaricati da api-sports.io.
    - Torna sempre nella scheda SQL e questa volta incolla il contenuto del file [nbaStatStaticData.sql](/LastGame/database/nbaStatStaticData.sql). Questo codice sql è responsabile per il popolamento del database con i dati del blog e degli utenti che gli hanno creati.
2. _Apri il tuo IDE e esegui il progetto:_
    - In base a quale IDE hai installato apri o IntelliJ IDEA o Eclipse
    - Apri il progetto dalla cartella [LastGame](/LastGame/).
    - Tasto destro sul file [pom.xml](/LastGame/pom.xml) e aggiungilo come progetto Maven.
    - Apri il file [LastGameApplication.java](/LastGame/src/main/java/com/IGallinari/LastGame/LastGameApplication.java) e esegui il progetto (tasto play).
3. _Entra nella directory del tuo progetto Angular:_
    - Naviga nella directory del tuo progetto usando il comando cd nel terminale:
        ```bash
        cd laboratorio\ integrato
        ```
4. _Installa le dipendenze del progetto:_
    - Esegui il comando seguente per installare le dipendenze del progetto:
        ```bash
        npm ci
        ```
5. _Se l'installazione non va a buon fine:_
    - Esegui il comando seguente per installare le dipendenze del progetto:
        ```bash
        npm i --force
        ```
6. _Avvia il server di sviluppo:_
    - Ora puoi avviare il tuo progetto Angular eseguendo:
        ```bash
        npm start
        ```

# Gestione aggiornamento database

Il dump del database risale al 22 gennaio 2024 quindi le partite non sono aggiornate alla data odierna. Questo poichè il progetto verrà eseguito totalmente in locale.
