-- get_constraints_drop 
alter table freshshop.sales_orders drop constraint fk_coupon_order ;
alter table freshshop.product_tags drop constraint fk_products_product_tags ;
alter table freshshop.product_tags drop constraint fk_tags_product_tags ;
alter table freshshop.user_roles drop constraint fk_roles_user_roles ;
alter table freshshop.user_roles drop constraint fk_users_user_roles ;
alter table freshshop.product_categories drop constraint fk_category_products_categories ;
alter table freshshop.sales_orders drop constraint fk_user_sales_order ;
alter table freshshop.sales_orders drop constraint fk_session_sales_order ;
alter table freshshop.products drop constraint fk_product_statuses_product ;
alter table freshshop.order_products drop constraint fk_sales_orders_order_products ;
alter table freshshop.cc_transactions drop constraint fk_sales_order_cc_transaction ;
alter table freshshop.product_categories drop constraint fk_product_product_category ;
alter table freshshop.categories drop constraint fk_category_parent_category ;

-- get_permissions_drop 

-- get_view_drop

-- get_schema_drop
drop table freshshop.users;
drop table freshshop.roles;
drop table freshshop.user_roles;
drop table freshshop.categories;
drop table freshshop.products;
drop table freshshop.tags;
drop table freshshop.sales_orders;
drop table freshshop.coupons;
drop table freshshop.product_tags;
drop table freshshop.cc_transactions;
drop table freshshop.sessions;
drop table freshshop.product_statuses;
drop table freshshop.product_categories;
drop table freshshop.order_products;
drop schema freshshop;
-- get_smallpackage_pre_sql 

create schema freshshop;

-- get_schema_create
create table freshshop.users (
   id          serial                   not null     ,
   email       varchar(255)             not null     ,
   first_name  varchar(255)             not null     ,
   last_name   varchar(255)             not null     ,
   active      bool                      default true,
   inserted_at timestamp with time zone not null     ,
   updated_at  timestamp with time zone not null     ,
   constraint pk_users primary key (id)
)   ;
create table freshshop.roles (
   id          serial                   not null,
   name        varchar(255)             not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_roles primary key (id)
)   ;
create table freshshop.user_roles (
   user_id     integer                  not null,
   role_id     integer                  not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_user_roles primary key (user_id,role_id)
)   ;
create table freshshop.categories (
   id          serial                   not null,
   name        varchar(255)             not null,
   parent_id   integer                          ,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_categories primary key (id)
)   ;
create table freshshop.products (
   id                serial                   not null      ,
   sku               varchar(255)             not null      ,
   name              varchar(255)             not null      ,
   description       text                                   ,
   product_status_id integer                  not null      ,
   regular_price     numeric                   default 0    ,
   discount_price    numeric                   default 0    ,
   quantity          integer                   default 0    ,
   taxable           bool                      default false,
   inserted_at       timestamp with time zone not null      ,
   updated_at        timestamp with time zone not null      ,
   constraint pk_products primary key (id)
)   ;
create table freshshop.tags (
   id          serial                   not null,
   name        varchar(255)             not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_tags primary key (id)
)   ;
create table freshshop.sales_orders (
   id          serial                   not null,
   order_date  date                     not null,
   total       numeric                  not null,
   coupon_id   integer                          ,
   session_id  varchar(255)             not null,
   user_id     integer                  not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_sales_orders primary key (id)
)   ;
create table freshshop.coupons (
   id          serial                   not null      ,
   code        varchar(255)             not null      ,
   description text                                   ,
   active      bool                      default true ,
   value       numeric                                ,
   multiple    bool                      default false,
   start_date  timestamp with time zone               ,
   end_date    timestamp with time zone               ,
   inserted_at timestamp with time zone not null      ,
   updated_at  timestamp with time zone not null      ,
   constraint pk_coupons primary key (id)
)   ;
create table freshshop.product_tags (
   product_id  integer                  not null,
   tag_id      integer                  not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_product_tags primary key (product_id,tag_id)
)   ;
create table freshshop.cc_transactions (
   id                 serial                   not null,
   code               varchar(255)                     ,
   order_id           integer                  not null,
   transdate          timestamp with time zone         ,
   processor          varchar(255)             not null,
   processor_trans_id varchar(255)             not null,
   amount             numeric                  not null,
   cc_num             varchar(255)                     ,
   cc_type            varchar(255)                     ,
   response           text                             ,
   inserted_at        timestamp with time zone not null,
   updated_at         timestamp with time zone not null,
   constraint pk_cc_transactions primary key (id)
)   ;
create table freshshop.sessions (
   id          varchar(255)             not null,
   data        text                             ,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_sessions primary key (id)
)   ;
create table freshshop.product_statuses (
   id          serial                   not null,
   name        varchar(255)             not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_product_statuses primary key (id)
)   ;
create table freshshop.product_categories (
   category_id integer                  not null,
   product_id  integer                  not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_product_categories primary key (category_id,product_id)
)   ;
create table freshshop.order_products (
   id          serial                   not null,
   order_id    integer                          ,
   sku         varchar(255)             not null,
   name        varchar(255)             not null,
   description text                             ,
   price       numeric                  not null,
   quantity    integer                  not null,
   subtotal    numeric                  not null,
   inserted_at timestamp with time zone not null,
   updated_at  timestamp with time zone not null,
   constraint pk_order_products primary key (id)
)   ;

-- get_view_create

-- get_permissions_create

-- get_inserts

-- get_smallpackage_post_sql

-- get_associations_create
alter table freshshop.sales_orders add constraint fk_coupon_order 
    foreign key (coupon_id)
    references freshshop.coupons (id) ;
alter table freshshop.product_tags add constraint fk_products_product_tags 
    foreign key (product_id)
    references freshshop.roducts (id) ;
alter table freshshop.product_tags add constraint fk_tags_product_tags 
    foreign key (tag_id)
    references freshshop.tags (id) ;
alter table freshshop.user_roles add constraint fk_roles_user_roles 
    foreign key (role_id)
    references freshshop.roles (id) ;
alter table freshshop.user_roles add constraint fk_users_user_roles 
    foreign key (user_id)
    references freshshop.users (id) ;
alter table freshshop.product_categories add constraint fk_category_products_categories 
    foreign key (category_id)
    references freshshop.categories (id) ;
alter table freshshop.sales_orders add constraint fk_user_sales_order 
    foreign key (user_id)
    references freshshop.users (id) ;
alter table freshshop.sales_orders add constraint fk_session_sales_order 
    foreign key (session_id)
    references freshshop.sessions (id) ;
alter table freshshop.products add constraint fk_product_statuses_product 
    foreign key (product_status_id)
    references freshshop.product_statuses (id) ;
alter table freshshop.order_products add constraint fk_sales_orders_order_products 
    foreign key (order_id)
    references freshshop.sales_orders (id) ;
alter table cc_transactions add constraint fk_sales_order_cc_transaction 
    foreign key (order_id)
    references sales_orders (id) ;
alter table freshshop.product_categories add constraint fk_product_product_category 
    foreign key (product_id)
    references freshshop.products (id) ;
alter table freshshop.categories add constraint fk_category_parent_category 
    foreign key (parent_id)
    references freshshop.categories (id) ;
