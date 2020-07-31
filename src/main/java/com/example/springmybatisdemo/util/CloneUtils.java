package com.example.springmybatisdemo.util;

import java.io.*;

public class CloneUtils {
    /**
     * 对任意可序列化实例实现深拷贝
     * @param obj 待拷贝实例
     * @return 拷贝结果
     * */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T   obj){
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}
