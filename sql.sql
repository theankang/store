-- 使用MySQL建立数据库store_db
--用户名 root
--密码 1
CREATE TABLE `teams` (
`id` int(6) NOT NULL AUTO_INCREMENT,
`name` varchar(40) NOT NULL,
`rating` int(6) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;