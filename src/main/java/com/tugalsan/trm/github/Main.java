package com.tugalsan.trm.github;

import com.tugalsan.api.coronator.client.*;

//WHEN RUNNING ON TEMINAL, ALL DEPENDENCIES WHILL BE READ FROM MAVEN, HENCE NOT PROBLEM
//WHEN RUNNING IN NETBEANS, ALL DEPENDENCIES SHOULD HAVE TARGET FOLDER!
public class Main {

    public static void main(String[] args) {
        var value = TGS_Coronator.ofStr()
//                .anoint(val -> "ali gel")
                .anointAndCoronateIf(val -> val.length() > 5, val -> "veli gel")
//                .anointIf(val -> val.length() > 0, val -> "celi gel")
                .coronate();
        System.out.println(value);
    }
}
