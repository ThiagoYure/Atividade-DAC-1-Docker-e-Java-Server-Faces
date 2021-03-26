CREATE TABLE integrantes(
    id TEXT PRIMARY KEY,
    nome VARCHAR(50),
    dataNascimento Date,
    cpf VARCHAR(11)
);
CREATE TABLE bandas(
    id TEXT PRIMARY KEY,
    localDeOrigem TEXT,
    nomeFantasia TEXT
);
CREATE TABLE integrantesBandas(
    id TEXT PRIMARY KEY,
    idIntegrante TEXT,
    idBanda TEXT,
    FOREIGN KEY (idIntegrante) REFERENCES integrantes(id),
    FOREIGN KEY (idBanda) REFERENCES bandas(id)
)