package org.coach.tdd.template;

/**
 * Created by lzy on 17-6-3.
 */
public class LifeGame {
	private int framesize=0; //框架大小，表示为正方体框架的边长
	private int[][] frame ;
	private int[][] nextframe;
//    private List<Cell> lifeCells;

	public LifeGame(int framesize) {
		this.framesize = framesize;
	}

	public int getFramesize() {
		return framesize;
	}

	public void setFramesize(int framesize) {
		this.framesize = framesize;
	}

	public int[][] getFrame() {
		return frame;
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
	public int[][] getAroundStatus(int x,int y){
		BasicUnit basicUnit = new BasicUnit();
		if(0==x&&0==y){
			int [][] aroundUnit={{frame[x][y+1],frame[x+1][y],frame[x+1][y+1]},{0,frame[x][y],0},{0,0,0}};
			return aroundUnit;

		}
		else if(0==x&&framesize-1==y){
			int [][] aroundUnit={{frame[x][y-1],frame[x+1][y-1],frame[x+1][y]},{0,frame[x][y],0},{0,0,0}};
			return aroundUnit;
		}
		else if(framesize-1==x&&0==y){
			int [][] aroundUnit={{frame[x-1][y],frame[x-1][y+1],frame[x][y+1]},{0,frame[x][y],0},{0,0,0}};
			return aroundUnit;
			//			return {{frame[x][y+1],frame[x+1][y],frame[x+1][y+1]},{0,0,0}{0,0,0}};
		}
		else if(framesize-1==x&&framesize-1==y){
			int [][] aroundUnit={{frame[x-1][y],frame[x-1][y-1],frame[x][y-1]},{0,frame[x][y],0},{0,0,0}};
			return aroundUnit;
		}
		else if(0==x&&0!=y&&framesize-1!=y){
			int [][] aroundUnit={{frame[x][y-1],frame[x][y+1],frame[x+1][y-1]},{frame[x+1][y],frame[x][y],frame[x+1][y+1]},{0,0,0}};
			return aroundUnit;
		}

		else if (framesize-1==x&&0!=y&&framesize-1!=y){
			int [][] aroundUnit= {{frame[x-1][y-1],frame[x-1][y],frame[x-1][y+1]},{frame[x][y-1],frame[x][y],frame[x][y+1]},{0,0,0}};
			return  aroundUnit;
		}
		else if (0==y&&0!=x&&framesize-1!=x){
			int [][] aroundUnit= {{frame[x-1][y],frame[x-1][y+1],frame[x][y+1]},{frame[x+1][y],frame[x][y],frame[x+1][y+1]},{0,0,0}};
			return  aroundUnit;
		}
		else if (framesize-1==y&&0!=x&&framesize-1!=x){
			int [][] aroundUnit= {{frame[x-1][y-1],frame[x-1][y],frame[x][y-1]},{frame[x+1][y-1],frame[x][y],frame[x+1][y]},{0,0,0}};
            return aroundUnit;
		}
		else {
			int [][] aroundUnit= {{frame[x-1][y-1],frame[x-1][y],frame[x-1][y+1]},{frame[x][y-1],frame[x][y],frame[x][y+1]},{frame[x+1][y-1],frame[x+1][y],frame[x+1][y+1]}};
			return  aroundUnit;

		}
	}
	/*

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
	public boolean run(LifeGame lifeGame){
		while(lifeGame.isfreshFrame()){
			lifeGame.setFrame(lifeGame.getNextframe());
			System.out.println("");
		}
		return true;
	}
}
