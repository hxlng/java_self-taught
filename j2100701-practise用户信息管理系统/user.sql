/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`id` int ,
	`name` varchar ,
	`sex` tinyint ,
	`address` varchar ,
	`phone` varchar ,
	`email` varchar ,
	`username` varchar ,
	`password` varchar ,
	`deleted` tinyint ,
	`updatetime` timestamp 
); 
insert into `user` (`id`, `name`, `sex`, `address`, `phone`, `email`, `username`, `password`, `deleted`, `updatetime`) values('1','张三1515','1','四川省','18999999999','zhangsan@qq.com','zhangsan','123456','0','2021-09-02 19:14:01');
insert into `user` (`id`, `name`, `sex`, `address`, `phone`, `email`, `username`, `password`, `deleted`, `updatetime`) values('2','李四','0','重庆市','18988888888','lisi@qq.com','lisi','123456','0','2021-08-31 15:55:31');
insert into `user` (`id`, `name`, `sex`, `address`, `phone`, `email`, `username`, `password`, `deleted`, `updatetime`) values('3','王五','0','四川省','18977777777','wangwu@qq.com','wangwu','123456','0','2021-08-31 15:55:31');
insert into `user` (`id`, `name`, `sex`, `address`, `phone`, `email`, `username`, `password`, `deleted`, `updatetime`) values('13','王明菊','0','成都','','','','','0','2021-09-02 09:17:14');
insert into `user` (`id`, `name`, `sex`, `address`, `phone`, `email`, `username`, `password`, `deleted`, `updatetime`) values('14','唐山','0','斗罗大陆','12255418415','xinhu998@gmail.com','lisi','123456','0','2021-09-02 09:18:00');
insert into `user` (`id`, `name`, `sex`, `address`, `phone`, `email`, `username`, `password`, `deleted`, `updatetime`) values('15','虚竹1','0','灵鹫宫','1256461385','nvjfv@qq.com','15551','juhug','0','2021-09-02 19:12:16');
insert into `user` (`id`, `name`, `sex`, `address`, `phone`, `email`, `username`, `password`, `deleted`, `updatetime`) values('16','段誉2','0','大理','456186135','daunyu','','','0','2021-09-02 19:11:41');
