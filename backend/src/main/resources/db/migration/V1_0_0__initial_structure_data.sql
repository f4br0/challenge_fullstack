create table item (
    id                    BIGINT  auto_increment,
    name           varchar(50) not null,
    description           varchar(200) not null,
    primary key (id)
);

insert into item (name, description) values ('Item 1', 'Description item 1 este item 1 es muy bueno lalalalala');
