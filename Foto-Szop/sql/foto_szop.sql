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


-- Table structure  CLIENT --

CREATE TABLE client (
	id_client int(4) PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	surname varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	personal_id char(11) NOT NULL UNIQUE, -- pesel
	phone_nr varchar(15),
	email varchar(255) NOT NULL
);

-- Table structure  SERVICE --

CREATE TABLE service(
	id_service int(4) PRIMARY KEY,
	name varchar(255) NOT NULL,
	price decimal(10,2) NOT NULL, 
	date_of_modification date
);

-- Table structure  EMPLOYEE --

CREATE TABLE employee (
	id_employee int(4) PRIMARY KEY,
	name varchar(255) NOT NULL,
	surname varchar(255) NOT NULL,
	personal_id char(11) NOT NULL UNIQUE, -- pesel
	phone_nr varchar(15),
	email varchar(255) NOT NULL
);

-- Table structure  ORDER --

CREATE TABLE order_ps(
	id_order int(4) PRIMARY KEY,
	date_of_order date NOT NULL,
	date_of_implementation date NOT NULL,
	date_of_modification date,
	
	id_employee int(4) NOT NULL,
	id_service int(4) NOT NULL,
	id_client int(4) NOT NULL,
	
	CONSTRAINT fk_order_id_employee FOREIGN KEY (id_employee) REFERENCES employee(id_employee) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_order_id_service FOREIGN KEY (id_service) REFERENCES service(id_service) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_order_id_client FOREIGN KEY (id_client) REFERENCES client(id_client) ON UPDATE CASCADE ON DELETE NO ACTION
);

-- Table structure  COMMENTS --

CREATE TABLE comments(
	id_comment int(4) PRIMARY KEY,
	text varchar(255) NOT NULL,
	date_of_creation date NOT NULL,
	date_of_modification date,
	
	id_service int(4) NOT NULL,
	id_client int(4) NOT NULL,
	
	CONSTRAINT fk_comments_id_service FOREIGN KEY (id_service) REFERENCES service(id_service) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_comments_id_client FOREIGN KEY (id_client) REFERENCES client(id_client) ON UPDATE CASCADE ON DELETE NO ACTION
);


-- Table structure  ACCOUNT --

CREATE TABLE account(
	id_account int(4) PRIMARY KEY,
	login varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	date_of_creation date NOT NULL,
	
	id_employee int(4),
	id_client int(4),
	
	CONSTRAINT fk_account_id_employee FOREIGN KEY (id_employee) REFERENCES employee(id_employee) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_account_id_client FOREIGN KEY (id_client) REFERENCES client(id_client) ON UPDATE CASCADE ON DELETE NO ACTION
);


-- Table structure  EMPLOYEE_TYPE --

CREATE TABLE employee_type(
	id_type int(4) PRIMARY KEY,
	name varchar(255) NOT NULL,
	date_added date NOT NULL
);


-- Table structure  EMPLOYEE_TYPE_EMPLOYEE--

CREATE TABLE employee_type_employee(
	id_employee int(4) NOT NULL,
	id_type int(4) NOT NULL,
	
	CONSTRAINT fk_tpp_id_employee FOREIGN KEY (id_employee) REFERENCES employee(id_employee) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT fk_tpp_id_type FOREIGN KEY (id_type) REFERENCES employee_type(id_type) ON UPDATE CASCADE ON DELETE NO ACTION
);

-- Table structure  PHOTO--

CREATE TABLE photo(
	id_photo int(4) PRIMARY KEY,
	date_of_upload date NOT NULL,
	url varchar(255) NOT NULL,
	
	id_order int(4) NOT NULL,
	
	CONSTRAINT fk_photo_id_order FOREIGN KEY (id_photo) REFERENCES order_ps(id_order) ON UPDATE CASCADE ON DELETE NO ACTION
);

-- Struktura tabeli FIRMA --

CREATE TABLE firm(
	firm_id integer(20) PRIMARY KEY, -- nip
	name varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	phone_nr varchar(15) NOT NULL,
	email varchar(255) NOT NULL
);



INSERT INTO client	(name, surname, address, personal_id, phone_nr, email) VALUES
("Ryszard", "Nowak", "Nowy Sącz, ul.Rynek 10",'67010289087',"788998098","rysiek@zklanu.pl"),
("Roman","Klusek","Kraków, ul. Smolki 7/11",'87081101234',"665776887","roman@witam.pl"),
("Janusz", "Tratrz", "Warszawa, ul. Plażowa 1",'66010102341',"712933143","janósz@t.pl"),
("Geralt", "Riv", "Ciemnogród, ul.Temerska 33",'41041299009',null. "geralt.z.rivii@kaermohren.pl"),
("Bronisława", "Kmiecik", "Sandomierz", '77020309021',"912033855","bronka@kmiecik.pl"),





