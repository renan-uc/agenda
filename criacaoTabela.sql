create database agenda;

use agenda;

create table contato(
	nome varchar(40),
    telefone bigint(11)
);

alter table contato add constraint pk_contato primary key(nome);

