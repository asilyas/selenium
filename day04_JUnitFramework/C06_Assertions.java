package day04_JUnitFramework;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertions{
    String str1="Ali";
    String str2="ali";

    @Test
    public void test01(){
        Assert.assertEquals(str1,str2);


       /* if (str1.equals(str2)){
            System.out.println("esitlik testi passed");
        }else {
            System.out.println("eşitlik testi failed");
        } */
    }
  @Test
    public void test02(){
        Assert.assertTrue(str1.contains("A"));

      /*if (str1.contains("A")){
          System.out.println("olumlu testi passed");
      }else {
          System.out.println("olumlu testi failed");
      }*/
  }

    @Test
    public void test03() {
        Assert.assertFalse(str2.contains("c"));
      /*  if (!str2.contains("c")){
            System.out.println("negatif testi passed");
        }else {
            System.out.println("negatif testi failed");
        }
    */
    }
}
