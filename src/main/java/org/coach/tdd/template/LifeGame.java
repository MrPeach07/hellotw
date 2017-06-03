package org.coach.tdd.template;

/**
 * Created by lzy on 17-6-3.
 */

/**
 * LifeGame类生命游戏具体操作类
 */
public class LifeGame {
	private int framesize=0; //框架大小，表示为正方体框架的边长
	private int[][] frame ;
	private int[][] nextframe;

	public LifeGame(int framesize) {
		this.framesize = framesize;
	}

	public int[][] getNextframe() {
		return nextframe;
	}

	public void setFrame(int[][] frame) {
		this.frame = frame;
	}
	public void init(){
		frame=new int[framesize][framesize];
		nextframe=new int[framesize][framesize];
	}
	public void putCell(Cell cell){
		frame[cell.getLocation_x()][cell.getLocation_y()]=cell.getCellStatus();

	}
	/**
	 *
	 */
public int locationIsCorner(int x,int y){
	if(0==x&&0==y){
		return 1;
	}else if (0==x&&framesize-1==y){
		return 2;
	}else if (framesize-1==x&&0==y){
		return 3;
	}else if (framesize-1==x&&framesize-1==y){
		return 4;
	}
	return 0;
}
public int locationIsLine(int x,int y){
	if(0==x&&0!=y&&framesize-1!=y){
		return 11;
	}else if (framesize-1==x&&0!=y&&framesize-1!=y){
		return 12;
	}else if (0==y&&0!=x&&framesize-1!=x){
		return 13;
	}else if (framesize-1==y&&0!=x&&framesize-1!=x){
		return 14;
	}
	return 0;
}
	/**
	 * 获取指定坐标细胞周围细胞状态
	 * @param x	cell_x坐标
	 * @param y	cell_y坐标
	 * @return	指定坐标细胞周围细胞状态
	 */
	public int[][] getAroundStatus(int x,int y){
		//corner
		int[][] aroundUnit=new int[3][3];
		int isCorner = locationIsCorner(x, y);
		int isLine = locationIsLine(x, y);
		if(isCorner!=0) {
			switch (isCorner) {
				case 1: {
					aroundUnit = new int[][]{{frame[x][y + 1], frame[x + 1][y], frame[x + 1][y + 1]}, {0, frame[x][y], 0}, {0, 0, 0}};
					break;
				}
				case 2: {
					aroundUnit = new int[][]{{frame[x][y - 1], frame[x + 1][y - 1], frame[x + 1][y]}, {0, frame[x][y], 0}, {0, 0, 0}};
					break;
				}
				case 3: {
					aroundUnit = new int[][]{{frame[x - 1][y], frame[x - 1][y + 1], frame[x][y + 1]}, {0, frame[x][y], 0}, {0, 0, 0}};
					break;
				}
				case 4: {
					aroundUnit = new int[][]{{frame[x - 1][y], frame[x - 1][y - 1], frame[x][y - 1]}, {0, frame[x][y], 0}, {0, 0, 0}};
					break;
				}
				default:
					break;
			}
		}
		//line
		else if(isLine!=0){
				switch (isCorner){
					case 11:{
						aroundUnit= new int[][]{{frame[x][y - 1], frame[x][y + 1], frame[x + 1][y - 1]}, {frame[x + 1][y], frame[x][y], frame[x + 1][y + 1]}, {0, 0, 0}};
						break;
					}
					case 12:{
						aroundUnit= new int[][]{{frame[x - 1][y - 1], frame[x - 1][y], frame[x - 1][y + 1]}, {frame[x][y - 1], frame[x][y], frame[x][y + 1]}, {0, 0, 0}};
						break;
					}
					case 13:{
						aroundUnit= new int[][]{{frame[x - 1][y], frame[x - 1][y + 1], frame[x][y + 1]}, {frame[x + 1][y], frame[x][y], frame[x + 1][y + 1]}, {0, 0, 0}};
						break;
					}
					case 14:{
						aroundUnit= new int[][]{{frame[x - 1][y - 1], frame[x - 1][y], frame[x][y - 1]}, {frame[x + 1][y - 1], frame[x][y], frame[x + 1][y]}, {0, 0, 0}};
						break;
					}default:break;
			}
		}
		else {
			aroundUnit= new int[][]{{frame[x - 1][y - 1], frame[x - 1][y], frame[x - 1][y + 1]}, {frame[x][y - 1], frame[x][y], frame[x][y + 1]}, {frame[x + 1][y - 1], frame[x + 1][y], frame[x + 1][y + 1]}};

		}
		return  aroundUnit;
	}

	/**
	 * 更新环境中所有细胞生命状态
	 * @return	环境中是否还在活着的细胞
	 */
	public boolean isfreshFrame(){
//		boolean flag =false;
		boolean hasLife=false;
		BasicUnit basicUnit=new BasicUnit();
		for(int i=0;i<framesize;i++){
			for (int j =0;j<framesize;j++){
				int[][] aroundUnit = getAroundStatus(i,j);
				int status=basicUnit.getUnitCelltatus(aroundUnit);
				nextframe[i][j]=status;
			}
		}
		for(int i=0;i<framesize;i++) {
			for (int j = 0; j < framesize; j++) {
				System.out.print(frame[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
		for(int i=0;i<framesize;i++) {
			for (int j = 0; j < framesize; j++) {
				if(1==nextframe[i][j]){
					hasLife=true;
				}
				System.out.print(nextframe[i][j]);
			}
			System.out.println("");
		}
//		flag=true;
		return hasLife;
	}

	/**
	 * 运行整个生命游戏
	 * @param lifeGame	生命游戏的初始对象
	 * @return	运行成功
	 */
	public boolean run(LifeGame lifeGame){
		while(lifeGame.isfreshFrame()){
			lifeGame.setFrame(lifeGame.getNextframe());
			System.out.println("");
		}
		return true;
	}
}
