/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.models;

import com.the.signature.utils.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.rsa.RSACore;

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
    String province;
    String district;
    String sub_district;
    String address_detail;
    String telno;
    String category;
    String open_time;
    String close_time;
    String status;
    String description;
    String rule;
    int price;

    public Homestay() {
    }

    public Homestay(String homestay_name, int user_id, String image, String img_cover, String hourse_document, String house_license_document, String province, String district, String sub_district, String address_detail, String telno, String category, String open_time, String close_time, String status, String description, String rule, int price) {
        this.homestay_name = homestay_name;
        this.user_id = user_id;
        this.image = image;
        this.img_cover = img_cover;
        this.hourse_document = hourse_document;
        this.house_license_document = house_license_document;
        this.province = province;
        this.district = district;
        this.sub_district = sub_district;
        this.address_detail = address_detail;
        this.telno = telno;
        this.category = category;
        this.open_time = open_time;
        this.close_time = close_time;
        this.status = status;
        this.description = description;
        this.rule = rule;
        this.price = price;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSub_district() {
        return sub_district;
    }

    public void setSub_district(String sub_district) {
        this.sub_district = sub_district;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public static boolean isPDFFile(String filetype) {
        boolean isPDF = false;
        if (filetype.endsWith(".pdf") || filetype.endsWith(".PDF")) {
            isPDF = true;
        } else {
            isPDF = false;
        }

        return isPDF;
    }
    
    public static boolean isJPGFile(String filetype){
        boolean isJPG = false;
        if (filetype.endsWith(".jpg") || filetype.endsWith(".JPG") || filetype.endsWith(".jpeg") || filetype.endsWith(".JPEG")) {
            isJPG = true;
        } else {
            isJPG = false;
        }

        return isJPG;
    }
    
    public static boolean isPNGFile(String filetype){
        boolean isPNG = false;
        if (filetype.endsWith(".png") || filetype.endsWith(".PNG")) {
            isPNG = true;
        } else {
            isPNG = false;
        }

        return isPNG;
    }

    public static boolean checkHomestayNameRepeat(Map<String, Object> data) {
        boolean checkNameRepeat = true;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select Homestay_name from signature.Homestays where Homestay_name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, (String) data.get("Homestay_name"));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String homestayName = rs.getString("Homestay_name");
                if (homestayName.equalsIgnoreCase((String) data.get("Homestay_name"))) {
                    checkNameRepeat = false;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return checkNameRepeat;
    }

    public static int createHomestay(Map<String, Object> data) {
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "insert into signature.Homestays "
                    + "(User_id, Homestay_name, Content_image, Cover_img, Hourse_document"
                    + ", Homestay_License_document,Province, District, Sub_district,Address_detail "
                    + ", Description, Rule, Telno, Category, Open_time, Close_time, Status, Price)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, (int) data.get("User_id"));
            pstmt.setString(2, (String) data.get("Homestay_name"));
            pstmt.setString(3, (String) data.get("Content_image"));
            pstmt.setString(4, (String) data.get("Cover_img"));
            pstmt.setString(5, (String) data.get("Hourse_document"));
            pstmt.setString(6, (String) data.get("Homestay_License_document"));
            pstmt.setString(7, (String) data.get("Province"));
            pstmt.setString(8, (String) data.get("District"));
            pstmt.setString(9, (String) data.get("Sub_district"));
            pstmt.setString(10, (String) data.get("Address_detail"));
            pstmt.setString(11, (String) data.get("Description"));
            pstmt.setString(12, (String) data.get("Rule"));
            pstmt.setString(13, (String) data.get("Telno"));
            pstmt.setString(14, (String) data.get("Category"));
            pstmt.setString(15, (String) data.get("Open_time"));
            pstmt.setString(16, (String) data.get("Close_time"));
            pstmt.setString(17, (String) data.get("Status"));
            pstmt.setInt(18, Integer.valueOf((String) data.get("Price")));
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static ArrayList<Homestay> getHomestayByUserId(int userId){
        ArrayList<Homestay> homestayList = null;
        try{
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select * from signature.Homestays where User_id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                if (homestayList == null){
                    homestayList = new ArrayList<>();
                }
                String homestayName = rs.getString("Homestay_name");
                int user_id = rs.getInt("User_id");
                String image = rs.getString("Content_image");
                String img_cover = rs.getString("Cover_img");
                String hourse_document = rs.getString("Hourse_document");
                String house_license_document = rs.getString("Homestay_License_document");
                String province = rs.getString("Province");
                String district = rs.getString("District");
                String sub_district = rs.getString("Sub_district");
                String address_detail = rs.getString("Address_detail");
                String telno = rs.getString("Telno");
                String category = rs.getString("Category");
                String open_time = rs.getString("Open_time");
                String close_time = rs.getString("Close_time");
                String status = rs.getString("Status");
                String description = rs.getString("Description");
                String rule = rs.getString("Rule");
                int price = rs.getInt("Price");
                Homestay homestay = new Homestay(homestayName, user_id, image, img_cover,hourse_document,house_license_document,
                                                 province,district,sub_district,address_detail,telno,category,open_time,close_time,
                                                 status,description,rule,price
                                                );
                homestayList.add(homestay);
            }
            return homestayList;
        }catch(SQLException ex){
            Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
        }
        return homestayList;
    }
    
    
    public static ArrayList<Homestay> getApprovedHomestayLists(){
        ArrayList<Homestay> homestayList = null;
        return homestayList;
    }
    @Override
    public String toString() {
        return "Homestay{" + "homestay_name=" + homestay_name + ", user_id=" + user_id + ", image=" + image + ", img_cover=" + img_cover + ", hourse_document=" + hourse_document + ", house_license_document=" + house_license_document + ", telno=" + telno + ", category=" + category + ", open_time=" + open_time + ", close_time=" + close_time + ", status=" + status + ", description=" + description + ", rule=" + rule + '}';
    }

}
