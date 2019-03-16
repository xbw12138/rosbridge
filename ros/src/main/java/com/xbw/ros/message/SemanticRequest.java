package com.xbw.ros.message;

/**
 * Created by xbw on 19-1-15.
 */
@MessageType(string = "std_msgs/String")
public class SemanticRequest extends Message {
    public  SemanticRequest(String args) {
        jsonStr = args;
    }

    public String jsonStr;
}
