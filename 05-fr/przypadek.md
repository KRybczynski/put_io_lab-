# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC6](#uc6): Potwierdzenie wysłania produktu
* [UC8](#uc8): Usunięcie oferty

[Kupujący](#ac2)
* [UC2](#uc2): Wyszukanie oferty
* [UC3](#uc3): Podbicie ceny produktu
* [UC4](#uc4): Zapłata za produkt
* [UC5](#uc5): Potwierdzenie otrzymania produktu
* [UC7](#uc7): Anulowanie podbicia ceny


---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Wyszukanie oferty

**Aktorzy:**  [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujacy](#ac2-kupujący) zgłasza chęć kupna produktu 
1. System prosi o nazwę produktu
1. [Kupujacy](#ac2-kupujący) wprowadza nazwę produktu
1. System wyświetla produkty których nazwa pokrywa się z wprowadzonymi danymi
1. [Kupujący](#ac2-kupujący) wwybiera interesującą go ofertę
1. System prezentuje dokładniejsze informacje odnośnie aukcji

---
<a id="uc3"></a>
### UC3: Podbicie ceny produktu

**Aktorzy:**  [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujacy](#ac2-kupujący) wyraza chęć podbicia ceny produktu
1. System prosi o [złożenie oferty](#br1-złożenie-oferty)
1. System weryfikuje poprawność danych
1. System informuje o pomyślnym złożeniu oferty, aktualizuje dane akcji, wyświetla nową najwyzszą cenę i zapisuje dane [kupującego](#ac2-kupujący)

**Scenariusze alternatywne:** 

3.A. Podano niepoprawne dane 
* 3.A.1. System informuje o błędnie podanych danych.
* 3.A.2. Przejdź do kroku 2.

---
<a id="uc4"></a>
### UC4: Finalizacja aukcji

**Aktorzy:**  [Kupujący](#ac2)

**Scenariusz główny:**
1. System informuje o wygranej aukcji i informuje [kupującego](#ac2) o konieczniści zapłaty
2. [Kupujący](#ac2-kupujący) wyraża finalizacji aukcji
3. System prosi o podanie danych do przesyłki
4. [Kupujący](#ac2-kupujący) podaje dane do przesyłki
5. System weryfikuje podane informacje
6. Użytkownik wyraża chęć zapłaty
7. System przekierowuje [Kupującgo](#ac2-kupujący) do strony obsługującej płatności internetowe
8. [Kupujący](#ac2-kupujący) dokonuje płatności
9. System wysyła potwierdzenie zamówienia

**Scenariusze alternatywne:** 

2.A. [Kupujący](#ac2-kupujący) nie chce płacić
* 2.A.1. System rozwiązuje problem według zdefiniowanych [zasad](#br3)
* 2.A.2 Zakup aukcji zostaje anulowany

4.A. Podano niepoprawne dane
* 4.A.1 System informuje o błędnie podanych danych.
* 4.A.2 Przejdź do kroku 3.

9.A Płatność nieudana
* 9.A.1 System informuje o nieudanej płatności
* 9.A.2 Przejdź do kroku 6

---
<a id="uc5"></a>
### UC5: Potwierdzenie otrzymania produktu

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**
1. System informuje [kupującego](#ac2) o tym że [sprzedający](#ac1) wysłał produkt
2. Jeżeli produkt został dostarczony [kupujący](#ac2) wyraża chęć potwierdzenia odbioru
3. System prosi o potwierdzenie otrzymania przedmiotu
4. [Kupujący](#ac2-sprzedający) potwierdza otrzymania przedmiotu
5. System przekazuje pieniądze [Sprzedającemu](#ac1-sprzedający)

**Scenariusze alternatywne:** 

4.A. Kupujący zalega z potwierdzeniem 
* 4.A.1. System rozwiązuje sytuację według podanych [zasad](#br5-roztrzygnięcie-braku-potwierdzenia-odebrania)
* 4.A.2. Zakończ scenariusz

---
<a id="uc6"></a>
### UC6: Potwierdzenie wysłania produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Sprzedający](#ac1) wyraża chęć wysłania przedmiotu
1. System przekazuje mu dane do wysyłki
1. [Sprzedający](#ac1-sprzedający) wysyła przesyłkę
1. System prosi o podanie dane przesyłki
1. [Sprzedający](#ac1) podaje dane przesyłki
1. System zapisuje dane przesyłki
**Scenariusze alternatywne:** 

5.A. [Sprzedający](#ac1-sprzedający) nie potwierdza wysłania przedmiotu
* 5.A.1. System rozwiązuje problem według podanych [zasad](#br4-roztrzygnięcie-niewysłania-przedmiotu)
* 5.A.2. Zakończ scenariusz 

---
## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

<a id="br3"></a>
### BR3: Rozstrzygnięcie niezapłącenia

Jeżeli [Kupujący](#ac2-kupujący) wygra akcje i nie zapłąci w ciągu 7 dni to wysyłane jest mu ostrzeżenie. Jeżeli ponowi to działanie jego konto zostaje usunięte a adres IP zbanowany.

<a id="br4"></a>
### BR4: Roztrzygnięcie niewysłania przedmiotu 

Jeżeli [sprzedający](#ac1) nie wyśle przedmiotu w ciągu 7 dni jego oferta zostaje anulowana a pieniądze zostają zwrócone kupującemu

<a id="br5"></a>
### BR5: Roztrzygnięcie braku potwierdzenia odebrania
Jeżeli sprzedający potwierdzi wysyłkę a kupujący nie potwierdzi odbioru w przeciągu miesiąca to tranzakcja jest autmatycznie zamykana i sprzedający otrzymuje pieniądze.
Kupujący może zgłosić problem z przesyłką, jeżeli numer przesyłki nie istnieje w systemie pocztowym to tranzakcja zostaje anulowana, pieniądze są zwracane kupującemu.


## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | 
| ------------------------------------------------- | ------ | ------- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    |
| UC2: Wyszukanie oferty |  R   |  R    |
| UC3: Podbicie ceny produktu |  U   |  ...    |
| UC4: Zapłata za produkt|  ...   |  ...    | C |
| UC5: Potwierdzenie otrzymania produktu |  ...   |  ...    |
| UC6: Potwierdzenie wysłania produktu |  ...   |  ...    |