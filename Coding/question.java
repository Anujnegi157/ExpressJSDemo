import java.util.*;
public class question{
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
     System.out.println("Welcome to Coffee Store");
     System.out.println("please give the number of cups do you want");
     int noofCups = scn.nextInt();
     Coffee user = new Coffee(noofCups);
     while(noofCups>0){
      
      System.out.println("Available coffee");
      System.out.println("Cappuccino");
      System.out.println("Espresso");
      System.out.println("Latte");
      System.out.println("please tell which one u want");
      String coffeeType = scn.next();
      user.typeCoffee(coffeeType);
      System.out.println("want add ons");
      System.out.println("milk");
      System.out.println("Cream");
      System.out.println("latte");
      System.out.println("please tell which one u want");
      String addonscoffeeType = scn.next();
      if(coffeeType.equals("Cappuccino")){
        user.CapaddOns(addonscoffeeType);
      }else if(coffeeType.equals("Espresso")){
        user.EscaddOns(addonscoffeeType);
      }else if(coffeeType.equals("Latte")){
        user.LataddOns(addonscoffeeType);
      }
      noofCups--;








     }
     user.DetailsBill();
  }
}
class Coffee implements CappuccinoCoffee,EspressoCoffee,LatteCoffee{
    int price = 0;
    int cups  = 0;
    int ccups = 0;
    int ecups = 0;
    int lcups = 0;
    public Coffee(int cups){
      this.cups=cups;
    }
    
    public void typeCoffee(String coffeeType){
     if(coffeeType.equals("Cappuccino")){
        this.price+= CappuccinoCoffee.Cappuccinoprice;
        System.out.println("you have order cappuccino");
        ccups++;
     }else if(coffeeType.equals("Espresso")){
      this.price+= EspressoCoffee.Espressoprice;
      System.out.println("you have order Espresso");
      ecups++;
     }else if(coffeeType.equals("Latte")){

      this.price+=LatteCoffee.Latteprice;
      System.out.println("you have order Latte");
      lcups++;
     }
    }

    @Override
    public void CapaddOns(String adds) {
      if(adds.equals("milk")){
        this.price+=CappuccinoCoffee.milk;
      }else if(adds.equals("Cream")){
        this.price+=CappuccinoCoffee.Cream;
      }else if(adds.equals("latte")){
        this.price+=CappuccinoCoffee.latte;
      }
      
    }
    @Override
    public void EscaddOns(String adds) {
      if(adds.equals("milk")){
        this.price+=EspressoCoffee.milk;
      }else if(adds.equals("Cream")){
        this.price+=EspressoCoffee.Cream;
      }else if(adds.equals("latte")){
        this.price+=EspressoCoffee.latte;
      }
      
    }
    @Override
    public void LataddOns(String adds) {
      if(adds.equals("milk")){
        this.price+=LatteCoffee.milk;
      }else if(adds.equals("Cream")){
        this.price+=LatteCoffee.Cream;
      }else if(adds.equals("latte")){
        this.price+=LatteCoffee.latte;
      }
      
    }
    public void DetailsBill(){
      System.out.println("your bills is"+ price);
      System.out.println("you have ordered CappuccinoCoffee cups"+ccups);
      System.out.println("you have ordered EspressoCoffee cups"+ecups);
      System.out.println("you have ordered LatteCoffee cups"+lcups); 
    }
    
}



interface CappuccinoCoffee {
  final int Cappuccinoprice=200;
  final int milk = 80;
  final int Cream = 90;
  final int latte = 125;

  
  void CapaddOns(String adds);
  

}


interface EspressoCoffee{
  final int Espressoprice=200;
  final int milk = 60;
  final int Cream = 75;
  final int latte = 100;

  void EscaddOns(String adds);
   
}

interface LatteCoffee {
  final int Latteprice=200;
  final int milk = 60;
  final int Cream = 75;
  final int latte = 100;

  void LataddOns(String adds);
   
}


