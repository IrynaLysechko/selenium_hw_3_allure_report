package com.epam.utils;

import com.epam.entity.Message;
import com.epam.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonReader {
    private static final Logger logger = LogManager.getLogger(PropertyFile.class);
    private static final String userFilePath = "src\\main\\resources\\entity\\user.json";
    private static final String messageFilePath = "src\\main\\resources\\entity\\message.json";


    public static List<User> getUserList() {
        User[] users = new User[0];
        try {
            users = new ObjectMapper().readValue(new File(userFilePath), User [].class);
        } catch (IOException e) {
            logger.error("Value reading failing");
        }
        return Arrays.asList(users);
    }

    public static Message getMessage() {
        Message message = new Message();
        try {
            message = new ObjectMapper().readValue(new File(messageFilePath), Message.class);
        } catch (IOException e) {
            logger.error("Value reading failing");
        }
        return message;
    }
}
