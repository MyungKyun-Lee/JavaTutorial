package _13_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ListSample {
	ArrayList<String> a = new ArrayList<>();
	
	public ListSample() {
		System.out.println("리스트의 길이 "+a.size());
		a.add("apple");
		System.out.println("리스트의 길이 "+a.size());
		a.add("banana");
		a.add("abc초코렛");
		a.add("샌드");
		System.out.println("리스트의 길이 "+a.size());
		System.out.println("리스트의 1은 "+a.get(1));
		
		for (int i=0; i<a.size(); i++) System.out.println("a["+i+"]은 "+a.get(i));
		for (String i : a) {
			System.out.println("a["+i+"]은 "+i);
		}
		System.out.println("--------------------");
		for (int i=0; i<a.size(); i++) {
			if (a.get(i).charAt(0) != 'a') {
				System.out.println("a["+i+"]은 "+a.get(i));
			}
		}
		System.out.println("----------Sort----------");
		Collections.sort(a);  // Sort myNumbers
		for (int i=0; i<a.size(); i++) System.out.println("a["+i+"]은 "+a.get(i));
		
		System.out.println("---------NULL-----------");
//		a.add(0, null);
		a.set(0, null);
		for (int i=0; i<a.size(); i++) System.out.println("a["+i+"]은 "+a.get(i));
		
		System.out.println("------중간 삽입--------------");
		a.add(1,"쭈꾸미");
		for (int i=0; i<a.size(); i++) System.out.println("a["+i+"]은 "+a.get(i));
		
		System.out.println("-------삭제-------------");
		a.remove(0);
		for (int i=0; i<a.size(); i++) System.out.println("a["+i+"]은 "+a.get(i));

		System.out.println("-------수정-------------");
		a.set(1,"갑오징어");
		for (int i=0; i<a.size(); i++) System.out.println("a["+i+"]은 "+a.get(i));
		
		System.out.println("-------전체삭제-------------");
		a.clear();
		System.out.println("리스트의 길이 "+a.size());
	}
}
