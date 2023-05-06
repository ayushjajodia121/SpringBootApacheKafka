package com.jajodia.kafka.springboot.payload;

import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class EmailRequestModel {

    private List<String> recipient;
    private String subject;
    private String content;
    private String fileName;
    private File file;

    @Override
    public String toString() {
        return "EmailRequestModel{" +
                "recipient=" + recipient +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", file=" + file +
                '}';
    }

}
