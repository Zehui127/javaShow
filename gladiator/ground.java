import java.util.*;
public class ground{
	public static void print(int array[][]){
		for(int i=0;i<10;i++){
			for(int j=0;j<5;j++){
				switch(array[i][j]){
					case 4:
						System.out.print("#");
						break;
					case 1:
						System.out.print("@");
						break;
					case 2:
						System.out.print("t");
						break;
					case 3:
						System.out.print("h");
						break;
					case 0:
						System.out.print(".");
						break;
				}
			}
			System.out.println();
		}
	}
	
	public static boolean checkWin(int [][] map,int count){
		int flag=0;
		for(int i=0;i<10;i++){
			for(int j=0;j<5;j++){
				if(map[i][j]==2||map[i][j]==3){
					flag=1;
				}
			}
		}
		if(flag==0||count>=50){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args){
		Runtime r = Runtime.getRuntime();
		int [][] map = new int [10][5];
		Scanner input = new Scanner(System.in);
		obst ob = new obst(map);
		Human h = new Human(map);
		Tiger t = new Tiger(map);
		Tiger t2 = new Tiger(map);
		hawk ha = new hawk(map);
		hawk ha2 = new hawk(map);
		hawk ha3 = new hawk(map);
		int count=0;
		print(map);
		System.out.println("------init state-------");
		while(true){
			if(count%2==0){
				int control=input.nextInt();
				int[] temp=h.calMove(control,map);
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				
				switch(temp[2]){
					case 0:
						break;
					case 2:
						Tiger tempT;
						if(temp[0]==t.getXY('x')&&temp[1]==t.getXY('y')){
							System.out.println("Here it is t");
							tempT=t;
						}else{
							System.out.println("Here it is t2");
							tempT=t2;
						}
						tempT.lostLife(h.attack());
						if(tempT.getLife()<=0){
							tempT.die(map);
						}
						break;
					case 3:
						hawk tempH;
						if(temp[0]==ha.getXY('x')&&temp[1]==ha.getXY('y')){
							tempH=ha;
							System.out.println("Here it is ha");
						}else if(temp[0]==ha2.getXY('x')&&temp[1]==ha2.getXY('y')){
							tempH=ha2;
							System.out.println("Here it is ha2");
						}else{
							tempH=ha3;
							System.out.println("Here it is ha3");
						}
						
						tempH.lostLife(h.attack());
						if(tempH.getLife()<=0){
							tempH.die(map);
						}
						break;
				}
			}else{
				
				
				if(t.getLife()>0){
					if(t.attack(h.getXY('x'),h.getXY('y'))>0){
						h.lostLife(t.attack(h.getXY('x'),h.getXY('y')));
					}else{
						t.calMove(h.getXY('x'),h.getXY('y'),map);
					}
				}
				
				if(t2.getLife()>0){
					if(t2.attack(h.getXY('x'),h.getXY('y'))>0){
						h.lostLife(t2.attack(h.getXY('x'),h.getXY('y')));
					}else{
						t2.calMove(h.getXY('x'),h.getXY('y'),map);
					}
				}
				
				if(ha.getLife()>0){
					if(ha.attack(h.getXY('x'),h.getXY('y'))>0){
						h.lostLife(ha.attack(h.getXY('x'),h.getXY('y')));
					}else{
						ha.calMove(h.getXY('x'),h.getXY('y'),map);
					}
				}
				
				if(ha2.getLife()>0){
					if(ha2.attack(h.getXY('x'),h.getXY('y'))>0){
						h.lostLife(ha2.attack(h.getXY('x'),h.getXY('y')));
					}else{
						ha2.calMove(h.getXY('x'),h.getXY('y'),map);
					}
				}
				
				if(ha3.getLife()>0){
					if(ha3.attack(h.getXY('x'),h.getXY('y'))>0){
						h.lostLife(ha3.attack(h.getXY('x'),h.getXY('y')));
					}else{
						ha3.calMove(h.getXY('x'),h.getXY('y'),map);
					}
				}
				
			}
			if(checkWin(map,count)){
				System.out.println("Human win");
				break;
			}else if(h.getLife()<=0){
				
				System.out.println("Failed with life"+h.getLife());
				break;
			}else{
				System.out.println("The human life is: "+ h.getLife());
				print(map);
			}
			count++;
		}	
	}
}