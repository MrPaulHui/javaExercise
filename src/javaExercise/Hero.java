package javaExercise;
//java的参数传递问题

public class Hero {
    
    String name; //姓名
        
    float hp; //血量
        
    float armor; //护甲
        
    int moveSpeed; //移动速度
     
    public Hero(){
         
    }
     
    public Hero(String name,float hp){
        this.name = name;
        this.hp = hp;
    }
 
    //复活
    public void revive(Hero h){
        h = new Hero("提莫",383); //形参指向了新的地址，对传入的实参不产生影响
    }
 
    public static void main(String[] args) {
        Hero teemo =  new Hero("提莫",383);
         
        //受到400伤害，挂了
        teemo.hp = teemo.hp - 400;
         
        teemo.revive(teemo);
         
        //问题： System.out.println(teemo.hp); 输出多少？ 怎么理解？
        System.out.println(teemo.hp); //输出-17
         
    }
      
}