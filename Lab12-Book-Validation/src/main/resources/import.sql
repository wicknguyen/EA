INSERT INTO Book(title, ISBN, author, price) VALUES('Spring', '1234567', 'Josh Long', 97.7);
INSERT INTO Book(title, ISBN, author, price) VALUES('Hibernate', '77777777', 'Vlad', 77.7);

INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);


INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (1,'admin','$2a$10$ZNkwte139xDVivH6FEmhHeu54V8js6nxXulxfjNh7UDQ57McBIez2','2019-01-15 22:14:54');
INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (2,'user','$2a$10$40YaG7OfjVpLITEc3kAbwukHz4Qxuvo8abaBPssLJEQOGuPE6vM1O','2019-05-15 22:14:54');

INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 2);
