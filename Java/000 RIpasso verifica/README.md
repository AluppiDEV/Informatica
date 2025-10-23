# 🧩 Esercizio Java — Gestione di Studenti (senza array e senza input da tastiera)

## Descrizione

Scrivi un programma in **Java** che gestisca i dati di **due studenti** (nome, cognome, età e media voti) **senza utilizzare array di oggetti** e **senza chiedere inserimenti all’utente**.

L’obiettivo è esercitarsi nella creazione e gestione di **oggetti singoli**, nell’utilizzo di **attributi e metodi di classe**, e nel **confronto tra valori**.

---

## Requisiti

1. Crea una **classe `Studente`** che contenga:
    - `String nome`
    - `String cognome`
    - `int eta`
    - `double mediaVoti`
2. Nella classe `Studente`, implementa un metodo:
    ```java
    public void stampaInfo()
    ```

---

## Obiettivi Didattici

- Comprendere la creazione di oggetti in Java
- Utilizzare metodi e attributi d’istanza
- Eseguire confronti tra dati senza l’uso di strutture complesse (come array o liste)
- Strutturare un semplice programma a oggetti con logica di confronto

---

## Nuovo Esercizio — Classe `Ristorante`

Scrivi il codice per creare una classe `Ristorante` che gestisca le seguenti informazioni:

- **Nome**
- **Capienza massima**
- **Numero di persone presenti**
- **Stato (aperto o chiuso)**
- **Anno di inaugurazione**
- **Tipi di cucina preparati** (es. italiana, giapponese, coreana, ...)

### Requisiti

1. **Costruttori**: crea due costruttori a piacere.
2. **Metodi getter e setter**: implementa i metodi di accesso che ritieni opportuni.
3. **Metodi specifici**:
    - `entrata` e `uscita`: gestiscono l’entrata e l’uscita di persone dal ristorante.
    - `apertura` e `chiusura`: gestiscono l’apertura e la chiusura del ristorante.
    - `pieno` e `vuoto`: verificano se il ristorante è pieno o vuoto.
    - `postiLiberi`: restituisce il numero di posti ancora disponibili.
    - `nomeNumero`: restituisce il nome del ristorante concatenato al numero di persone presenti.
    - `storico`: indica se il ristorante è storico (inaugurato da almeno 20 anni).
    - `verificaCucina`: verifica se viene preparato un certo tipo di cucina.

---

## 🏦 Esercizio — Banca e ContoCorrente

Realizza un programma con due classi: **ContoCorrente** e **Banca**.

### Classe ContoCorrente

**Attributi**:
- `numeroConto`
- `intestatario`
- `saldo`
- `bloccato`

**Metodi**:
- Costruttore che inizializza il conto a saldo 0 e non bloccato
- `deposita(double)`
- `preleva(double)`
- `applicaInteresse(double percentuale)`
- `blocca()` e `sblocca()`
- `mostraDati()`

### Classe Banca

**Attributo**:
- Un solo `ContoCorrente`

**Metodi**:
- `apriConto(int numero, String nome)`
- `versa(double)`
- `preleva(double)`
- `bloccaConto()` e `sbloccaConto()`
- `interesse(double)`
- `mostraSituazione()`

**Nel main**: crea una banca, apri un conto, effettua versamenti, prelievi, applica un interesse, blocca e sblocca il conto, mostrando ogni volta la situazione.

---

## 🏫 Esercizio – Gestione scolastica con tre classi

L’obiettivo del programma è rappresentare in modo semplificato il funzionamento di una scuola, creando tre classi che lavorano insieme tra loro.  
La scuola deve avere almeno uno studente e un professore, e deve permettere di gestire alcune azioni fondamentali, come l’assegnazione dei voti e la valutazione finale.

In particolare, dovrai progettare un sistema in cui:

- Lo studente possiede alcune informazioni personali (ad esempio il nome e il rendimento scolastico).
- Il professore ha anch’egli alcune caratteristiche (ad esempio nome e materia insegnata) e deve poter interagire con lo studente, modificando o aggiornando i suoi risultati.
- La scuola rappresenta l’ambiente in cui il professore e lo studente operano, e si occupa di coordinare le interazioni tra i due (come l’assegnazione dei voti, la valutazione, e la stampa dei risultati finali).

Il programma, una volta eseguito, deve mostrare a video le informazioni aggiornate sui partecipanti e l’esito delle attività svolte nella giornata scolastica (ad esempio se lo studente ha migliorato la sua media o è stato promosso).

L’esercizio richiede di organizzare correttamente il codice in tre classi distinte, rispettando i principi della programmazione orientata agli oggetti:

- Ogni classe deve rappresentare un’entità precisa (studente, professore, scuola).
- Le informazioni devono essere gestite tramite attributi e metodi appropriati.
- La classe principale (la scuola) deve collegare e far interagire le altre due.

---

## Esercizio 3 – Officina, Meccanico, Auto

**Obiettivo:** gestire una riparazione in un’officina.  
Non usare array.

**Descrizione:**

Definire una classe `Auto` con gli attributi:
- targa
- modello
- problema

Definire una classe `Meccanico` con gli attributi:
- nome
- specializzazione

Definire una classe `Officina` che:
- assegna un meccanico a un’auto (`assegnaRiparazione(Meccanico m, Auto a)`)
- stampa il lavoro in corso (`stampaLavoroInCorso()`)
- termina la riparazione liberando i riferimenti (`terminaRiparazione()`)

**Nota:**  
La classe Officina deve contenere un solo meccanico e una sola auto alla volta (nessun array).  
Il metodo `assegnaRiparazione()` deve stampare un messaggio di conferma.  
Il metodo `stampaLavoroInCorso()` deve mostrare i dettagli del meccanico e dell’auto.