package day04_JUnitFramework;

import org.junit.*;

public class C05_BirlikteKullanım {
    @BeforeClass
    public static void beforeClass(){

        System.out.println("Before class çalıştı \n =============");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("============ \n After class çalıştı");
    }
  @Before
   public  void before(){
      System.out.println("\nBEfore method çalıştı");
  }

  @After
    public  void after(){
      System.out.println("After methodu çalıştı");
    }

   @Test
    public  void test01(){
       System.out.println("test01 çalıştı");
   }
    @Test
    public  void test02(){
        System.out.println("test02 çalıştı");
    }
    @Test
    public  void test03(){
        System.out.println("test03 çalıştı");
    }

}
