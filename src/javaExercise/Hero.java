package javaExercise;
//java�Ĳ�����������

public class Hero {
    
    String name; //����
        
    float hp; //Ѫ��
        
    float armor; //����
        
    int moveSpeed; //�ƶ��ٶ�
     
    public Hero(){
         
    }
     
    public Hero(String name,float hp){
        this.name = name;
        this.hp = hp;
    }
 
    //����
    public void revive(Hero h){
        h = new Hero("��Ī",383); //�β�ָ�����µĵ�ַ���Դ����ʵ�β�����Ӱ��
    }
 
    public static void main(String[] args) {
        Hero teemo =  new Hero("��Ī",383);
         
        //�ܵ�400�˺�������
        teemo.hp = teemo.hp - 400;
         
        teemo.revive(teemo);
         
        //���⣺ System.out.println(teemo.hp); ������٣� ��ô��⣿
        System.out.println(teemo.hp); //���-17
         
    }
      
}