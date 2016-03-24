package com.catcto.util;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ValidateHelper {
    private Class ownerClass = null;

    public ValidateHelper() {
        try {
            String className = ValidateRule.class.getName();
            ownerClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<ValidatePar> pars = new ArrayList<ValidatePar>();

    public void add(String pname, String pvalue, String validate) {
        pars.add(new ValidatePar(pname, pvalue, validate));
    }

    public Boolean check() {
        int checkCount = 0;
        int okCount = 0;
        int errorCount = 0;
        try {
            for (ValidatePar par : pars) {
                for (int i = 0; i < par.validate.length; i++) {
                    String vv = par.validate[i];
                    String vm = "";
                    ArrayList<String> args = new ArrayList<String>();
                    args.add(par.value);
                    if (vv.lastIndexOf(")") == vv.length() - 1) {
                        vm = vv.substring(0, vv.lastIndexOf("("));
                        String t = vv.substring(vv.indexOf("(") + 1, vv.lastIndexOf(")"));
                        String[] arrT = t.split(",");
                        for (int j = 0; j < arrT.length; j++) {
                            args.add(arrT[j]);
                        }
                    } else {
                        vm = vv;
                    }
                    checkCount++;
                    Boolean b = invokeStaticMethod(ownerClass, vm, args.toArray());
                    //log.info("validate " + vv + " " + par.name + ":'" + par.value + "' " + (b ? "ok" : "error"));
                    if (b) {
                        okCount++;
                    } else {
                        errorCount++;
                    }
                }
            }
        } catch (Exception e) {
            errorCount++;
        }
        //log.info("validateCount:" + checkCount + ",okCount:" + okCount + ",errorCount:" + errorCount);
        return (errorCount == 0 && checkCount == okCount);
    }

    public Boolean check(ValidatePar par) {
        for (int i = 0; i < par.validate.length; i++) {
            String vv = par.validate[i];
            String vm = "";
            ArrayList<String> args = new ArrayList<String>();
            args.add(par.value);
            if (vv.lastIndexOf(")") == vv.length() - 1) {
                vm = vv.substring(0, vv.lastIndexOf("("));
                String t = vv.substring(vv.indexOf("(") + 1, vv.lastIndexOf(")"));
                String[] arrT = t.split(",");
                for (int j = 0; j < arrT.length; j++) {
                    args.add(arrT[j]);
                }
            } else {
                vm = vv;
            }
            Boolean b = invokeStaticMethod(ownerClass, vm, args.toArray());
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private Boolean invokeStaticMethod(Class ownerClass, String methodName, Object[] args) {
        try {
            Class[] argsClass = new Class[args.length];
            for (int i = 0, j = args.length; i < j; i++) {
                argsClass[i] = args[i].getClass();
            }
            Method method = ownerClass.getMethod(methodName, argsClass);
            return (Boolean) method.invoke(null, args);
        } catch (Exception e) {
            //AppCommon.log(e.getMessage());
            return false;
        }
    }
}