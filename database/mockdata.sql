-- Insert mock data into TypeUser table
INSERT INTO type_user (id, permission)
VALUES
    (1, 'Admin'),
    (2, 'Editor'),
    (3, 'Viewer');

-- Insert mock data into User table
INSERT INTO "user" (id, name, usename, password, email, CI, phone, id_type_user)
VALUES
    (1, 'Admin User', 'admin_user', 'password123', 'admin@example.com', '12345', '123-456-7890', 1),
    (2, 'Editor User', 'editor_user', 'password456', 'editor@example.com', '67890', '987-654-3210', 2),
    (3, 'Viewer User', 'viewer_user', 'password789', 'viewer@example.com', '54321', '555-555-5555', 3);

-- Insert mock data into Section table
INSERT INTO section (id, name, location, id_user)
VALUES
    (1, 'The Pines', 'Main Building', 1),
    (2, 'The Birch', 'Main Building', 1),
    (3, 'The Ashes', 'Main Building', 2),
    (4, 'The Palms', 'Garden Area', 2);

-- Insert mock data into TypeProperty table
INSERT INTO type_property (id, type)
VALUES
    (1, 'Apartment'),
    (2, 'House'),
    (3, 'Condo'),
    (4, 'Villa');

-- Insert mock data into Property table
INSERT INTO property (id, environments, dimensions, value, description, image, id_section, id_type_property, id_user)
VALUES
    (1, 4, 120.50, 250000.00, 'Spacious living room', 'image1.jpg', 1, 1, 1),
    (2, 2, 80.25, 180000.00, 'Modern kitchen', 'image2.jpg', 2, 1, 1),
    (3, 3, 150.75, 320000.00, 'Cozy bedroom', 'image3.jpg', 3, 2, 2),
    (4, 2, 200.00, 450000.00, 'Beautiful garden', 'image4.jpg', 4, 4, 2);

-- Insert mock data into TypePost table
INSERT INTO type_post(id, category) 
VALUES 
    (1, 'Mantenimiento'), 
    (2, 'Reserva'),
    (3, 'Solicitud');

-- Insert mock data into Post table
-- Insertando un post sin idPostRequest
INSERT INTO post (id, date, hour, title, content, state, id_user, id_type_post)
VALUES
    (1, '2023-10-10', '12:00:00', 'Mantenimiento', 'Se necesita mantenimiento en el apartamento 1','Active', 1, 1),
    (2, '2023-10-15', '11:00:00', 'Reserva', 'Se necesita reservar el apartamento 2','Active', 2, 2),
    (3, '2023-10-20', '10:00:00', 'Solicitud', 'Se necesita solicitar el apartamento 3','Active', 3, 3);   

-- Insertando un post con idPostRequest establecido en 1 (haciendo referencia al post 1)
INSERT INTO post (id, date, hour, title, content, state, id_user, id_type_post, id_post_request) 
VALUES (4, '2023-10-27', '14:30:00', 'Nuevo mantenimiento', 'Se necesita urgentemente mantenimiento', 'Urgent', 1, 1, 1);

-- Insert mock data into Payment table
INSERT INTO payment (id, amount, date, concept, detail, id_user_pays, id_user_receives) 
VALUES
    (1, 100.50, '2023-10-28', 'Mantenimiento', 'Mantenimiento de la sala', 1, 2),
    (2, 200.75, '2023-10-29', 'Alquiler', 'Alquiler de salón de eventos', 2, 1),
    (3, 50.25, '2023-10-30', 'Servicio', 'Servicio de limpieza', 1, 3);

-- Insert mock data into TypeArea table
INSERT INTO type_area (id, type)
VALUES 
    (1, 'Áreas recreativas'), 
    (2, 'Áreas de fitness'), 
    (3, 'Área de estudio');

-- Insert mock data into CommonArea table
INSERT INTO common_area (id, description, id_type_Area, id_section)
VALUES 
    (1,'Piscina olímpica para adultos y niños.', 1, 1),
    (2,'Gimnasio con máquinas modernas y área de pesas libres.', 2, 2),  
    (3,'Zona tranquila con mesas y sillas para estudio o trabajo remoto.', 3, 3); 

-- Insert mock data into TypeContract table
INSERT INTO type_contract (id, type)
VALUES 
    (1, 'Contrato a plazo fijo'),
    (2, 'Contrato indefinido'),
    (3,'Contrato por proyecto'),
    (4,'Contrato temporal'),
    (5, 'Contrato de prácticas');

-- Insert mock data into Contract table
INSERT INTO contract (id, signature_date, end_date, amount, id_property, id_user, id_type_contract)
VALUES 
    (1, '2023-01-15', '2024-01-14', 1500.50, 1, 1, 1),
    (2, '2023-02-01', '2025-02-01', 2000.00, 2, 2, 2),
    (3, '2023-03-10', '2023-12-10', 1000.75, 3, 3, 1);
