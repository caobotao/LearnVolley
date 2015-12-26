package com.example.caobotao.checkpermissionincode;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by caobotao on 15-10-6.
 */
public class Hello {
    public static final String PERMISSION_SAY_HELLO = "com.example.caobotao.checkpermissionincode.permission.SAY_HELLO";
    public static void sayHello(Context context){
        int result = context.checkCallingOrSelfPermission(PERMISSION_SAY_HELLO);
        if(result != PackageManager.PERMISSION_GRANTED){
            throw new SecurityException("执行sayHello需要有com.example.caobotao.checkpermissionincode.permission.SAY_HELLO权限");
        }
        System.out.println("jikexueyuan");
    }
}
