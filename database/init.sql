-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-10-14 18:18:00.901

-- tables
-- Table: CommonArea
CREATE TABLE CommonArea (
    id int  NOT NULL,
    description varchar(250)  NOT NULL,
    idTypeArea int  NOT NULL,
    idSection int  NOT NULL,
    CONSTRAINT CommonArea_pk PRIMARY KEY (id)
);

-- Table: Contract
CREATE TABLE Contract (
    id int  NOT NULL,
    signatureDate date  NOT NULL,
    endDate date  NOT NULL,
    amount decimal(12,2)  NOT NULL,
    idProperty int  NOT NULL,
    idUser int  NOT NULL,
    idTypeContract int  NOT NULL,
    CONSTRAINT Contract_pk PRIMARY KEY (id)
);

-- Table: Payment
CREATE TABLE Payment (
    id int  NOT NULL,
    amount decimal(12,2)  NOT NULL,
    date date  NOT NULL,
    concept varchar(50)  NOT NULL,
    detail varchar(100)  NOT NULL,
    idUserPays int  NOT NULL,
    idUserReceives int  NOT NULL,
    CONSTRAINT Payment_pk PRIMARY KEY (id)
);

-- Table: Post
CREATE TABLE Post (
    id int  NOT NULL,
    date date  NOT NULL,
    hour time  NOT NULL,
    title varchar(50)  NOT NULL,
    content varchar(250)  NOT NULL,
    state varchar(50)  NOT NULL,
    idUser int  NOT NULL,
    idTypePost int  NOT NULL,
    idPostRequest int  NULL,
    CONSTRAINT Post_pk PRIMARY KEY (id)
);

-- Table: Property
CREATE TABLE Property (
    id int  NOT NULL,
    environments int  NOT NULL,
    dimensions decimal(12,2)  NOT NULL,
    value decimal(12,2)  NOT NULL,
    description varchar(250)  NOT NULL,
    image varchar(250)  NOT NULL,
    idSection int  NOT NULL,
    idTypeProperty int  NOT NULL,
    idUser int  NOT NULL,
    CONSTRAINT Property_pk PRIMARY KEY (id)
);

-- Table: Section
CREATE TABLE Section (
    id int  NOT NULL,
    name varchar(50)  NOT NULL,
    location varchar(100)  NOT NULL,
    idUser int  NOT NULL,
    CONSTRAINT Section_pk PRIMARY KEY (id)
);

-- Table: TypeArea
CREATE TABLE TypeArea (
    id int  NOT NULL,
    type varchar(50)  NOT NULL,
    CONSTRAINT TypeArea_pk PRIMARY KEY (id)
);

-- Table: TypeContract
CREATE TABLE TypeContract (
    id int  NOT NULL,
    type varchar(50)  NOT NULL,
    CONSTRAINT TypeContract_pk PRIMARY KEY (id)
);

-- Table: TypePost
CREATE TABLE TypePost (
    id int  NOT NULL,
    category varchar(30)  NOT NULL,
    CONSTRAINT TypePost_pk PRIMARY KEY (id)
);

-- Table: TypeProperty
CREATE TABLE TypeProperty (
    id int  NOT NULL,
    type varchar(50)  NOT NULL,
    CONSTRAINT TypeProperty_pk PRIMARY KEY (id)
);

-- Table: TypeUser
CREATE TABLE TypeUser (
    id int  NOT NULL,
    permission varchar(30)  NOT NULL,
    CONSTRAINT TypeUser_pk PRIMARY KEY (id)
);

-- Table: User
CREATE TABLE "User" (
    idUser int  NOT NULL,
    name varchar(128)  NOT NULL,
    usename varchar(128)  NOT NULL,
    password varchar(32)  NOT NULL,
    email varchar(128)  NOT NULL,
    CI varchar(15)  NOT NULL,
    phone varchar(13)  NOT NULL,
    idTypeUser int  NOT NULL,
    CONSTRAINT User_pk PRIMARY KEY (idUser)
);

-- foreign keys
-- Reference: Areas_Comunes_Seccion (table: CommonArea)
ALTER TABLE CommonArea ADD CONSTRAINT Areas_Comunes_Seccion
    FOREIGN KEY (idSection)
    REFERENCES Section (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Areas_Comunes_tipo_Area (table: CommonArea)
ALTER TABLE CommonArea ADD CONSTRAINT Areas_Comunes_tipo_Area
    FOREIGN KEY (idTypeArea)
    REFERENCES TypeArea (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Contratos_propiedades (table: Contract)
ALTER TABLE Contract ADD CONSTRAINT Contratos_propiedades
    FOREIGN KEY (idProperty)
    REFERENCES Property (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Contratos_tipocontrato (table: Contract)
ALTER TABLE Contract ADD CONSTRAINT Contratos_tipocontrato
    FOREIGN KEY (idTypeContract)
    REFERENCES TypeContract (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Contratos_usuarios (table: Contract)
ALTER TABLE Contract ADD CONSTRAINT Contratos_usuarios
    FOREIGN KEY (idUser)
    REFERENCES "User" (idUser)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Post_Post (table: Post)
ALTER TABLE Post ADD CONSTRAINT Post_Post
    FOREIGN KEY (idPostRequest)
    REFERENCES Post (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Post_tipo_post (table: Post)
ALTER TABLE Post ADD CONSTRAINT Post_tipo_post
    FOREIGN KEY (idTypePost)
    REFERENCES TypePost (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Post_usuarios (table: Post)
ALTER TABLE Post ADD CONSTRAINT Post_usuarios
    FOREIGN KEY (idUser)
    REFERENCES "User" (idUser)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Seccion_usuarios (table: Section)
ALTER TABLE Section ADD CONSTRAINT Seccion_usuarios
    FOREIGN KEY (idUser)
    REFERENCES "User" (idUser)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: pagos_usuarios (table: Payment)
ALTER TABLE Payment ADD CONSTRAINT pagos_usuarios
    FOREIGN KEY (idUserPays)
    REFERENCES "User" (idUser)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: pagos_usuarios_recibe (table: Payment)
ALTER TABLE Payment ADD CONSTRAINT pagos_usuarios_recibe
    FOREIGN KEY (idUserPays)
    REFERENCES "User" (idUser)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: propiedades_Seccion (table: Property)
ALTER TABLE Property ADD CONSTRAINT propiedades_Seccion
    FOREIGN KEY (idSection)
    REFERENCES Section (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: propiedades_tipo_Propiedad (table: Property)
ALTER TABLE Property ADD CONSTRAINT propiedades_tipo_Propiedad
    FOREIGN KEY (idTypeProperty)
    REFERENCES TypeProperty (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: propiedades_usuarios (table: Property)
ALTER TABLE Property ADD CONSTRAINT propiedades_usuarios
    FOREIGN KEY (idUser)
    REFERENCES "User" (idUser)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: usuarios_tipo_usuario (table: User)
ALTER TABLE "User" ADD CONSTRAINT usuarios_tipo_usuario
    FOREIGN KEY (idTypeUser)
    REFERENCES TypeUser (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

