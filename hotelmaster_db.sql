
/*Table structure for table `account` */

CREATE TABLE `account` (
  `account_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_level` int(11) NOT NULL DEFAULT '0',
  `first_name` varchar(75) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(75) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(254) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `facebook_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `booking` */

CREATE TABLE `booking` (
  `booking_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` int(11) unsigned NOT NULL,
  `room_id` int(11) unsigned NOT NULL,
  `booking_date` date NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date NOT NULL,
  `num_guests` int(11) unsigned NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FK_booking_account_id` (`account_id`),
  KEY `FK_booking_room_id` (`room_id`),
  CONSTRAINT `FK_booking_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FK_booking_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `features` */

CREATE TABLE `features` (
  `feature_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `feature_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`feature_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `room` */

CREATE TABLE `room` (
  `room_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `room_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `floor` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `price_per_night` decimal(6,2) NOT NULL,
  `max_guests` int(1) unsigned NOT NULL,
  `desc` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `room_features` */

CREATE TABLE `room_features` (
  `room_id` int(11) unsigned NOT NULL,
  `feature_id` int(11) unsigned NOT NULL,
  KEY `FK_room_features_room_id` (`room_id`),
  KEY `FK_room_features_feature_id` (`feature_id`),
  CONSTRAINT `FK_room_features_feature_id` FOREIGN KEY (`feature_id`) REFERENCES `features` (`feature_id`),
  CONSTRAINT `FK_room_features_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `room_images` */

CREATE TABLE `room_images` (
  `image_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `room_id` int(11) unsigned NOT NULL,
  `image` longblob NOT NULL,
  `title` varchar(75) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thumbnail` int(1) DEFAULT '0',
  PRIMARY KEY (`image_id`),
  KEY `FK_room_images_room_id` (`room_id`),
  CONSTRAINT `FK_room_images_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;
