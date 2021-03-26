INSERT INTO integrantes (id, nome, dataNascimento, cpf)
VALUES ('6fa715d5-2f57-42f7-b579-300ae1701181','M. Shadows', '31/07/1981', '11111111111');
INSERT INTO integrantes (id, nome, dataNascimento, cpf)
VALUES ('e5527e25-0aad-469f-a749-5d9ff8644265', 'The Rev', '09/02/1981', '11111111112');
INSERT INTO integrantes (id, nome, dataNascimento, cpf)
VALUES ('17beed73-62c7-43b0-95e5-833b384dc4ff', 'Synyster Gates', '07/07/1981', '11111111113');
INSERT INTO integrantes (id, nome, dataNascimento, cpf)
VALUES ('6f56992e-49af-427b-a454-3c7a9f7d3b73', 'Zacky Vengeance', '11/12/1981', '11111111114');
INSERT INTO integrantes (id, nome, dataNascimento, cpf)
VALUES ('134e2dc1-8a3e-4f29-a62c-080963c976d0', 'Johnny Christ', '18/11/1984', '11111111115');
INSERT INTO bandas (id, localDeOrigem, nomeFantasia)
VALUES ('9c202bb3-cbe7-430e-926d-3e3a85d42e61', 'Huntington Beach, Califórnia - EUA', 'Avenged Sevenfold');
INSERT INTO integrantesBandas (id, idIntegrante, idBanda)
VALUES ('13cd53f6-4162-4ce0-95b9-b5264c66d9a0', '6fa715d5-2f57-42f7-b579-300ae1701181', '9c202bb3-cbe7-430e-926d-3e3a85d42e61');
INSERT INTO integrantesBandas (id, idIntegrante, idBanda)
VALUES ('f13c47b2-667c-4dc7-94d5-ce6aa3e24284', 'e5527e25-0aad-469f-a749-5d9ff8644265', '9c202bb3-cbe7-430e-926d-3e3a85d42e61');
INSERT INTO integrantesBandas (id, idIntegrante, idBanda)
VALUES ('41c7f58a-4f00-44e8-91df-b2e53361b87c', '17beed73-62c7-43b0-95e5-833b384dc4ff', '9c202bb3-cbe7-430e-926d-3e3a85d42e61');
INSERT INTO integrantesBandas (id, idIntegrante, idBanda)
VALUES ('694a7437-4c0c-4bf2-96da-1d6f2ce488ac', '6f56992e-49af-427b-a454-3c7a9f7d3b73', '9c202bb3-cbe7-430e-926d-3e3a85d42e61');
INSERT INTO integrantesBandas (id, idIntegrante, idBanda)
VALUES ('97c357e2-221a-429c-ad78-58f7e9b29c02', '134e2dc1-8a3e-4f29-a62c-080963c976d0', '9c202bb3-cbe7-430e-926d-3e3a85d42e61');