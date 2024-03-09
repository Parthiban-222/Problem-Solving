import java.util.*;
class Main{
public static int isNumhappy(int num){
int rem=0,sum=0;
while(num>0){
    rem=num%10;
    sum=sum+(rem*rem);
    num=num/10;
}
return sum;
}
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int num=sc.nextInt();
		int finalval=num;
		while(finalval!=1&&finalval!=4){
		    finalval=isNumhappy(finalval);
		}
		if(finalval==1){
		    System.out.println("happy num");
		}
		else{
		    System.out.println("not happy num");
		}
	}
}
