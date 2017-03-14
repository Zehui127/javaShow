import java.util.*;
public class Human{
	private Random random;
	public int x,y;
	private int life;
	
	public void die(int[][] map){
		map[y][x]=0;
	}
	
	public int attack(){
		return random.nextInt(10)+1;
	}
	
	public int getLife(){
		return life;	
	}
	
	public void lostLife(int lost){
		life-=lost;
	}
	
	
	public Human(int [][]map){
		life=100;
		random = new Random();
		x = random.nextInt(3)+1;
		y = random.nextInt(9)+1;
		while(map[y][x]!=0){
			x = random.nextInt(3)+1;
			y = random.nextInt(9)+1;
		}
		map[y][x]=1;
	}
	
	public int distance(int x,int y,int curX,int curY){
		return Math.abs((x-curX)*(x-curX))+Math.abs((y-curY)*(y-curY));
	}
	
	public int[] calMove(int control,int [][]map){
		int pX=x,pY=y;
		map[y][x]=0;
		int[] temp = new int[3];
		int[] pos = new int[2];
		switch(control){
			case 1:
				pos[0] = x -1;
				pos[1] = y +1;
				break;
			case 2:
				pos[0] = x;
				pos[1] = y +1;
				break;
			case 3:
				pos[0] = x +1;
				pos[1] = y +1;
				break;
			case 4:
				pos[0] = x -1;
				pos[1] = y;
				break;
			case 5:
				pos[0] = x;
				pos[1] = y;
				break;
			case 6:
				pos[0] = x+1;
				pos[1] = y;
				break;
			case 7:
				pos[0] = x-1;
				pos[1] = y-1;
				break;
			case 8:
				pos[0] = x;
				pos[1] = y-1;
				break;
			case 9:
				pos[0] = x+1;
				pos[1] = y-1;
				break;
		}
		if(map[pos[1]][pos[0]]==0||map[pos[1]][pos[0]]==0){
			x=pos[0];
			y=pos[1];
			map[pos[1]][pos[0]]=1;
			return temp;
		}else{
			map[pY][pX]=1;
			temp[2]=map[pos[1]][pos[0]];
			temp[0]=pos[0];
			temp[1]=pos[1];
			return temp;
		}
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