insert into shop_dt_manager_gateway.role (id, name, description, created_date, updated_date, deleted_at)
values  ('6186e678-0d55-4e0a-9e13-1c3b9f492f54', 'Customer', 'Customer role', '2023-05-27 10:30:00', '2023-05-27 10:32:00', null),
        ('7d03df9d-b2b2-4db2-86a9-0e8f7f2b6f2b', 'Admin', 'Administrator role', '2023-05-27 09:15:00', '2023-05-27 09:20:00', null),
        ('f792e98c-456e-4bbd-868a-29ffdd1222a9', 'Employee', 'Employee role', '2023-05-27 11:45:00', '2023-05-27 11:50:00', null);

insert into shop_dt_manager_gateway.user (id, username, email, password, role_id, created_date, updated_date, deleted_at)
values  ('84fe8b97-209d-4c81-98a0-1637d5c45a23', 'john_doe', 'john.doe@example.com', 'password123', '7d03df9d-b2b2-4db2-86a9-0e8f7f2b6f2b', '2023-05-27 09:30:00', '2023-05-27 09:32:00', null),
        ('bb7894ca-03a5-4e22-8ec6-4c7d33d33fd4', 'tienpm', 'minhtienit1997@gmail.com', 'password456', '6186e678-0d55-4e0a-9e13-1c3b9f492f54', '2023-05-27 10:00:00', '2023-05-27 14:37:37', null),
        ('c73526ef-0c49-4d24-9b4c-8e2be3f8b1e9', 'alex_wong', 'alex.wong@example.com', 'password789', 'f792e98c-456e-4bbd-868a-29ffdd1222a9', '2023-05-27 11:15:00', '2023-05-27 11:20:00', null);

insert into shop_dt_manager_gateway.manufacturer (id, name, description, created_date, updated_date, deleted_at)
values  ('01a0f498-d5d9-44f5-bcb2-25426c7f13d8', 'Sony', 'Entertainment company', '2023-05-27 11:30:00', '2023-05-27 14:53:46', null),
        ('72924ef7-d5dd-4c6f-a4af-50877ac0ed7d', 'Samsung', 'Electronics company', '2023-05-27 10:15:00', '2023-05-27 10:20:00', null),
        ('e95ef9a2-90d2-48bc-b202-9b8e5c180830', 'Apple', 'Technology company', '2023-05-27 09:45:00', '2023-05-27 09:50:00', null);

insert into shop_dt_manager_gateway.product (id, name, description, status, price, total, manufacturer_id, created_date, updated_date, deleted_at)
values  ('06f8a319-2bb9-47c5-80a7-6d34c7f0e6a2', 'Samsung Galaxy S21 Plus', 'Premium smartphone with a large display', 'Available', 99900, 40, '72924ef7-d5dd-4c6f-a4af-50877ac0ed7d', '2023-05-27 14:30:00', '2023-05-27 14:35:00', null),
        ('1f740ed9-840e-4c1d-9a79-2b3635c4f535', 'Samsung Galaxy A52', 'Mid-range smartphone with a versatile camera setup', 'Available', 49900, 60, '72924ef7-d5dd-4c6f-a4af-50877ac0ed7d', '2023-05-27 16:00:00', '2023-05-27 16:05:00', null),
        ('35a7f09f-67ad-4e2d-899d-d1ad5b32e71d', 'iPhone 12 Mini', 'Compact iPhone with powerful performance', 'Available', 79900, 35, 'e95ef9a2-90d2-48bc-b202-9b8e5c180830', '2023-05-27 15:30:00', '2023-05-27 15:35:00', null),
        ('c0b267d5-2ff7-4de6-a4d2-5a76f1c06b0c', 'Sony Xperia 5 II', 'Compact flagship smartphone with a 120Hz display', 'Available', 89900, 25, '01a0f498-d5d9-44f5-bcb2-25426c7f13d8', '2023-05-27 16:30:00', '2023-05-27 16:35:00', null),
        ('dfe8a545-356b-46e1-9322-87d6c84d1e4e', 'Sony Xperia 1 III', 'Flagship smartphone with a 4K OLED display', 'Available', 119900, 30, '01a0f498-d5d9-44f5-bcb2-25426c7f13d8', '2023-05-27 15:00:00', '2023-05-27 15:05:00', null),
        ('ef2e36a3-7b47-42be-96f5-78d9b05140fb', 'iPhone 13', 'Latest iPhone model with powerful features', 'Available', 109900, 50, 'e95ef9a2-90d2-48bc-b202-9b8e5c180830', '2023-05-27 14:00:00', '2023-05-27 14:05:00', null);
