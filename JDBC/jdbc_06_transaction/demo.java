package jdbc_06_transaction;

public class demo {
   public static void main(String[] args) {
	   first();
	   fifth();
	   second();
	   fourth();
	   third();
	   
   }
   static void first() {
	   System.out.println("First");
   }
   static void second() {
	   System.out.println("Second");
   }
   static void third() {
	   System.out.println("Third");
	  
   }
   static void fourth() {
	   System.out.println("Fourth");
   }
   static void fifth() {
	   System.out.println("Fifth");
   }
}