CREATE DATABASE if not exists accountsDB;
use accountsDB;
CREATE TABLE accountsDB.accounts_data(
   First_Name VARCHAR(255),
   Last_Name VARCHAR(255),
   Date_Of_Birth date,
   City_Of_Residence VARCHAR(255),
   Country VARCHAR(255)
);
insert into accounts_data values('Mark', 'Entelis', DATE('1981-05-05'), 'MaaleAdumim', 'Israel');
insert into accounts_data values('Eli', 'Entelis', DATE('1981-07-01'), 'MaaleAdumim', 'Israel');
insert into accounts_data values('Alex', 'Entelis', DATE('1977-10-27'), 'MaaleAdumim', 'Israel');
insert into accounts_data values('Fanny', 'Vilge', DATE('1988-11-05'), 'MaaleAdumim', 'Israel');
insert into accounts_data values('Ariel', 'Landau', DATE('1987-09-21'), 'MaaleAdumim', 'Israel');
select * from mydatabase.accounts_data;