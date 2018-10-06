USE `test` ;
-- テスト用のテーブル
DROP TABLE IF EXISTS `id_table1`;
CREATE TABLE `id_table1` (
  `id` varchar(10) NOT NULL,
  `hoge` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `id_table2`;
CREATE TABLE `id_table2` (
  `id` varchar(10) NOT NULL,
  `fuga` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- シーケンステーブル
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `seq_name` varchar(50) NOT NULL,
  `current_val` int(11) NOT NULL,
  `increment_val` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`seq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `sequence` VALUES ('seq_id_table1', '0', DEFAULT);
INSERT INTO `sequence` VALUES ('seq_id_table2', '0', DEFAULT);

-- nextval
DROP PROCEDURE IF EXISTS `nextseq`;
DELIMITER ;;
CREATE PROCEDURE `nextseq`(
  IN v_seq_name VARCHAR(50),
  OUT ret int(11))
begin
-- START
DECLARE exit handler for sqlexception
  BEGIN
    -- ERROR
  ROLLBACK;
END;

DECLARE exit handler for sqlwarning
 BEGIN
    -- WARNING
 ROLLBACK;
END;
 START TRANSACTION;
 update sequence set current_val = current_val + increment_val where seq_name = v_seq_name;
 select current_val into ret from sequence where seq_name = v_seq_name;
 COMMIT;
-- END
end
;;
DELIMITER ;

-- function
DROP function if exists `currseq`;
DELIMITER ;;
CREATE FUNCTION `currseq` (v_seq_name VARCHAR(50)) RETURNS int(11)
begin
 declare ret integer;
 set ret = 0; 
 select current_val into ret from sequence where seq_name = v_seq_name;
 return ret;
end
;;
DELIMITER ;
