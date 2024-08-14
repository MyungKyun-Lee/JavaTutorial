package _03For;

public class _07_0814_q7 {

	public static void main(String[] args) {
		// 문제7) 인덱스를 사람의 번호, 시간은 최대  4시간,
		int[] jobTime = {40,32,4,16,5,8};
		boolean persol[] = {true,true,true,true,true,true};
		
		for (int i=0;  ;i++) {
			i = i%6;
			if (jobTime[i] > 0) {
				jobTime[i]-=4;
				System.out.print(i);
			} else {
				persol[i] = false;
			}
			if (persol[0]==false && persol[1]==false && persol[2]==false && persol[3]==false && persol[4]==false && persol[5]==false) break;

		}
		System.out.println("");
		System.out.println(jobTime[0]+"/"+jobTime[1]+"/"+jobTime[2]+"/"+jobTime[3]+"/"+jobTime[4]+"/"+jobTime[5]);
	}

}
