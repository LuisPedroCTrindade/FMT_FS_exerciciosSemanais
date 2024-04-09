USE biblioteca;

-- BIBLIOTECÁRIOS
INSERT INTO bibliotecario (nome, email, senha) VALUES ('Franscisco', 'chico@email.com', 'frfr1212');
INSERT INTO bibliotecario (nome, email, senha) VALUES ('Miguel', 'miguel@email.com', 'mgmg1212');

-- LIVROS
INSERT INTO livro (titulo, autor, ano_publicacao) VALUES ('Manual de Sobrevivência em Praças de Alimentação', 'Kauê Marinho', 2018);
INSERT INTO livro (titulo, autor, ano_publicacao) VALUES ('A Peça', 'Júlio Cesar Andretti', 2013);

-- MEMBROS
INSERT INTO membro (nome, endereco, telefone) VALUES ('Ian', 'Rua do Comércio, 546', '(48) 9999-4567');
INSERT INTO membro (nome, endereco, telefone) VALUES ('Pedro', 'Rua Felipe Schmidt, 123', '(48) 9999-9998');

-- VISITANTES
INSERT INTO visitante (nome, telefone) VALUES ('Lívia', '(48) 9999-1647');
INSERT INTO visitante (nome, telefone) VALUES ('Laura', '(47) 9999-1345');

-- EMPRÉSTIMOS
INSERT INTO emprestimo (livro_id, membro_id, data_emprestimo, data_devolucao) VALUES (1, 1, '2024-02-05', '2024-04-08');
INSERT INTO emprestimo (livro_id, membro_id, data_emprestimo, data_devolucao) VALUES (2, 2, '2024-01-15', '2024-03-23');