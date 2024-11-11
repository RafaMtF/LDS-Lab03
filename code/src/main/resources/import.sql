INSERT INTO instituicao_ensino (id, nome, endereco) VALUES (1, 'Instituição A', 'Endereço A');
INSERT INTO instituicao_ensino (id, nome, endereco) VALUES (2, 'Instituição B', 'Endereço B');

INSERT INTO aluno (id, nome, email, cpf, rg, endereco, saldo, nome_instituicao) VALUES (1, 'Aluno A', 'alunoA@example.com', '123.456.789-00', 'MG-12.345.678', 'Endereço A', 1000, 'Instituição A');
INSERT INTO aluno (id, nome, email, cpf, rg, endereco, saldo, nome_instituicao) VALUES (2, 'Aluno B', 'alunoB@example.com', '987.654.321-00', 'MG-87.654.321', 'Endereço B', 2000, 'Instituição B');

INSERT INTO professor (id, nome, cpf, departamento, saldo, nome_instituicao) VALUES (1, 'Professor A', '123.456.789-00', 'Departamento A', 1000, 'Instituição A');
INSERT INTO professor (id, nome, cpf, departamento, saldo, nome_instituicao) VALUES (2, 'Professor B', '987.654.321-00', 'Departamento B', 2000, 'Instituição B');

INSERT INTO empresa_parceira (id, nome, imagem) VALUES (1, 'Empresa A', 'imagemA.png');
INSERT INTO empresa_parceira (id, nome, imagem) VALUES (2, 'Empresa B', 'imagemB.png');
