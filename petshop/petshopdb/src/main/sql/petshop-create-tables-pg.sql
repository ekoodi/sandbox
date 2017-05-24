create table Customer (
   Id                   SERIAL,
   FirstName            varchar(40)         not null,
   LastName             varchar(40)         not null,
   City                 varchar(40)         null,
   Country              varchar(40)         null,
   Phone                varchar(20)         null,
   constraint PK_CUSTOMER primary key (Id)
)
;

create index IndexCustomerName on Customer (
LastName ASC,
FirstName ASC
)
;

create table Purchase (
   Id                   SERIAL,
   PurchaseDate            timestamp  without time zone  not null default now()::timestamp,
   PurchaseNumber          varchar(10)         null,
   CustomerId           int                  not null,
   TotalAmount          decimal(12,2)        null default 0,
   constraint PK_Purchase primary key (Id)
);

create index IndexPurchaseCustomerId on Purchase (
CustomerId ASC
)
;

create index IndexPurchasePurchaseDate on Purchase (
PurchaseDate ASC
)
;

create table PurchaseItem (
   Id                   SERIAL,
   PurchaseId              int                  not null,
   ProductId            int                  not null,
   UnitPrice            decimal(12,2)        not null default 0,
   Quantity             int                  not null default 1,
   constraint PK_PurchaseITEM primary key (Id)
)
;

create index IndexPurchaseItemPurchaseId on PurchaseItem (
PurchaseId ASC
)
;

create index IndexPurchaseItemProductId on PurchaseItem (
ProductId ASC
)
;

create table Product (
   Id                   SERIAL,
   ProductName          varchar(50)         not null,
   SupplierId           int                  not null,
   UnitPrice            decimal(12,2)        null default 0,
   Package              varchar(30)         null,
   IsDiscontinued       boolean             not null default false,
   constraint PK_PRODUCT primary key (Id)
)
;

create index IndexProductSupplierId on Product (
SupplierId ASC
)
;

create index IndexProductName on Product (
ProductName ASC
)
;

create table Supplier (
   Id                   SERIAL,
   CompanyName          varchar(40)         not null,
   ContactFirstName     varchar(50)         null,
   ContactLastName     varchar(50)         null,
   ContactTitle         varchar(40)         null,
   City                 varchar(40)         null,
   Country              varchar(40)         null,
   Phone                varchar(30)         null,
   Fax                  varchar(30)         null,
   constraint PK_SUPPLIER primary key (Id)
)
;

create index IndexSupplierName on Supplier (
CompanyName ASC
)
;

create index IndexSupplierCountry on Supplier (
Country ASC
)
;

alter table Purchase
   add constraint FK_PURCHASE_REFERENCE_CUSTOMER foreign key (CustomerId)
      references Customer (Id)
;

alter table PurchaseItem
   add constraint FK_PURCHASEITE_REFERENCE_PURCHASE foreign key (PurchaseId)
      references Purchase (Id)
;

alter table PurchaseItem
   add constraint FK_PURCHASEITE_REFERENCE_PRODUCT foreign key (ProductId)
      references Product (Id)
;

alter table Product
   add constraint FK_PRODUCT_REFERENCE_SUPPLIER foreign key (SupplierId)
      references Supplier (Id)
;
