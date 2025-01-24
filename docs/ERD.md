CREATE TABLE `product` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`name` varchar(50),
`price` integer,
`stock` integer,
`created_at` timestamp,
`updated_at` timestamp
);

CREATE TABLE `user` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`name` varchar(50),
`email` varchar(50),
`password` varchar(50),
`created_at` timestamp,
`updated_at` timestamp
);

CREATE TABLE `order` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`user_id` bigint,
`order_amount` integer,
`order_state` varchar(50),
`orderd_at` timestamp,
`crated_at` timestamp,
`updated_at` timestamp
);

CREATE TABLE `order_item` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`order_id` bigint,
`product_id` bigint,
`product_quantity` integer,
`product_amount` integer,
`created_at` timestamp,
`updated_at` timestamp
);

CREATE TABLE `user_transaction` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`user_id` bigint,
`payment_id` bigint,
`transaction_amount` integer,
`transaction_type` integer,
`balance` integer,
`created_at` timestamp,
`updated_at` timestamp
);

CREATE TABLE `coupon` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`code` varchar(50),
`discount_rate` float,
`started_at` datetime,
`end_at` datetime,
`max_issue_count` integer,
`issue_count` integer,
`created_at` timestamp,
`updated_at` timestamp
);

CREATE TABLE `user_coupon` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`user_id` bigint,
`coupon_id` bigint,
`issued_at` timestamp,
`used_at` timestamp
);

CREATE TABLE `payment` (
`id` bigint PRIMARY KEY AUTO_INCREMENT,
`order_id` bigint,
`payment_at` timestamp,
`payment_method` varchar(50),
`payment_status` varchar(50),
`payment_amount` Integer,
`user_coupon_id` bigint,
`created_at` timestamp,
`updated_at` timestamp
);
