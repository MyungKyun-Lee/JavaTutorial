package _04_2For;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class _02_test2 {

	public static void main(String[] args) {
		Timer timer = new Timer(); // Creating a Timer object from the timer class
		
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		formatter.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

		
        TimerTask task2 = new TimerTask() {
			public void run() {
				Date date = new Date();
				String result = formatter.format(date);
				
				System.out.println(result);
			}
		};
		
		TimerTask task1 = new TimerTask() { 	// 타이머 생성
			public void run() {
				System.out.println("Timeover"); 	// 타이머 종료 시 메시지
				task2.cancel();
				timer.cancel();
				//				clearTimeout(task2);
			}
		};

        // Scheduling tasks to run after specified delays
        timer.schedule(task2, 0, 1000); // 1000=1초후 호출, 5000=5초마다 반복
        timer.schedule(task1, 20000); // Using the schedule method of the timer class	// 타이머 시간
	}

}
