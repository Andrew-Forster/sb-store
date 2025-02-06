INSERT IGNORE INTO games(name, price, category, description)
VALUES ('Test', '29.99', 'RPG', 'Test game');

INSERT IGNORE INTO ROLES (role_name, role_description) 
VALUES ('Manager', 'Manager of the game store'),
('Employee', 'Employee of the game store'),
('Customer', 'Customer of the game store');

INSERT IGNORE INTO USERS (username, password, first_name, last_name, email, phone_number) 
VALUES ('Manager', 'Root', 'John', 'Wick', 'John.Wick@outlook.com', '555-555-5555'),
('Employee', 'Root', 'Peter', 'Quill', 'Peter.Quill@outlook.com', '333-333-3333'),
('Customer', 'Root', 'Tony', 'Stark', 'Tony.Stark@outlook.com', '222-222-2222');

INSERT IGNORE INTO USER_ROLES (user_id, role_id) 
VALUES (1, 1), (2, 2), (3, 3);