package com.kp.testingapp;

import kotlinx.coroutines.flow.StateFlow;

public class JavaClass {
//    public static void main(String[] args) {
//        AppUtils.install();
//        AppUtils.INSTANCE.getName();
//    }

    public static void main(String[] args) {
        Session session = new Session("name","se");
        String name = session.getName();
        String sessionID = session.sessionID;
    }

}
