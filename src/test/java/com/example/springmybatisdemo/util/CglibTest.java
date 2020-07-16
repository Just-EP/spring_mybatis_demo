package com.example.springmybatisdemo.util;

import com.example.springmybatisdemo.domain.BaiKeBean;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibTest{
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BaiKeBean.class);

        Callback methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.err.println("原方法名是 ： " + method.getName());
                System.err.println("原方法声明的类为 " + method.getDeclaringClass());
                Class<?>[] parameterTypes = method.getParameterTypes();
                Object o1 = methodProxy.invokeSuper(o, objects);
                System.err.println("我调用结束了");
                return o1;
            }
        };
        CallbackFilter callbackFilter = new CallbackFilter() {

            @Override
            public int accept(Method method) {
                int flag = 0;
                if ("getStuName".equals(method.getName())) {
                    System.err.println("我将此方法过滤掉了，不对该方法进行拦截");
                    return 1;
                }
                return 0;
            }
        };
        Callback[] callbacks = new Callback[] { methodInterceptor, NoOp.INSTANCE };
        enhancer.setCallbackFilter(callbackFilter);
        enhancer.setCallbacks(callbacks);
        BaiKeBean bean = (BaiKeBean)enhancer.create();
        bean.testMethod("Jack");
        System.out.println(bean.count);
    }
}
