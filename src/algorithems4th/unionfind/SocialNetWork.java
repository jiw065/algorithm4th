package algorithems4th.unionfind;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class SocialNetWork {
	private WeightedQuickUnionUF uf;

	public SocialNetWork(int n) {
		uf = new WeightedQuickUnionUF(n);
	}

	public long connectMember() {
		ArrayList<String> log = readLogFile();
		long timeStamp = 0;
		int p;
		int q;
		int i = 0;
		while (uf.count() != 1 && i < log.size()) {
			String[] sl = log.get(i).split(" ");
			timeStamp = Long.parseLong(sl[0]);
			p = Integer.parseInt(sl[1]);
			q = Integer.parseInt(sl[2]);
			uf.union(p, q);
			i++;
		}
		if (uf.count() != 1) {
			return -1;
		}
		return timeStamp;
	}

	private ArrayList<String> readLogFile() {

		ArrayList<String> sList = new ArrayList<String>();

		try {

			InputStreamReader fs = new InputStreamReader(new FileInputStream("J:\\programs\\cs\\al4th\\timeLog.txt"));
			BufferedReader br = new BufferedReader(fs);
			String readS = br.readLine();
			while (readS != null) {
				sList.add(readS);
				readS = br.readLine();
			}
			
			br.close();
			fs.close();

		} catch (FileNotFoundException e) {
			System.out.println("file not existing");
			System.exit(-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sList.remove(1); // no idea why the null string get read
		return sList;

	}

	public static void main(String[] args) {
		SocialNetWork sn = new SocialNetWork(10);
		long time = sn.connectMember();
		if (time == -1) {
			System.out.println("the memebers have not been all connected yet!");
		} else {
			System.out.println(time);
		}

	}

}
