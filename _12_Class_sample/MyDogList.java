package _12_Class_sample;

public class MyDogList {

	Dog[] d = new Dog[5];

	MyDogList() {
		System.out.println("-- 도그 관리 --");
		System.out.println(d[0]);
		if (d[0] != null) {
			System.out.println(d[0].name);
		}
		d[1] = new Dog();
		System.out.println(d[1]);
		d[2] = d[1];
		System.out.println(d[2]);
		d[3] = new Dog();
		System.out.println(d[3]);
		Dog dd = new Dog();
		d[4] = dd;
		System.out.println(dd);
		System.out.printf("%h\n",d[4]);
		System.out.printf("%s",d[4]);
		System.out.println();
		d[1].name="abc";
		System.out.println(d[1].name);
		System.out.println(d[2].name);
		System.out.println(d[3].name);
		
		// 강아지 검색
		String s = "땡칠이";
		d[3].name = s;
		for (int i=0; i<5; i++) {
			if (d[i] != null) {
				System.out.println("d["+i+"].name "+ d[i].name);
				if (d[i].name != null && d[i].name.equals(s)) {
					System.out.println("찾음");
					break;
				}
			}
		}
	}

}
