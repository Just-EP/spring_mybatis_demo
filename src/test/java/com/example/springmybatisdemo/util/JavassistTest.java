package com.example.springmybatisdemo.util;

import javassist.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JavassistTest {

    @Test
    public void test(){
        try {
            ClassPool pool = ClassPool.getDefault();
//            CtClass cc = pool.get("com.example.springmybatisdemo.util.Demo");
            CtClass cc = pool.makeClass("com.example.springmybatisdemo.util.Demo1");
            CtField name = new CtField(pool.get("java.lang.String"), "name", cc);
            cc.addField(name,CtField.Initializer.constant("shit"));
            name.setModifiers(Modifier.PRIVATE);
            CtMethod setName = CtNewMethod.setter("setName", name);
            CtMethod getName = CtNewMethod.getter("getName", name);
            cc.addMethod(setName);
            cc.addMethod(getName);
            cc.writeFile("D:\\ok");
            pool.appendClassPath("D:\\ok\\");
            CtClass ctClass = pool.get("com.example.springmybatisdemo.util.Demo1");
            Class<?> aClass = ctClass.toClass();
            String name1 = aClass.getName();
            Object newInstance = aClass.newInstance();
            System.out.println(newInstance);
        } catch (NotFoundException | CannotCompileException | IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
