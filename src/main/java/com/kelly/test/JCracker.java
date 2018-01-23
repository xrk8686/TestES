package com.kelly.test;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JCracker {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        // 解压jar包后的路径
        pool.insertClassPath("C:\\Dev\\jprofiler10.0.3\\bin\\jprofiler.jar");

        CtClass cc = pool.get("com.ejt.framework.e.c");

        CtClass[] param = new CtClass[3];
        param[0] = pool.get("java.lang.String");
        param[1] = pool.get("java.lang.String");
        param[2] = pool.get("java.lang.String");

        assert cc != null;
        CtMethod method = cc.getDeclaredMethod("a", param);

        assert method != null;
        method.setBody("{return 1;}");

        cc.writeFile("src/resources");
    }
}
