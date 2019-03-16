package com.xbw.ros.message;

/**
 * Created by xbw on 19-1-15.
 */
@MessageType(string = "std_msgs/String")
public class SemanticResponse extends Message {
    public String result;
}
