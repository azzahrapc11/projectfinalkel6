/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100417
 Source Host           : localhost:3306
 Source Schema         : perpustakaan_team6

 Target Server Type    : MySQL
 Target Server Version : 100417
 File Encoding         : 65001

 Date: 11/02/2022 19:36:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_buku
-- ----------------------------
DROP TABLE IF EXISTS `tbl_buku`;
CREATE TABLE `tbl_buku`  (
  `bk_kd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bk_judul` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bk_pengarang` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bk_penerbit` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bk_tahun_terbit` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bk_stok` int(11) NULL DEFAULT NULL,
  `bk_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bk_kd`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_buku
-- ----------------------------
INSERT INTO `tbl_buku` VALUES ('BK0001', 'Tulisan Sastra', 'Tenderlova', 'Lovrinz', '2020', 100, 'Tersedia');
INSERT INTO `tbl_buku` VALUES ('BK0002', 'Narasi', 'Tenderlova', 'Lovrinz', '2021', 100, 'Tersedia');
INSERT INTO `tbl_buku` VALUES ('BK0003', 'Dear Natta', 'Tenderlova', 'Lovrinz', '2020', 100, 'Tersedia');
INSERT INTO `tbl_buku` VALUES ('BK0004', 'Malang Untold Story', 'Tenderlova', 'Lovrinz', '2021', 100, 'Tersedia');

-- ----------------------------
-- Table structure for tbl_detil_transaksi
-- ----------------------------
DROP TABLE IF EXISTS `tbl_detil_transaksi`;
CREATE TABLE `tbl_detil_transaksi`  (
  `trans_kd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bk_kd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bk_judul` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_qty` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`trans_kd`, `bk_kd`) USING BTREE,
  INDEX `FK_buku`(`bk_kd`) USING BTREE,
  CONSTRAINT `FK_buku` FOREIGN KEY (`bk_kd`) REFERENCES `tbl_buku` (`bk_kd`) ON DELETE NO ACTION ON UPDATE RESTRICT,
  CONSTRAINT `FK_transaksi` FOREIGN KEY (`trans_kd`) REFERENCES `tbl_transaksi` (`trans_kd`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_detil_transaksi
-- ----------------------------
INSERT INTO `tbl_detil_transaksi` VALUES ('TR0001', 'BK0001', 'Tulisan Sastra', 1);
INSERT INTO `tbl_detil_transaksi` VALUES ('TR0001', 'BK0003', 'Dear Natta', 1);
INSERT INTO `tbl_detil_transaksi` VALUES ('TR0002', 'BK0004', 'Malang Untold Story', 2);

-- ----------------------------
-- Table structure for tbl_member
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member`;
CREATE TABLE `tbl_member`  (
  `mb_kd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mb_nama` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mb_no_hp` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mb_alamat` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mb_kd`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_member
-- ----------------------------
INSERT INTO `tbl_member` VALUES ('MB0001', 'Jamal', '089123456789', 'Jakarta');
INSERT INTO `tbl_member` VALUES ('MB0002', 'Sastra', '081111111111', 'Jakarta');
INSERT INTO `tbl_member` VALUES ('MB0003', 'Gaung', '089999999999', 'Jakarta');

-- ----------------------------
-- Table structure for tbl_transaksi
-- ----------------------------
DROP TABLE IF EXISTS `tbl_transaksi`;
CREATE TABLE `tbl_transaksi`  (
  `trans_kd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `trans_tgl_transaksi` timestamp(0) NULL DEFAULT NULL,
  `mb_kd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trans_tgl_pinjam` timestamp(0) NULL DEFAULT NULL,
  `trans_tgl_kembali` timestamp(0) NULL DEFAULT NULL,
  `status_pengembalian` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`trans_kd`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_transaksi
-- ----------------------------
INSERT INTO `tbl_transaksi` VALUES ('TR0001', '2022-02-11 17:49:14', 'MB0001', '2022-02-11 17:49:14', '2022-02-11 17:49:14', 'Sudah');
INSERT INTO `tbl_transaksi` VALUES ('TR0002', '2022-02-11 17:51:21', 'MB0002', '2022-02-11 17:51:21', '2022-02-11 17:51:21', 'Sudah');

SET FOREIGN_KEY_CHECKS = 1;
