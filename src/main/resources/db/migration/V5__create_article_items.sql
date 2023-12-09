create table article_item
(
    id              bigserial primary key,
    content         text    not null,
    content_type    varchar not null,
    sequence_number int     not null,
    article_id      bigint references article (id)
);


create index article_item_sequence_number_idx on article_item (sequence_number);
create index article_item_article_id_idx on article_item (article_id);