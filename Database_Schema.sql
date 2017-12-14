-- Creating book table
create table book(isbn number not null, title varchar2(20), publisher_id number, author_id number, publish_date date, available_copies number, constraint book_pk primary key(isbn));

-- Inserting data into book table
insert into book values(12345, 'C# Programming', 1, 1, to_date('04-09-2016', 'mm-dd-yyyy'), 5);
insert into book values(12346, 'JAVA', 1, 2, to_date('04-07-2000', 'mm-dd-yyyy'), 5);
insert into book values(12347, 'IT Fundamentals', 2, 3, to_date('06-04-1990', 'mm-dd-yyyy'), 5);
insert into book values(12348, 'Computer Networks', 3, 4, to_date('06-19-1999', 'mm-dd-yyyy'), 5);
insert into book values(12349, 'DBMS', 3, 5, to_date('10-26-2004', 'mm-dd-yyyy'), 5);
------------------------------------------------------------------------------------------------------------------------------------------

-- Creating author table
create table author(author_id number not null, name varchar2(45), email varchar2(50), constraint author_pk primary key(author_id));

-- Inserting data into author table
insert into author values(1, 'John Doe', 'john@gmail.com');
insert into author values(2, 'Michael Porter', 'michael.porter@gmail.com');
insert into author values(3, 'Travis Neilson', 'trav_neil@gmail.com');
insert into author values(4, 'Tim Wright', 'tim@outlook.com');
insert into author values(5, 'Alex Thomas', 'thomas.alex@yahoo.com');
--------------------------------------------------------------------------------------------------------------------------------------------

-- Creating publisher table
create table publisher(publisher_id number not null, name varchar2(45), address varchar2(50), phone number, constraint publisher_pk primary key(publisher_id));

-- Inserting data into publisher table
insert into publisher values(1, 'Pearson PLC', 'London, United Kingdom', 8576795867);
insert into publisher values(2, 'John Wiley and Sons', 'Hoboken, NJ', 5689357810);
insert into publisher values(3, '	Oxford University Press', 'Oxford, United Kingdom', 3458764512);
insert into publisher values(4, 'Hachette', 'Paris, France', 8912679009);
insert into publisher values(5, 'RELX Group', 'London, United Kingdom', 4589980990);
--------------------------------------------------------------------------------------------------------------------------------------------

-- Creating borrower table
create table borrower(card_no number not null, name varchar2(45), address varchar2(50), phone number, constraint borrower_pk primary key(card_no));

-- Inserting data into borrower table
insert into borrower values(12345, 'Julia Bell', 'North Amayatown, DE', 1200212178);
insert into borrower values(27675, 'Maxine Feeney', 'Vandervortfort, OK', 9573149427);
insert into borrower values(93443, 'Kaitlin Kulas', 'North Goldenberg, ME', 2893648305);
insert into borrower values(34599, 'Kaley Zulauf', 'Amaraland, MA', 4246665006);
insert into borrower values(73055, 'Alex Clington', 'Feeneymouth, WA', 8991345117);
---------------------------------------------------------------------------------------------------------------------------------------------------------

-- Creating book_borrow table
create table book_borrow(isbn number not null, card_no number not null, borrow_date date, returned char(1), return_date date);

-- Inserting data into book_borrow table
insert into book_borrow values(12345, 27675, to_date('06-21-2015','mm-dd-yyyy'), 'F', null);
insert into book_borrow values(12346, 12345, to_date('02-23-2015','mm-dd-yyyy'), 'F', null);
insert into book_borrow values(12347, 93443, to_date('02-13-2014','mm-dd-yyyy'), 'F', null);
insert into book_borrow values(12348, 34599, to_date('07-03-2012','mm-dd-yyyy'), 'F', null);
insert into book_borrow values(12349, 73055, to_date('05-09-2014','mm-dd-yyyy'), 'F', null);
---------------------------------------------------------------------------------------------------------------------------------------------------------
