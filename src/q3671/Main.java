package q3671;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int r, c, cur_cheese, prev_cheese, cnt;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;

	public static void DFS(int x, int y) {
		int i, j;
		int ax, ay;

		for (i = 0; i < 4; i++) {
			ax = x + dx[i];
			ay = y + dy[i];

			if (ax < 0 || ax >= r + 2 || ay < 0 || ay >= c + 2)
				continue;
			if (visited[ax][ay])
				continue;
			if (map[ax][ay] == 1) {
				map[ax][ay] = 0;
				visited[ax][ay] = true;
				cur_cheese++;
				continue;
			}

			visited[ax][ay] = true;
			DFS(ax, ay);
		}

	}

	public static void main(String[] args) throws IOException {
		int i, j;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r + 2][c + 2];

		for (i = 1; i <= r; i++) {
			st = new StringTokenizer(in.readLine());
			for (j = 1; j <= c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new boolean[r + 2][c + 2];
			visited[0][0] = true;
			cur_cheese = 0;
			DFS(0, 0);
			
			if(cur_cheese == 0) break;
			prev_cheese = cur_cheese;
			cnt++;
		}
		
		out.write(cnt + "\n" + prev_cheese);

		out.flush();

		in.close();
		out.close();
	}
}
