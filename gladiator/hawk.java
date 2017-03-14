import java.util.*;
public class hawk{
	private Random random;
	private int x,y;
	private int life;
	private boolean flag=true;
	
	public int attack(int hX,int hY){
		int dis = distance(x,y,hX,hY);
		if(dis<=2){
			return 1;
		}else{
			return 0;
		}
	}
	
	public int getLife(){
		return life;	
	}
	
	public void lostLife(int lost){
		life-=lost;
		System.out.println("lost life: "+lost);
		System.out.println("current life: "+life);
	}
	
	public void die(int[][] map){
		if(flag){
			map[y][x]=0;
			flag=false;
			x=0;
			y=0;
		}
	}
	
	public hawk(int [][] map){
		life=10;
		random = new Random();
		x = random.nextInt(3)+1;
		y = random.nextInt(9)+1;
		while(map[y][x]!=0){
			x = random.nextInt(3)+1;
			y = random.nextInt(9)+1;
		}
		map[y][x]=3;
	}
	public int distance(int x,int y,int curX,int curY){
		return Math.abs((x-curX)*(x-curX))+Math.abs((y-curY)*(y-curY));
	}
	
	public void calMove(int hX,int hY,int [][]map){
		int tArray[][]=new int[25][2];
		map[y][x]=0;
		int tempX=x-2;
		int tempY=y-2;
		for(int i=0;i<25;i++){
			tArray[i][0]=tempX+i%5;
			tArray[i][1]=tempY+i/5;
		}
		int dis=1000;
		for(int i=0;i<25;i++){
			if(tArray[i][0]>=0&&tArray[i][0]<5&&tArray[i][1]>=0&&tArray[i][1]<10){
				if(map[tArray[i][1]][tArray[i][0]]==0){
					int temp=distance(tArray[i][0],tArray[i][1],hX,hY);
					if(temp<dis){
						dis=temp;
						x=tArray[i][0];					
						y=tArray[i][1];
						
					}
				}
			}
		}
		map[y][x]=3;
	}
	public int getXY(char mode){
		if(mode=='x'){
			return x;
		}else if(mode=='y'){
			return y;
		}else{
			System.out.println("Error use");
			return -1;
		}
	}

}