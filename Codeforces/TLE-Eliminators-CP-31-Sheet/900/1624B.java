import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			solve(br, pw);
		}

		pw.flush();
		pw.close();
		br.close();
	}

	public static void solve(BufferedReader br, PrintWriter pw) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int diffac = Math.abs(a-c);
		boolean possible = false;

		if ((a + c) % 2 == 0) {
			long targetB = (a + c) / 2;
			if (targetB > 0 && targetB % b == 0) {
				possible = true;
			}
		}
		long targetA = 2 * b - c;
		if (targetA > 0 && targetA % a == 0) {
			possible = true;
		}
		long targetC = 2 * b - a;
		if (targetC > 0 && targetC % c == 0) {
			possible = true;
		}

		if (possible) {
			pw.println("YES");
		} else {
			pw.println("NO");
		}
	}
}

// my logic is simple

// lets consider the sequence as AP only
// Hence the difference between a and b is d and b and c is d and a and c is 2d
// now suppose we need to multiple b by m to make it AP
// Then find 2d (a-c) and check if d is multiple of b --> if yes then yes we can convert to AP
// suppose we need to mulitply a by m to make it AP
// then find d = b-c and check whether b-d or b+d is multiple of a
// suppse we need to multiply c by m to make it ap
// then find d = a-b and check whether c b-d or b+d multiple of c