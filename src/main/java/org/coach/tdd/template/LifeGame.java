package org.coach.tdd.template;

/**
 * Created by lzy on 17-6-3.
 */
public class LifeGame {
	private int framesize = 20; //框架大小，表示为正方体框架的边长
	private int[][] frame = new int[framesize][framesize];

	public int getFramesize() {
		return framesize;
	}

	public void setFramesize(int framesize) {
		this.framesize = framesize;
	}

	public int[][] getFrame() {
		return frame;
	}

	public void setFrame(int[][] frame) {
		this.frame = frame;
	}
}
