CREATE DATABASE biblioteca;

\c biblioteca;

CREATE TABLE IF NOT EXISTS bibliotecario (
                                             bibliotecario_id INT PRIMARY KEY NOT NULL,
                                             nome VARCHAR(255) NOT NULL,
                                             email VARCHAR(100) NOT NULL,
                                             senha VARCHAR(100) NOT NULL);

CREATE TABLE IF NOT EXISTS livro (
                                     livro_id INT PRIMARY KEY NOT NULL,
                                     titulo VARCHAR(255) NOT NULL,
                                     autor VARCHAR(255) NOT NULL,
                                     ano_publicacao INTEGER NOT NULL);

CREATE TABLE IF NOT EXISTS membro (
                                      membro_id INT PRIMARY KEY NOT NULL,
                                      nome VARCHAR(255) NOT NULL,
                                      endereco VARCHAR(255) NOT NULL,
                                      telefone VARCHAR(50) NOT NULL);

CREATE TABLE IF NOT EXISTS visitante (
                                         visitante_id INT PRIMARY KEY NOT NULL,
                                         nome VARCHAR(255) NOT NULL,
                                         telefone VARCHAR(50) NOT NULL);

CREATE TABLE IF NOT EXISTS emprestimo (
                                          emprestimo_id INT PRIMARY KEY NOT NULL,
                                          livro_id INT NOT NULL,
                                          membro_id INT NOT NULL,
                                          data_emprestimo DATE NOT NULL,
                                          data_devolucao DATE NOT NULL,
                                          FOREIGN KEY (livro_id) REFERENCES livro(id),
                                          FOREIGN KEY (membro_id) REFERENCES membro(id));