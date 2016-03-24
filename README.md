#Validation library for Java/Android

```java
ValidateHelper vp = new ValidateHelper();
vp.add("a", "mmmmmm", "isFilled;isAlpha;minLength(6)");
vp.add("b", "sdfsdf@#$^&s", "isFilled;isAlpha");
vp.add("c", "", "isFilled");
vp.add("d", "", "isFilled;isEmail");
vp.add("f", "-1.123", "isDouble");
Boolean b = vp.check();
System.out.println("check:" + b);
```