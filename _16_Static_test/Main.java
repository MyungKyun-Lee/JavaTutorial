package _16_Static_test;

class Ex{
    static int month; // static 붙은 변수 (클래스 변수)
    static int count; // static 붙은 변수 (클래스 변수)
    
    static void name(){  // static 붙은 변수 (클래스 메소드)
        System.out.println(month + "월의 망댕이");
    }
    
    int price; // static 붙지 않은 변수 (인스턴스 변수)
    int price2; // static 붙지 않은 변수 (인스턴스 변수)
    
    void money(){  // static 붙지 않은 메소드 (인스턴스 메소드)
        price2 = (int) (price*0.9);
        System.out.println("이번달의 수익 : " + price2);
        count++; // 클래스 변수는 인스턴스 변수들과 다르게 초기화되지 않고 그 값을 계속 유지
                 // 예를 들어 Ex.count를 3번 호출하면 count는 3값을 갖는다.
    }
}

class Main {
    public static void main(String[] args){
        Ex.month = 10;
        Ex.name();
        System.out.println(Ex.count);
        Ex.count = 1;
        System.out.println(Ex.count);
        // Ex클래스의 인스턴스 없이 변수와 메소드를 사용한다.
        
        Ex ex = new Ex();
        ex.price = 300000;
        ex.money();
        // 인스턴스를 이용하여 Ex에 있는 변수와 메소드를 사용한다.
        System.out.println(ex.count+"번째 수익");
        ex.money();
        // 인스턴스를 이용하여 Ex에 있는 변수와 메소드를 사용한다.
        System.out.println(ex.count+"번째 수익");
    }
}
