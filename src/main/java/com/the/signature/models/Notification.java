/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.the.signature.models;

/**
 *
 * @author P8H61
 */
public class Notification {

    int noti;
    int user_id;
    int homestay_id;
    String message;
    int read;

    public Notification() {
    }

    public Notification(int noti, int user_id, int homestay_id, String message, int read) {
        this.noti = noti;
        this.user_id = user_id;
        this.homestay_id = homestay_id;
        this.message = message;
        this.read = read;
    }

    public int getNoti() {
        return noti;
    }

    public void setNoti(int noti) {
        this.noti = noti;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getHomestay_id() {
        return homestay_id;
    }

    public void setHomestay_id(int homestay_id) {
        this.homestay_id = homestay_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Notification{" + "noti=" + noti + ", user_id=" + user_id + ", homestay_id=" + homestay_id + ", message=" + message + ", read=" + read + '}';
    }

}
