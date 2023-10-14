-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-10-13 23:45:25.62

-- tables
-- Table: CommonArea
CREATE TABLE CommonArea (
    id int  NOT NULL,
    description varchar(250)  NOT NULL,
    idTypeArea int  NOT NULL,
    idSection int  NOT NULL,
    CONSTRAINT Areas Comunes_pk PRIMARY KEY (id)
);

-- Table: Contract
CREATE TABLE Contract (
    ID_cont int  NOT NULL,
    signatureDate date  NOT NULL,
    endDate date  NOT NULL,
    amount decimal(12,2)  NOT NULL,
    idProperty int  NOT NULL,
    idUser int  NOT NULL,
    idTypeContract int  NOT NULL,
    CONSTRAINT Contratos_pk PRIMARY KEY (ID_cont)
);

-- Table: Payment
CREATE TABLE Payment (
    id int  NOT NULL,
    amount decimal(12,2)  NOT NULL,
    date date  NOT NULL,
    concept varchar(50)  NOT NULL,
    detail varchar(100)  NULL,
    idUserPays int  NOT NULL,
    idUserReceives int  NOT NULL,
    CONSTRAINT pagos_pk PRIMARY KEY (id)
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
    CONSTRAINT propiedades_pk PRIMARY KEY (id)
);

-- Table: Section
CREATE TABLE Section (
    id int  NOT NULL,
    description varchar(50)  NOT NULL,
    location varchar(100)  NOT NULL,
    idUser int  NOT NULL,
    CONSTRAINT Seccion_pk PRIMARY KEY (id)
);

-- Table: TypeArea
CREATE TABLE TypeArea (
    id int  NOT NULL,
    typeArea varchar(50)  NOT NULL,
    CONSTRAINT tipo_Area_pk PRIMARY KEY (id)
);

-- Table: TypeContract
CREATE TABLE TypeContract (
    id int  NOT NULL,
    typeContract varchar(50)  NOT NULL,
    CONSTRAINT tipocontrato_pk PRIMARY KEY (id)
);

-- Table: TypePost
CREATE TABLE TypePost (
    id int  NOT NULL,
    category varchar(30)  NOT NULL,
    CONSTRAINT tipo_post_pk PRIMARY KEY (id)
);

-- Table: TypeProperty
CREATE TABLE TypeProperty (
    id int  NOT NULL,
    typeProperty varchar(50)  NOT NULL,
    CONSTRAINT tipo_Propiedad_pk PRIMARY KEY (id)
);

-- Table: TypeUser
CREATE TABLE TypeUser (
    id int  NOT NULL,
    permission varchar(30)  NOT NULL,
    CONSTRAINT tipo_usuario_pk PRIMARY KEY (id)
);

-- Table: User
CREATE TABLE "User" (
    id int  NOT NULL,
    name varchar(128)  NOT NULL,
    username varchar(128)  NOT NULL,
    password varchar(32)  NOT NULL,
    email varchar(128)  NOT NULL,
    ci varchar(15)  NOT NULL,
    phone varchar(13)  NOT NULL,
    idTypeUser int  NOT NULL,
    CONSTRAINT usuarios_pk PRIMARY KEY (id)
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
    REFERENCES "User" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Payment_User (table: Payment)
ALTER TABLE Payment ADD CONSTRAINT Payment_User
    FOREIGN KEY (idUserReceives)
    REFERENCES "User" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Payment_User_Pays (table: Payment)
ALTER TABLE Payment ADD CONSTRAINT Payment_User_Pays
    FOREIGN KEY (idUserPays)
    REFERENCES "User" (id)  
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
    REFERENCES "User" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Seccion_usuarios (table: Section)
ALTER TABLE Section ADD CONSTRAINT Seccion_usuarios
    FOREIGN KEY (idUser)
    REFERENCES "User" (id)  
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
    REFERENCES "User" (id)  
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

-- sequences
-- Sequence: Areas_Comunes_seq
CREATE SEQUENCE Areas_Comunes_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Contratos_seq
CREATE SEQUENCE Contratos_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Post_seq
CREATE SEQUENCE Post_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: Seccion_seq
CREATE SEQUENCE Seccion_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: pagos_seq
CREATE SEQUENCE pagos_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: propiedades_seq
CREATE SEQUENCE propiedades_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: tipo_Area_seq
CREATE SEQUENCE tipo_Area_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: tipo_Propiedad_seq
CREATE SEQUENCE tipo_Propiedad_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: tipo_post_seq
CREATE SEQUENCE tipo_post_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: tipo_usuario_seq
CREATE SEQUENCE tipo_usuario_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: tipocontrato_seq
CREATE SEQUENCE tipocontrato_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- Sequence: usuarios_seq
CREATE SEQUENCE usuarios_seq
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;

-- End of file.

