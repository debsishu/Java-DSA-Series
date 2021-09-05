package graph;

public class FloodFill {

	static int[][] floodFill(int image[][], int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor) {
			return image;
		}
		int cur = image[sc][sr];
		DFSUtil(image, sc, sr, newColor, cur);
		return image;
	}

	static void DFSUtil(int image[][], int sr, int sc, int newColor, int cur) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != cur) {
			return;
		}
		image[sr][sc] = newColor;

		DFSUtil(image, sr + 1, sc, newColor, cur);
		DFSUtil(image, sr - 1, sc, newColor, cur);
		DFSUtil(image, sr, sc + 1, newColor, cur);
		DFSUtil(image, sr, sc - 1, newColor, cur);
	}

	public static void main(String[] args) {
		int image[][] = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 2, 2, 0 }, { 1, 1, 1, 1, 1, 2, 1, 1 },
				{ 1, 1, 1, 1, 1, 2, 2, 1 }, };

		floodFill(image, 4, 4, 3);
		for (int i = 0; i < image.length; i++) {
			for (int e : image[i]) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}

}
