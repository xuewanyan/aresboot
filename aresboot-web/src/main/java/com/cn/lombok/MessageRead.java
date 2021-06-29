package com.cn.lombok;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

@Data // 此时程序会生成一个双参构造
@Builder
public class MessageRead { // 在此时进行异常的控制
    @NonNull
    private String filePath;
    @NonNull
    private String fileName;

    @SneakyThrows
    public String loag(){
        @Cleanup Scanner scanner =
                new Scanner(new FileInputStream(new File(this.filePath + File.separator + this.fileName)));
        scanner.useDelimiter("\n");
        StringBuffer id = new StringBuffer();
        while (scanner.hasNext()){
            id.append(scanner.next());
        }
        return id.toString();
    }
}
