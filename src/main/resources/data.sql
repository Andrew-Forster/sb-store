INSERT IGNORE INTO games(name, price, category, description)

VALUES

('God of War', '39.99', 'Action, adventure', 'His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive…  and teach his son to do the same.'),
('God of War Ragnarök', '49.99', 'Action, adventure', 'Kratos and Atreus embark on a mythic journey for answers before Ragnarök arrives – now on PC.'),
('Cyberpunk 2077', '39.99', 'RPG, open world, sci-fi, cyberpunk', 'Cyberpunk 2077 is an open-world, action-adventure RPG set in the dark future of Night City — a dangerous megalopolis obsessed with power, glamor, and ceaseless body modification.'),
('Cyberpunk 2077: Phantom Liberty', '19.99', 'RPG, open world, sci-fi, cyberpunk', 'This content requires the base game Cyberpunk 2077 in order to play.'),
('Elden Ring', '49.99', 'RPG, open world, dark fantasy', 'THE CRITICALLY ACCLAIMED FANTASY ACTION RPG. Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring and become an Elden Lord in the Lands Between.'),
('Elden Ring: Shadow of the Erdtree', '29.99', 'RPG, open world, dark fantasy', 'This content requires the base game ELDEN RING in order to play.'),
('Sekiro: Shadows Die Twice', '49.99', 'Action, adventure', 'Game of the Year - The Game Awards 2019 Best Action Game of 2019 - IGN Carve your own clever path to vengeance in the award winning adventure from developer FromSoftware, creators of Bloodborne and the Dark Souls series. Take Revenge. Restore Your Honor. Kill Ingeniously.'),
('Dead Space (2023)', '14.99', 'Third-person shooter, horror, sci-fi', 'The sci-fi survival-horror classic returns, completely rebuilt to offer an even more immersive experience — including visual, audio, and gameplay improvements — while staying faithful to the original game’s thrilling vision.'),
('Mass Effect: Legendary Edition', '49.99', 'RPG, sci-fi', 'The Mass Effect™ Legendary Edition includes single-player base content and over 40 DLC from the highly acclaimed Mass Effect, Mass Effect 2, and Mass Effect 3 games, including promo weapons, armors, and packs — remastered and optimized for 4K Ultra HD.'),
('Ghost of Tsushima: Director''s Cut', '49.99', 'Open world, action, adventure', 'A storm is coming. Venture into the complete Ghost of Tsushima DIRECTOR’S CUT on PC; forge your own path through this open-world action adventure and uncover its hidden wonders. Brought to you by Sucker Punch Productions, Nixxes Software and PlayStation Studios.');

INSERT IGNORE INTO ROLES (role_name, role_description) 
VALUES ('Manager', 'Manager of the game store'),
('Employee', 'Employee of the game store'),
('Customer', 'Customer of the game store');

INSERT IGNORE INTO USERS (username, password, first_name, last_name, email, phone_number, role) 
VALUES ('Manager', '$2a$10$lzUS3jHeYAytFUf0q10IiuM7Lyyql9f0Vz3tAgrTe2BRpd7llk0Qa', 'John', 'Wick', 'John.Wick@outlook.com', '555-555-5555', 'MANAGER'),
('Employee', '$2a$10$lzUS3jHeYAytFUf0q10IiuM7Lyyql9f0Vz3tAgrTe2BRpd7llk0Qa', 'Peter', 'Quill', 'Peter.Quill@outlook.com', '333-333-3333', 'EMPLOYEE'),
('Customer', '$2a$10$lzUS3jHeYAytFUf0q10IiuM7Lyyql9f0Vz3tAgrTe2BRpd7llk0Qa', 'Tony', 'Stark', 'Tony.Stark@outlook.com', '222-222-2222', 'CUSTOMER');

INSERT IGNORE INTO USER_ROLES (user_id, role_id) 
VALUES (1, 1), (2, 2), (3, 3);