package com.belngtou;/**
 * Created by Administrator on 2017/9/19.
 */

/**
 * @author yll
 * @Description 服务器向浏览发送的消息，用此类发送
 * @Date 2017-09-19
 **/
public class SocketMessageResponse {
    private String message;

    public SocketMessageResponse() {
    }

    public SocketMessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
