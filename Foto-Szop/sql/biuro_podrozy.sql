-- Projekt Inżynieria Systemów Informatycznych --

-- Mariusz Grochowski		--
-- Piotr Makowiec
-- Szymon Matysik 		--
-- Tomasz Mazur			--
-- Dariusz Szyszlak		--

-- Baza danych--
-- Zakład fotograficzny Foto-szop --

drop database foto_szop;
CREATE DATABASE IF NOT EXISTS foto_szop DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
use foto_szop;


-- Struktura tabeli  KLIENT --

CREATE TABLE klient (
	id_klienta int(4) PRIMARY KEY,
	imie varchar(255) NOT NULL,
	nazwisko varchar(255) NOT NULL,
	adres varchar(255) NOT NULL,
	pesel char(11) NOT NULL UNIQUE,
	nr_tel varchar(15),
	email varchar(255) NOT NULL
);

-- Struktura tabeli  USŁUGA --

CREATE TABLE usluga(
	id_uslugi int(4) PRIMARY KEY,
	nazwa varchar(255) NOT NULL,
	cena decimal(10,2) NOT NULL, 
	data_modyfikacji date
);

-- Struktura tabeli  PRACOWNIK --

CREATE TABLE pracownik (
	id_pracownika int(4) PRIMARY KEY,
	imie varchar(255) NOT NULL,
	nazwisko varchar(255) NOT NULL,
	pesel char(11) NOT NULL UNIQUE,
	nr_tel varchar(15),
	email varchar(255) NOT NULL
);

-- Struktura tabeli  ZAMÓWIENIE --

CREATE TABLE zamowienie(
	id_zamowienia int(4) PRIMARY KEY,
	data_zlozenia date NOT NULL,
	data_realizacji date NOT NULL,
	data_modyfikacji date,
	
	id_pracownika int(4) NOT NULL,
	id_uslugi int(4) NOT NULL,
	id_klienta int(4) NOT NULL,
	
	CONSTRAINT fk_zamowienie_id_pracownika FOREIGN KEY (id_pracownika) REFERENCES pracownik(id_pracownika) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_zamowienie_id_uslugi FOREIGN KEY (id_uslugi) REFERENCES usluga(id_uslugi) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_zamowienie_id_klienta FOREIGN KEY (id_klienta) REFERENCES klient(id_klienta) ON UPDATE CASCADE ON DELETE NO ACTION
);

-- Struktura tabeli KOMENTARZE --
CREATE TABLE komentarze(
	id_komentarza int(4) PRIMARY KEY,
	tekst varchar(255) NOT NULL,
	data_utworzenia date NOT NULL,
	data_modyfikacji date,
	
	id_uslugi int(4) NOT NULL,
	id_klienta int(4) NOT NULL,
	
	CONSTRAINT fk_komentarze_id_uslugi FOREIGN KEY (id_uslugi) REFERENCES usluga(id_uslugi) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_komentarze_id_klienta FOREIGN KEY (id_klienta) REFERENCES klient(id_klienta) ON UPDATE CASCADE ON DELETE NO ACTION
);


-- Struktura tabeli  KONTO --

CREATE TABLE konto(
	id_konta int(4) PRIMARY KEY,
	login varchar(255) NOT NULL,
	haslo varchar(255) NOT NULL,
	data_utworzenia date NOT NULL,
	
	id_pracownika int(4),
	id_klienta int(4),
	
	CONSTRAINT fk_konto_id_pracownika FOREIGN KEY (id_pracownika) REFERENCES pracownik(id_pracownika) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_konto_id_klienta FOREIGN KEY (id_klienta) REFERENCES pracownik(id_klienta) ON UPDATE CASCADE ON DELETE NO ACTION
);


-- Struktura tabeli  TYP_PRACOWNIKA --

CREATE TABLE typ_pracownika(
	id_typu int(4) PRIMARY KEY,
	nazwa varchar(255) NOT NULL,
	data_dodania date NOT NULL
);


-- Struktura tabeli  TYP_PRACOWNIKA_PRACOWNIK --

CREATE TABLE typ_pracownika_pracownik(
	id_pracownika int(4) NOT NULL,
	id_typu int(4) NOT NULL,
	
	CONSTRAINT fk_tpp_id_pracownika FOREIGN KEY (id_pracownika) REFERENCES pracownik(id_pracownika) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_tpp_id_typu FOREIGN KEY (id_typu) REFERENCES typ_pracownika(id_typu) ON UPDATE CASCADE ON DELETE NO ACTION
);


-- Struktura tabeli  TYP_PRACOWNIKA_PRACOWNIK --

CREATE TABLE zdjecia(
	id_zdjecia int(4) PRIMARY KEY,
	data_przeslania date NOT NULL,
	url varchar(255) NOT NULL,
	
	id_zamowienia int(4) NOT NULL,
	
	CONSTRAINT fk_zdjecia_id_pracownika FOREIGN KEY (id_zdjecia) REFERENCES zamowienie(id_zamowienia) ON UPDATE CASCADE ON DELETE NO ACTION
);

-- Struktura tabeli FIRMA --

CREATE TABLE firma(
	nip integer(20) PRIMARY KEY,
	nazwa varchar(255) NOT NULL,
	adres varchar(255) NOT NULL,
	telefon varchar(15) NOT NULL,
	email varchar(255) NOT NULL
);

