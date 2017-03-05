public class chessBoard{
	private int[] array;
	public chessBoard(int x,int player){
		array = new int[9];
		array[x-1] = player; 
	}
	public void play(int x,int player){
		array[x-1] = player;
	}
	public void play(int x,int y,int player){
		array[x-1] = 0;
		array[y-1] = player;
	}
	public boolean check(int player){
		int flag=0;
		int[][] x = new int[3][2];
		for(int i = 0;i<3;i++){
			for(int j = 0;j<2;j++){
				x[i][j]=-1;
			}
		}
		for(int i=0;i<9;i++){
			if(array[i]==player){
				if((i+1)%3==0){
					x[flag][0] = (i+1)/3-1;
					x[flag][1] = 2;
				}else{
					x[flag][0] = (i+1)/3;
					x[flag][1] = (i+1)%3-1;
				}
				flag++;
			}
		}		
		if((x[0][0]==x[1][0]&&x[1][0]==x[2][0])||(x[0][1]==x[1][1]&&x[1][1]==x[2][1])||(x[0][0]==x[0][1]&&x[1][0]==x[1][1]&&x[2][0]==x[2][1]&&x[0][0]!=-1&&x[1][0]!=-1&&x[2][0]!=-1)||(x[0][0]+x[0][1]==x[1][0]+x[1][1]&&x[1][0]+x[1][1]==x[2][0]+x[2][1])){
			return true;
		}else{
			return false;
		}
	}
	public void print(){
		String[] result = new String[9];		
		for(int i=0;i<9;i++){
			if(array[i]==1){
				result[i]="X";
			}else if(array[i]==2){
				result[i]="O";
			}else{
				result[i]=" ";
			}
		}
		System.out.println("---+---+---");
		System.out.println(" " + result[0] + " | "+result[1]+" | "+result[2]+" ");
		System.out.println("-1-+-2-+-3-");
		System.out.println(" " + result[3] + " | "+result[4]+" | "+result[5]+" ");
		System.out.println("-4-+-5-+-6-");
		System.out.println(" " + result[6] + " | "+result[7]+" | "+result[8]+" ");
		System.out.println("-7-+-8-+-9-");
	}
}