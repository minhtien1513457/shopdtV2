use shop_dt_manager_gateway;

CREATE TABLE IF NOT EXISTS `role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` tinytext,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(255) NOT NULL COMMENT 'use to call api',
  `email` varchar(255) NOT NULL COMMENT 'send username, access_key to this email',
  `password` varchar(255) NOT NULL,
  `role_id`  varchar(50) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_user_2_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  UNIQUE KEY `account_unique` (`username`),
  UNIQUE KEY `email_unique` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `manufacturer` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` tinytext,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `product` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` tinytext,
  `status` varchar(50) NOT NULL,
  `price`   bigint NOT NULL,
  `total`   int(11) NOT NULL,
  `manufacturer_id`  varchar(50) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_product_2_manufacturer` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cart` (
  `id` varchar(50) NOT NULL,
  `user_id`  varchar(50) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_cart_2_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cart_product` (
  `id` varchar(50) NOT NULL,
  `product_id` varchar(50) NOT NULL,
  `cart_id` varchar(50) NOT NULL,
  `amount`  int(11) UNSIGNED,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_cart_product_2_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_cart_product_2_cart` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
