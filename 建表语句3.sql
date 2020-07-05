/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/5 15:53:12                            */
/*==============================================================*/


drop table if exists Administrator;

drop table if exists FD_com_connect;

drop table if exists FF;

drop table if exists Full_discount;

drop table if exists Relationship_2;

drop table if exists Relationship_4;

drop table if exists Relationship_7;

drop table if exists address;

drop table if exists com_menu;

drop table if exists com_purchase;

drop table if exists commodity;

drop table if exists coupon;

drop table if exists evaluate;

drop table if exists limit_discount;

drop table if exists menu;

drop table if exists order_content;

drop table if exists order_message;

drop table if exists user;

/*==============================================================*/
/* Table: Administrator                                         */
/*==============================================================*/
create table Administrator
(
   admin_id             int not null,
   admin_name           varchar(20),
   admin_pwd            char(10),
   primary key (admin_id)
);

/*==============================================================*/
/* Table: FD_com_connect                                        */
/*==============================================================*/
create table FD_com_connect
(
   com_id               int not null,
   FD_id                int not null,
   FD_enddate           datetime,
   FD_startdate         datetime,
   primary key (com_id, FD_id)
);

/*==============================================================*/
/* Table: FF                                                    */
/*==============================================================*/
create table FF
(
   FF_id                int not null,
   FF_name              varchar(30),
   FF_describe          varchar(200),
   primary key (FF_id)
);

/*==============================================================*/
/* Table: Full_discount                                         */
/*==============================================================*/
create table Full_discount
(
   FD_id                int not null,
   FD_content           varchar(200),
   FD_com_count         int,
   FD_discount          numeric(2,2),
   FD_startdate         datetime,
   FD_enddate           datetime,
   primary key (FD_id)
);

/*==============================================================*/
/* Table: Relationship_2                                        */
/*==============================================================*/
create table Relationship_2
(
   ord_id               int not null,
   usr_id               int not null,
   primary key (ord_id, usr_id)
);

/*==============================================================*/
/* Table: Relationship_4                                        */
/*==============================================================*/
create table Relationship_4
(
   ord_id               int not null,
   cou_id               int not null,
   primary key (ord_id, cou_id)
);

/*==============================================================*/
/* Table: Relationship_7                                        */
/*==============================================================*/
create table Relationship_7
(
   purchase_id          int not null,
   com_id               int not null,
   primary key (purchase_id, com_id)
);

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   addr_id              int not null,
   usr_id               int,
   addr_pro             varchar(20),
   addr_city            varchar(20),
   addr_area            varchar(20),
   addr_current         varchar(50),
   primary key (addr_id)
);

/*==============================================================*/
/* Table: com_menu                                              */
/*==============================================================*/
create table com_menu
(
   com_id               int not null,
   men_id               int not null,
   describle            varchar(400),
   primary key (com_id, men_id)
);

/*==============================================================*/
/* Table: com_purchase                                          */
/*==============================================================*/
create table com_purchase
(
   purchase_id          int not null,
   admin_id             int,
   purchase_count       int,
   purchase_state       char(2),
   purchase_time        datetime,
   arrive_time          datetime,
   primary key (purchase_id)
);

/*==============================================================*/
/* Table: commodity                                             */
/*==============================================================*/
create table commodity
(
   com_id               int not null,
   LD_id                int,
   FF_id                int,
   com_name             varchar(50),
   com_price            numeric(17,2),
   com_vip_price        numeric(17,2),
   com_count            int,
   com_specification    char(20),
   com_describe         varchar(200),
   primary key (com_id)
);

/*==============================================================*/
/* Table: coupon                                                */
/*==============================================================*/
create table coupon
(
   cou_id               int not null,
   cou_content          varchar(200),
   cou_abl_price        numeric(17,2),
   cou_redu_price       numeric(17,2),
   cou_startdatet       datetime,
   cou_enddate          datetime,
   primary key (cou_id)
);

/*==============================================================*/
/* Table: evaluate                                              */
/*==============================================================*/
create table evaluate
(
   eva_content          varchar(500),
   eva_date             datetime,
   eva_star             char(1),
   eva_image            longblob,
   eva_order            int not null,
   ord_id               int,
   primary key (eva_order)
);

/*==============================================================*/
/* Table: limit_discount                                        */
/*==============================================================*/
create table limit_discount
(
   LD_id                int not null,
   LD_price             numeric(17,2),
   LD_count             int,
   LD_startdate         datetime,
   LD_enddate           datetime,
   primary key (LD_id)
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   men_id               int not null,
   men_name             varchar(50),
   men_materials        varchar(200),
   men_step             varchar(2000),
   men_image            longblob,
   primary key (men_id)
);

/*==============================================================*/
/* Table: order_content                                         */
/*==============================================================*/
create table order_content
(
   com_id               int not null,
   ord_id               int not null,
   Oc_count             int,
   Oc_price             numeric(17,2),
   Oc_discount          numeric(2,2),
   primary key (com_id, ord_id)
);

/*==============================================================*/
/* Table: order_message                                         */
/*==============================================================*/
create table order_message
(
   ord_id               int not null,
   ord_startprice       numeric(17,2),
   ord_endprice         numeric(17,2),
   ord_time             datetime,
   ord_state            char(2),
   primary key (ord_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   usr_id               int not null,
   usr_name             varchar(20),
   usr_gender           varchar(10),
   usr_pwd              char(10),
   usr_phonenumber      varchar(20),
   usr_email            varchar(20),
   usr_city             varchar(30),
   usr_registration_time datetime,
   usr_isvip            bool,
   usr_vip_ddl          datetime,
   primary key (usr_id)
);

alter table FD_com_connect add constraint FK_FD_com_connect foreign key (com_id)
      references commodity (com_id) on delete restrict on update restrict;

alter table FD_com_connect add constraint FK_FD_com_connect1 foreign key (FD_id)
      references Full_discount (FD_id) on delete restrict on update restrict;

alter table Relationship_2 add constraint FK_Relationship_2 foreign key (ord_id)
      references order_message (ord_id) on delete restrict on update restrict;

alter table Relationship_2 add constraint FK_Relationship_2_1 foreign key (usr_id)
      references user (usr_id) on delete restrict on update restrict;

alter table Relationship_4 add constraint FK_Relationship_4 foreign key (ord_id)
      references order_message (ord_id) on delete restrict on update restrict;

alter table Relationship_4 add constraint FK_Relationship_4_1 foreign key (cou_id)
      references coupon (cou_id) on delete restrict on update restrict;

alter table Relationship_7 add constraint FK_Relationship_7 foreign key (com_id)
      references commodity (com_id) on delete restrict on update restrict;

alter table Relationship_7 add constraint FK_Relationship_7_1 foreign key (purchase_id)
      references com_purchase (purchase_id) on delete restrict on update restrict;

alter table address add constraint FK_Relationship_3 foreign key (usr_id)
      references user (usr_id) on delete restrict on update restrict;

alter table com_menu add constraint FK_com_menu foreign key (com_id)
      references commodity (com_id) on delete restrict on update restrict;

alter table com_menu add constraint FK_com_menu1 foreign key (men_id)
      references menu (men_id) on delete restrict on update restrict;

alter table com_purchase add constraint FK_Relationship_6 foreign key (admin_id)
      references Administrator (admin_id) on delete restrict on update restrict;

alter table commodity add constraint FK_Relationship_1 foreign key (FF_id)
      references FF (FF_id) on delete restrict on update restrict;

alter table commodity add constraint FK_Relationship_8 foreign key (LD_id)
      references limit_discount (LD_id) on delete restrict on update restrict;

alter table evaluate add constraint FK_Relationship_5 foreign key (ord_id)
      references order_message (ord_id) on delete restrict on update restrict;

alter table order_content add constraint FK_order_content foreign key (com_id)
      references commodity (com_id) on delete restrict on update restrict;

alter table order_content add constraint FK_order_content1 foreign key (ord_id)
      references order_message (ord_id) on delete restrict on update restrict;

