/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.models;



/**
 *
 * @author Patiphan Thonguam
 */
public class Homestay {

    String homestay_name;
    int user_id;
    String image;
    String img_cover;
    String hourse_document;
    String house_license_document;
    String telno;
    String category;
    String open_time;
    String close_time;
    String status;
    String description;
    String rule;

    public Homestay() {
    }

    public Homestay(String homestay_name, int user_id, String image, String img_cover, String hourse_document, String house_license_document, String telno, String category, String open_time, String close_time, String status, String description, String rule) {
        this.homestay_name = homestay_name;
        this.user_id = user_id;
        this.image = image;
        this.img_cover = img_cover;
        this.hourse_document = hourse_document;
        this.house_license_document = house_license_document;
        this.telno = telno;
        this.category = category;
        this.open_time = open_time;
        this.close_time = close_time;
        this.status = status;
        this.description = description;
        this.rule = rule;
    }

    public String getHomestay_name() {
        return homestay_name;
    }

    public void setHomestay_name(String homestay_name) {
        this.homestay_name = homestay_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImg_cover() {
        return img_cover;
    }

    public void setImg_cover(String img_cover) {
        this.img_cover = img_cover;
    }

    public String getHourse_document() {
        return hourse_document;
    }

    public void setHourse_document(String hourse_document) {
        this.hourse_document = hourse_document;
    }

    public String getHouse_license_document() {
        return house_license_document;
    }

    public void setHouse_license_document(String house_license_document) {
        this.house_license_document = house_license_document;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getClose_time() {
        return close_time;
    }

    public void setClose_time(String close_time) {
        this.close_time = close_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

}
