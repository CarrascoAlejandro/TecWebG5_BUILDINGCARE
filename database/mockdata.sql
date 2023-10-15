-- Insert mock data into TypeUser table
INSERT INTO TypeUser (id, permission)
VALUES
    (1, 'Admin'),
    (2, 'Editor'),
    (3, 'Viewer');

-- Insert mock data into User table
INSERT INTO "User" (idUser, name, usename, password, email, CI, phone, idTypeUser)
VALUES
    (1, 'Admin User', 'admin_user', 'password123', 'admin@example.com', '12345', '123-456-7890', 1),
    (2, 'Editor User', 'editor_user', 'password456', 'editor@example.com', '67890', '987-654-3210', 2),
    (3, 'Viewer User', 'viewer_user', 'password789', 'viewer@example.com', '54321', '555-555-5555', 3);

-- Insert mock data into Section table
INSERT INTO Section (id, name, location, idUser)
VALUES
    (1, 'The Pines', 'Main Building', 1),
    (2, 'The Birch', 'Main Building', 1),
    (3, 'The Ashes', 'Main Building', 2),
    (4, 'The Palms', 'Garden Area', 2);

-- Insert mock data into TypeProperty table
INSERT INTO TypeProperty (id, type)
VALUES
    (1, 'Apartment'),
    (2, 'House'),
    (3, 'Condo'),
    (4, 'Villa');

-- Insert mock data into Property table
INSERT INTO Property (id, environments, dimensions, value, description, image, idSection, idTypeProperty, idUser)
VALUES
    (1, 4, 120.50, 250000.00, 'Spacious living room', 'image1.jpg', 1, 1, 1),
    (2, 2, 80.25, 180000.00, 'Modern kitchen', 'image2.jpg', 2, 1, 1),
    (3, 3, 150.75, 320000.00, 'Cozy bedroom', 'image3.jpg', 3, 2, 2),
    (4, 2, 200.00, 450000.00, 'Beautiful garden', 'image4.jpg', 4, 4, 2);
