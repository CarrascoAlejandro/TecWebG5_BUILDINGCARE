INSERT INTO privilege (id, access_privilege, module) VALUES
(1, 'None', 'Users'),
(2, 'None', 'Posts'),
(3, 'None', 'Payments'),
(4, 'None', 'Properties'),
(5, 'None', 'CommonAreas'),
(6, 'None', 'Contracts'),
(7, 'Read', 'Users'),
(8, 'Read', 'Posts'),
(9, 'Read', 'Payments'),
(10, 'Read', 'Properties'),
(11, 'Read', 'CommonAreas'),
(12, 'Read', 'Contracts'),
(13, 'Write', 'Users'),
(14, 'Write', 'Posts'),
(15, 'Write', 'Payments'),
(16, 'Write', 'Properties'),
(17, 'Write', 'CommonAreas'),
(18, 'Write', 'Contracts');

-- Setear privilegios del admin
INSERT INTO type_user_privileges (type_user_id, privileges_id) VALUES
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18);

-- Setear privilegios del usuario_base
INSERT INTO type_user (id, permission) VALUES (4, 'Usuario Base');

INSERT INTO type_user_privileges (type_user_id, privileges_id) VALUES
(4, 7), -- Read his own user
(4, 10), -- Read properties
(4, 2), -- Closed by default
(4, 3), -- Closed by default
(4, 5), -- Closed by default
(4, 6); -- Closed by default

-- Setear privilegios para el usuario socio
INSERT INTO type_user_privileges (type_user_id, privileges_id) VALUES
(2, 7), -- All read
(2, 14), -- Write posts
(2, 9),
(2, 10),
(2, 11),
(2, 12);

-- Setear privilegios para el usuario inquilino
INSERT INTO type_user_privileges (type_user_id, privileges_id) VALUES
(3, 7), -- All read
(3, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 6);


