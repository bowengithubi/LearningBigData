package cn.xiaodong.scala.demo.po;

import java.io.Serializable;

public class User implements Serializable {
  public static int age;
  static {
  age = 30;
  System.out.println("user static init...");
}

  @Override
  public String toString() {
  return "User["+age+"]";
}
  public static String test() {
  int i = 10 / 0;
  return "abc";
}
}
