--
-- Table structure for table movies
--

CREATE TABLE movies (
  id int NOT NULL DEFAULT 0,
  name varchar(100) DEFAULT NULL,
  "year" int DEFAULT NULL,
  rank float DEFAULT NULL,
  PRIMARY KEY (id)
) ;

--
-- Dumping data for table movies
--


INSERT INTO movies VALUES (10920,'Aliens',1986,8.2),(17173,'Animal House',1978,7.5),(18979,'Apollo 13',1995,7.5),(30959,'Batman Begins',2005, 9),(46169,'Braveheart',1995,8.3),(109093,'Fargo',1996,8.2),(111813,'Few Good Men, A',1992,7.5),(112290,'Fight Club',1999,8.5),(116907,'Footloose',1984,5.8),(124110,'Garden State',2004,8.3),(130128,'Godfather, The',1972,9),(147603,'Hollow Man',2000,5.3),(167324,'JFK',1991,7.8),(176711,'Kill Bill: Vol. 1',2003,8.4),(176712,'Kill Bill: Vol. 2',2004,8.2),(192017,'Little Mermaid, The',1989,7.3),(194874,'Lost in Translation',2003,8),(207992,'Matrix, The',1999,8.5),(210511,'Memento',2000,8.7),(224842,'Mystic River',2003,8.1),(237431,'O Brother, Where Art Thou?',2000,7.8),(238072,'Ocean''s Eleven',2001,7.5),(238695,'Office Space',1999,7.6),(254943,'Pi',1998,7.5),(256630,'Pirates of the Caribbean',2003,8.5),(257264,'Planes, Trains & Automobiles',1987,7.2),(267038,'Pulp Fiction',1994,8.7),(276217,'Reservoir Dogs',1992,8.3),(297838,'Shawshank Redemption, The',1994,9),(300229,'Shrek',2001,8.1),(306032,'Snatch.',2000,7.9),(313459,'Star Wars',1977,8.8),(314965,'Stir of Echoes',1999,7),(333856,'Titanic',1997,6.9),(344203,'UHF',1989,6.6),(350424,'Vanilla Sky',2001,6.9);


--
-- Table structure for table movies_genres
--

CREATE TABLE movies_genres (
  movie_id int DEFAULT NULL,
  genre varchar(100) DEFAULT NULL
) ;

--
-- Dumping data for table movies_genres
--


INSERT INTO movies_genres VALUES (10920,'Sci-Fi'),(10920,'Action'),(10920,'Thriller'),(10920,'Horror'),(17173,'Comedy'),(18979,'Drama'),(30959,'Action'),(30959,'Crime'),(30959,'Fantasy'),(30959,'Thriller'),(30959,'Adventure'),(46169,'Drama'),(46169,'War'),(46169,'Action'),(109093,'Crime'),(109093,'Thriller'),(109093,'Drama'),(111813,'Drama'),(111813,'Thriller'),(112290,'Drama'),(112290,'Thriller'),(112290,'Mystery'),(112290,'Crime'),(116907,'Drama'),(116907,'Family'),(116907,'Music'),(124110,'Drama'),(124110,'Comedy'),(130128,'Crime'),(130128,'Drama'),(147603,'Horror'),(147603,'Sci-Fi'),(147603,'Thriller'),(167324,'Crime'),(167324,'Drama'),(167324,'Mystery'),(167324,'Thriller'),(176711,'Action'),(176711,'Crime'),(176711,'Thriller'),(176712,'Action'),(176712,'Thriller'),(176712,'Drama'),(176712,'Romance'),(192017,'Family'),(192017,'Animation'),(192017,'Comedy'),(192017,'Musical'),(192017,'Romance'),(192017,'Fantasy'),(194874,'Drama'),(194874,'Comedy'),(207992,'Action'),(207992,'Thriller'),(207992,'Sci-Fi'),(210511,'Drama'),(210511,'Mystery'),(210511,'Thriller'),(224842,'Drama'),(224842,'Crime'),(224842,'Thriller'),(237431,'Comedy'),(237431,'Adventure'),(237431,'Crime'),(238072,'Comedy'),(238072,'Thriller'),(238072,'Crime'),(238695,'Comedy'),(254943,'Thriller'),(254943,'Sci-Fi'),(256630,'Adventure'),(256630,'Fantasy'),(257264,'Comedy'),(267038,'Crime'),(267038,'Drama'),(276217,'Crime'),(276217,'Thriller'),(276217,'Mystery'),(276217,'Action'),(297838,'Drama'),(300229,'Adventure'),(300229,'Romance'),(300229,'Animation'),(300229,'Fantasy'),(300229,'Family'),(300229,'Comedy'),(306032,'Crime'),(306032,'Comedy'),(313459,'Sci-Fi'),(313459,'Action'),(313459,'Adventure'),(313459,'Fantasy'),(314965,'Thriller'),(314965,'Horror'),(314965,'Mystery'),(333856,'Drama'),(333856,'Romance'),(344203,'Comedy'),(350424,'Drama'),(350424,'Romance'),(350424,'Sci-Fi'),(350424,'Thriller'),(350424,'Mystery');


