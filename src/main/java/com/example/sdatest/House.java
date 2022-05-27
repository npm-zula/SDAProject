package com.example.sdatest;

public class House {
 private String hNo;
 private String blockN;
 private String desc;
 private String type;

 public String gethNo() {
  return hNo;
 }

 public void sethNo(String hNo) {
  this.hNo = hNo;
 }

 public String getBlockN() {
  return blockN;
 }

 public void setBlockN(String blockN) {
  this.blockN = blockN;
 }

 public String getDesc() {
  return desc;
 }

 public void setDesc(String desc) {
  this.desc = desc;
 }

 public String getType() {
  return type;
 }

 public void setType(String type) {
  this.type = type;
 }

 public House() {
 }

 public House(String hNo, String blockN, String desc, String type) {
  this.hNo = hNo;
  this.blockN = blockN;
  this.desc = desc;
  this.type = type;
 }
}
