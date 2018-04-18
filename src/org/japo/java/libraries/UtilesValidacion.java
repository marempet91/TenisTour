/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author Victor Hugo Polo Polo - victorpolodev@gmail.com ®
 */
public class UtilesValidacion {

    public static final String CREDENCIAL_USR_DIG = "^[a-zA-Z]+$";
    public static final String CREDENCIAL_USR_LONG = ".{4,8}";

    public static String validarUsuario(String msgUsr) {
        String valCredencial = "";
        if (msgUsr.matches(CREDENCIAL_USR_DIG) && msgUsr.matches(CREDENCIAL_USR_LONG)) {
            valCredencial = "" + "SI es correcto";
        } else if (!(msgUsr.matches(CREDENCIAL_USR_LONG))) {
            valCredencial = valCredencial + "Longitud NO correcta ";
        }
        if (!(msgUsr.matches(CREDENCIAL_USR_DIG))) {
            valCredencial = valCredencial + "Digitos NO correctos ";
        }
        return valCredencial;
    }

    public static String[] validarArrayUsuario(String msgUsr) {
        String[] arrayError = new String[2];

        arrayError[0] = "Longitud";
        arrayError[1] = "Digitos";
        if (msgUsr.matches(CREDENCIAL_USR_LONG)) {
            arrayError[0] += " CORRECTO";
        } else {
            arrayError[0] += " INCORRECTO";
        }

        if (msgUsr.matches(CREDENCIAL_USR_DIG)) {
            arrayError[1] += " CORRECTO";
        } else {
            arrayError[1] += " INCORRECTO";
        }

        return arrayError;
    }

    public static boolean validarDatos(String dato, String er) {
        boolean testOK = false;
        try {
            Pattern patron = Pattern.compile(er);
            Matcher detector = patron.matcher(dato);
            testOK = detector.matches();
        } catch (PatternSyntaxException e) {
            System.out.println(e);
        }
        return testOK;
    }

}
