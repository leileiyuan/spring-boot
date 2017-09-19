package com.belngtou;/**
 * Created by Administrator on 2017/9/19.
 */

/**
 * @author yl;
 * @Description 浏览器向服务端发送消息  用该类接收
 * @Date 2017-09-19
 **/
public class SocketMessageRequest {
    public String message;

    public String date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
