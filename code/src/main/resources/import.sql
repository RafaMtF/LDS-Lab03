INSERT INTO instituicao_ensino (id, nome, endereco) VALUES (1, 'Instituição A', 'Endereço A');

INSERT INTO aluno (id, nome, email, cpf, rg, endereco, saldo, nome_instituicao) VALUES (1, 'Rafa', 'alunoA@example.com', '123.456.789-00', 'MG-12.345.678', 'Endereço A', 1000, 'Instituição A');

INSERT INTO professor (id, nome, cpf, departamento, saldo, nome_instituicao) VALUES (1, 'Professor A', '123.456.789-00', 'Departamento A', 10000, 'Instituição A');

INSERT INTO empresa_parceira (id, nome, imagem) VALUES (1, 'Empresa A', 'imagemA.png');
INSERT INTO empresa_parceira (id, nome, imagem) VALUES (2, 'Empresa B', 'imagemB.png');