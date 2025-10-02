-- Insert sample movies
INSERT INTO movies (title, description, duration, genre, language, release_date, poster_url) VALUES
('Avengers: Endgame', 'The Avengers assemble once more to reverse the damage caused by Thanos.', 181, 'Action', 'English', '2019-04-26', 'https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg'),
('RRR', 'A fictional story about two legendary revolutionaries and their journey away from home.', 187, 'Action', 'Telugu', '2022-03-25', 'https://image.tmdb.org/t/p/w500/nWs0auTqn2UaFGfTKtUE5tlTeBu.jpg'),
('The Batman', 'Batman ventures into Gothams underworld when a sadistic killer leaves behind a trail of cryptic clues.', 176, 'Action', 'English', '2022-03-04', 'https://image.tmdb.org/t/p/w500/b0PlSFdDwbyK0cf5RxwDpaOJQvQ.jpg'),
('Spider-Man: No Way Home', 'Peter Parker seeks help from Doctor Strange when his identity is revealed.', 148, 'Action', 'English', '2021-12-17', 'https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg'),
('Pushpa', 'A laborer named Pushpa makes enemies as he rises in the world of red sandalwood smuggling.', 179, 'Action', 'Telugu', '2021-12-17', 'https://image.tmdb.org/t/p/w500/qQ3aGe5c8LgTBK4WT1FpgUWP8Nq.jpg');

-- Insert sample theaters
INSERT INTO theaters (name, address, city) VALUES
('PVR Cinemas Forum Mall', 'Forum Mall, Koramangala', 'Bangalore'),
('INOX Garuda Mall', 'Garuda Mall, Magrath Road', 'Bangalore'),
('Cinepolis Nexus Mall', 'Nexus Mall, Koramangala', 'Bangalore'),
('PVR Phoenix Mills', 'Phoenix Mills, Lower Parel', 'Mumbai'),
('INOX R-City Mall', 'R-City Mall, Ghatkopar', 'Mumbai');

-- Insert sample screens
INSERT INTO screens (name, total_seats, theater_id) VALUES
('Screen 1', 100, 1),
('Screen 2', 150, 1),
('Screen 1', 120, 2),
('Screen 2', 180, 2),
('Screen 1', 200, 3),
('Screen 1', 250, 4),
('Screen 2', 200, 4),
('Screen 1', 180, 5);

-- Insert sample seats for Screen 1 of Theater 1 (100 seats)
INSERT INTO seats (seat_number, seat_type, screen_id) VALUES
-- Row A (Premium - 10 seats)
('A1', 'PREMIUM', 1), ('A2', 'PREMIUM', 1), ('A3', 'PREMIUM', 1), ('A4', 'PREMIUM', 1), ('A5', 'PREMIUM', 1),
('A6', 'PREMIUM', 1), ('A7', 'PREMIUM', 1), ('A8', 'PREMIUM', 1), ('A9', 'PREMIUM', 1), ('A10', 'PREMIUM', 1),
-- Row B (Premium - 10 seats)
('B1', 'PREMIUM', 1), ('B2', 'PREMIUM', 1), ('B3', 'PREMIUM', 1), ('B4', 'PREMIUM', 1), ('B5', 'PREMIUM', 1),
('B6', 'PREMIUM', 1), ('B7', 'PREMIUM', 1), ('B8', 'PREMIUM', 1), ('B9', 'PREMIUM', 1), ('B10', 'PREMIUM', 1),
-- Row C-H (Regular - 60 seats, 10 per row)
('C1', 'REGULAR', 1), ('C2', 'REGULAR', 1), ('C3', 'REGULAR', 1), ('C4', 'REGULAR', 1), ('C5', 'REGULAR', 1),
('C6', 'REGULAR', 1), ('C7', 'REGULAR', 1), ('C8', 'REGULAR', 1), ('C9', 'REGULAR', 1), ('C10', 'REGULAR', 1),
('D1', 'REGULAR', 1), ('D2', 'REGULAR', 1), ('D3', 'REGULAR', 1), ('D4', 'REGULAR', 1), ('D5', 'REGULAR', 1),
('D6', 'REGULAR', 1), ('D7', 'REGULAR', 1), ('D8', 'REGULAR', 1), ('D9', 'REGULAR', 1), ('D10', 'REGULAR', 1),
('E1', 'REGULAR', 1), ('E2', 'REGULAR', 1), ('E3', 'REGULAR', 1), ('E4', 'REGULAR', 1), ('E5', 'REGULAR', 1),
('E6', 'REGULAR', 1), ('E7', 'REGULAR', 1), ('E8', 'REGULAR', 1), ('E9', 'REGULAR', 1), ('E10', 'REGULAR', 1),
('F1', 'REGULAR', 1), ('F2', 'REGULAR', 1), ('F3', 'REGULAR', 1), ('F4', 'REGULAR', 1), ('F5', 'REGULAR', 1),
('F6', 'REGULAR', 1), ('F7', 'REGULAR', 1), ('F8', 'REGULAR', 1), ('F9', 'REGULAR', 1), ('F10', 'REGULAR', 1),
('G1', 'REGULAR', 1), ('G2', 'REGULAR', 1), ('G3', 'REGULAR', 1), ('G4', 'REGULAR', 1), ('G5', 'REGULAR', 1),
('G6', 'REGULAR', 1), ('G7', 'REGULAR', 1), ('G8', 'REGULAR', 1), ('G9', 'REGULAR', 1), ('G10', 'REGULAR', 1),
('H1', 'REGULAR', 1), ('H2', 'REGULAR', 1), ('H3', 'REGULAR', 1), ('H4', 'REGULAR', 1), ('H5', 'REGULAR', 1),
('H6', 'REGULAR', 1), ('H7', 'REGULAR', 1), ('H8', 'REGULAR', 1), ('H9', 'REGULAR', 1), ('H10', 'REGULAR', 1),
-- Row I-J (VIP - 20 seats)
('I1', 'VIP', 1), ('I2', 'VIP', 1), ('I3', 'VIP', 1), ('I4', 'VIP', 1), ('I5', 'VIP', 1),
('I6', 'VIP', 1), ('I7', 'VIP', 1), ('I8', 'VIP', 1), ('I9', 'VIP', 1), ('I10', 'VIP', 1),
('J1', 'VIP', 1), ('J2', 'VIP', 1), ('J3', 'VIP', 1), ('J4', 'VIP', 1), ('J5', 'VIP', 1),
('J6', 'VIP', 1), ('J7', 'VIP', 1), ('J8', 'VIP', 1), ('J9', 'VIP', 1), ('J10', 'VIP', 1);

-- Insert sample shows
INSERT INTO shows (show_time, price, movie_id, screen_id) VALUES
('2025-02-11 10:00:00', 250.00, 1, 1),
('2025-02-11 14:00:00', 300.00, 1, 1),
('2025-02-11 18:00:00', 350.00, 1, 1),
('2025-02-11 21:30:00', 400.00, 1, 1),
('2025-02-11 11:00:00', 200.00, 2, 2),
('2025-02-11 15:00:00', 250.00, 2, 2),
('2025-02-11 19:00:00', 300.00, 2, 2),
('2025-02-11 12:00:00', 280.00, 3, 3),
('2025-02-11 16:00:00', 320.00, 3, 3),
('2025-02-11 20:00:00', 380.00, 3, 3);
-- Alt
ernative poster URLs if TMDb images don't load:
-- RRR: 'https://m.media-amazon.com/images/M/MV5BODUwNDNjYzctODUxNy00ZTA2LWIyYTEtMDc5Y2E5ZjBmNTMzXkEyXkFqcGdeQXVyODE5NzE3OTE@._V1_SX300.jpg'
-- Pushpa: 'https://m.media-amazon.com/images/M/MV5BNjM2NjU1OTYtNzVjZC00NzQyLWI0ZDYtNzJhZTJkNzJkMzVlXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_SX300.jpg'
-- Avengers: 'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg'
-- Batman: 'https://m.media-amazon.com/images/M/MV5BM2MyNTAwZGEtNTAxNC00ODVjLTgzZjUtYmU0YjAzNzE1MjY2XkEyXkFqcGdeQXVyNDc2NTg3NzA@._V1_SX300.jpg'
-- Spider-Man: 'https://m.media-amazon.com/images/M/MV5BZWMyYzFjYTYtNTRjYi00OGExLWE2YzgtOGRmYjAxZTU3NzBiXkEyXkFqcGdeQXVyMzQ0MzA0NTM@._V1_SX300.jpg'