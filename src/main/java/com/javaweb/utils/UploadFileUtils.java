package com.javaweb.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class UploadFileUtils {

  public void writeOrUpdate(String path, byte[] bytes) {
    String projectPath = System.getProperty("user.dir");
    String fullPath =
        projectPath + "/src/main/resources/static" + path;

    File file = new File(StringUtils.substringBeforeLast(fullPath, "/"));
    if (!file.exists()) {
      file.mkdirs();
    }

    try (FileOutputStream fop = new FileOutputStream(fullPath)) {
      fop.write(bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
