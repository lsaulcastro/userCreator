--===================================================================================================
--                                   CREAR TABLA USUARIO                                            =
--===================================================================================================
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE USER_ENTITY (
                      user_id UUID PRIMARY KEY,
                      full_name VARCHAR(150) NOT NULL,
                      email VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(60) NOT NULL,
                      last_login TIMESTAMP,
                      created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      active BOOLEAN DEFAULT true,
                      token UUID
);

COMMENT ON COLUMN USER_ENTITY.user_id IS 'Identificador del usuario';
COMMENT ON COLUMN USER_ENTITY.full_name IS 'Nombre completo del usuario';
COMMENT ON COLUMN USER_ENTITY.email IS 'Correo electrónico del usuario';
COMMENT ON COLUMN USER_ENTITY.password IS 'Contraseña del usuario para autenticación';
COMMENT ON COLUMN USER_ENTITY.last_login IS 'Fecha del ultimo logeo';
COMMENT ON COLUMN USER_ENTITY.created IS 'Fecha de creación del usuario';
COMMENT ON COLUMN USER_ENTITY.modified IS 'Fecha de la modificación del registro';
COMMENT ON COLUMN USER_ENTITY.active IS 'Indica si el usuario sigue habilitado dentro del sistema';
COMMENT ON COLUMN USER_ENTITY.token IS 'Toke formato UUID';

--===================================================================================================
--                                   CREAR TABLA DE LOS TELEFONOS                                   =
--===================================================================================================

CREATE TABLE PHONE (
                       phone_id SERIAL PRIMARY KEY,
                       user_id  UUID NULL,
                       phone_number VARCHAR(20) NOT NULL,
                       city_code VARCHAR(5) NOT NULL,
                       country_code VARCHAR(5) NOT NULL,
                       phone_type VARCHAR(5) NOT NULL,
                       created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       active BOOLEAN DEFAULT true
);

COMMENT ON COLUMN PHONE.phone_id IS 'Identificador del telefono';
COMMENT ON COLUMN PHONE.user_id IS 'ID del usuario asociado al teléfono';
COMMENT ON COLUMN PHONE.phone_number IS 'Número de teléfono del usuario';
COMMENT ON COLUMN PHONE.city_code IS 'Código de la ciudad';
COMMENT ON COLUMN PHONE.country_code IS 'Código del país';
COMMENT ON COLUMN PHONE.phone_type IS 'Tipo de número: celular, telefono, ...';
COMMENT ON COLUMN PHONE.created IS 'Fecha de creación delteléfono';
COMMENT ON COLUMN PHONE.modified IS 'Fecha de la modificación';
COMMENT ON COLUMN PHONE.active IS 'Estado activo del teléfono';

--===================================================================================================
--                                   CREAR TABLA DE LA CONFIGURACION                                =
--===================================================================================================

CREATE TABLE CATALOG (
                               catalog_id SERIAL PRIMARY KEY,
                               name VARCHAR(60) NOT NULL,
                               description VARCHAR(250) NOT NULL,
                               value VARCHAR(120) NOT NULL,
                               created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               active BOOLEAN DEFAULT true
);

COMMENT ON COLUMN CATALOG.catalog_id IS 'Identificador del catalog';
COMMENT ON COLUMN CATALOG.name IS 'Nombre del catalog';
COMMENT ON COLUMN CATALOG.description IS 'Descripción del catalog';
COMMENT ON COLUMN CATALOG.value IS 'Valor de del catalog';
COMMENT ON COLUMN CATALOG.created IS 'Fecha de creación de del catalog';
COMMENT ON COLUMN CATALOG.modified IS 'Fecha de la modificación del del catalog';
COMMENT ON COLUMN CATALOG.active IS 'Estado activo de del catalog';

--===================================================================================================
--                                   DATA INICIAL                                                   =
--===================================================================================================

INSERT INTO CATALOG (name, description, value, active)
SELECT 'email.regular.expression', 'Contiene la expresión regular para validar si un email es valido',
       '[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}', true
WHERE NOT EXISTS (SELECT 1 FROM CATALOG WHERE name = 'email.regular.expression');

INSERT INTO CATALOG (name, description, value, active)
SELECT 'password.regular.expression', 'Contiene la expresión regular para validar si la contraseña es valida.',
       '^(?=.*\d).{3,}$', true
    WHERE NOT EXISTS (SELECT 1 FROM CATALOG WHERE name = 'password.regular.expression');