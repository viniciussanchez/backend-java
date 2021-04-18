create table products.product (
  id bigserial primary key,
  product_identifier varchar not null,
  nome varchar(100) not null,
  descricao varchar not null,
  preco float not null,
  category_id bigint references products.category(id)
);