CREATE TABLE boktittel(
  isbn VARCHAR(50) NOT NULL, 
  forfatter  VARCHAR(50) NOT NULL,  
  tittel VARCHAR(50) NOT NULL,
  CONSTRAINT boktittel_PK PRIMARY KEY(isbn));
   
CREATE TABLE eksemplar(
  isbn VARCHAR(50) NOT NULL, 
  eks_nr INTEGER NOT NULL, 
  laant_av VARCHAR(50), 
  CONSTRAINT eksemplar_PK PRIMARY KEY(isbn, eks_nr));
  
ALTER TABLE eksemplar
  ADD CONSTRAINT eksemplar_fk FOREIGN KEY(isbn)
  REFERENCES boktittel;  

INSERT INTO boktittel(isbn, forfatter, tittel) values ('0-201-50998-X', 'J. Rumbaugh, I. Jacobson, G. Booch', 'The Unified Modeling Language Reference Manual');
INSERT INTO boktittel(isbn, forfatter, tittel) values ('0-07-241163-5', 'J. P. Cohoon, J. W. Davidson', 'C++ Program Design');
INSERT INTO boktittel(isbn, forfatter, tittel) values ('0-596-00123-1', 'Brett Mclaughlin', 'Bulding Java Enterprise Applications');
INSERT INTO eksemplar(isbn, eks_nr, laant_av) values ('0-201-50998-X', 1, NULL);
INSERT INTO eksemplar(isbn, eks_nr, laant_av) values ('0-07-241163-5', 1, NULL);
INSERT INTO eksemplar(isbn, eks_nr, laant_av) values ('0-596-00123-1', 1, NULL);

INSERT INTO eksemplar(isbn, eks_nr, laant_av) values ('0-07-241163-5', 2, NULL);
INSERT INTO eksemplar(isbn, eks_nr, laant_av) values ('0-596-00123-1', 2, NULL);
INSERT INTO eksemplar(isbn, eks_nr, laant_av) values ('0-596-00123-1', 3, NULL);

