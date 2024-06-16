# UsersService
Aplicația la nivel de consolă pentru gestionarea utilizatorilor dintr-o bază de date.
Scopul aplicației este de a aplica operațiuni CRUD pentru clasa User.
Înainte de a rula aplicația, ar trebui să rulați comanda „maven clean install” pentru a vă asigura că toate dependențele au fost instalate sau actualizate.
Proiectul poate fi rulat numai dacă aveți instalat Java 8 sau o versiune superioară.

În folderul principal pot fi găsite două pachete:
1. Dosarul principal care va fi descris mai jos;
2. Dosarul de testare.
   Dosarul principal este structurat în trei subdirectoare și Clasa principală:
1. Dto - unde poate fi găsită clasa User.
2. Service - unde se gasesc serviciile de creare a conexiunii Db si tabelul folosit in aplicatie.
3. ConsoleUi unde poate fi găsită logica principală folosită în aplicație.
4. Clasa principală de unde poate fi pornită aplicația.
   Dosarul de testare conține câteva teste specifice folosind un db de testare temporar.

Proiectul folosește cunoștințele principale dobândite din cursul Java de la ItFactory.
