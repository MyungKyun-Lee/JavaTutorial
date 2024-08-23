package _04_2For;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class _02_test3 {


	public static void main(String[] args) {
//		// 두 숫자를 입력받아 두 수의 합을 출력
//		Scanner scan = new Scanner(System.in);
//		System.out.println("첫번째 숫자를 입력해주세요 >> ");
//		int num1 = scan.nextInt();
//		System.out.println("두번째 숫자를 입력해주세요 >> ");
//		int num2 = scan.nextInt();
//		System.out.println("결과 : "+(num1 + num2));
		
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("환영합니다.");
		// 플레이 인원수를 입력받아 받은 값 만큼 반복
		System.out.println("게임을 플레이 할 인원수를 설정해주세요.  (숫자 입력)");
		int userCnt = in.nextInt();
		in.nextLine();
		int[] userPoint = new int[userCnt]; // 점수를 저장할 배열
		double[] userSpeed = new double[userCnt]; // 속도를 저장할 배열
		double[] userCorrect = new double[userCnt]; // 정확도를 저장할 배열
		double[] userSpeedScore = new double[userCnt]; // 속도 점수
		double[] userCorrectScore = new double[userCnt]; // 정확도 점수
		double[] userTotalScore = new double[userCnt]; // 총 점수를 저장할 배열
		String[] userId = new String[userCnt]; // 아이디를 저장할 배열
		System.out.println("난이도 선택:");
		System.out.println("1번 기본 / 2번 심화");
		int level=in.nextInt();
		in.nextLine();
		// 20240822_원진호_조건문을 사용하여 난이도 선택
		if(level ==1) {
			// 진호님 만든 파일
			for(int i = 0; i < userCnt; i++) {
				int missCnt = 0; // 오답 카운트
				int score = 0; // 기본 점수
				
				String accTxt = "";
				double questionCnt = 0;
				double accSpeed = 0;
				System.out.println((i+1) + "번째 ID를 입력해주세요");
				userId[i] = in.nextLine();
				String[] korArr = {
						"연못", "강물", "해변", "고요", "바위", "은하수", "산길", "낙엽", "그림자", "사랑",
						"파랑", "노래", "봄바람", "눈꽃", "별빛", "바람결", "햇빛", "하얀", "푸른", "가슴",
						"달빛", "비밀", "가로등", "기억", "연기", "파도", "은빛", "물결", "바다", "나뭇잎",
						"낮", "구름", "길", "여울", "초록", "흰", "노을", "나비", "산책", "아침",
						"빛", "별", "하늘", "가을", "겨울", "봄", "여름", "밤하늘", "꿈", "기다림",
						"추억", "소리", "시간", "달", "하루", "웃음", "돌", "새", "작은", "낮잠",
						"바람", "눈물", "희망", "봄꽃", "고양이", "나무", "햇살", "미소", "초원", "바다새",
						"은하", "무지개", "고요함", "동산", "별님", "달님", "바람개비", "푸르름", "햇빛", "구름사이",
						"여명", "파도소리", "바다빛", "산등성", "고갯길", "아지랑이", "낙조", "별똥별", "해돋이", "산새",
						"풀잎", "꽃향기", "숲속", "돌담", "해오라기", "비바람", "가로수", "석양", "고향", "산들바람",
						"햇살밭", "꽃길", "고드름", "이슬", "바람꽃", "산골", "은빛", "모래사장", "물방울", "새소리",
						"강가", "별무리", "구름다리", "달빛사이", "은하수길", "고요한밤", "하얀구름", "푸른하늘", "햇살길", "아침햇살",
						"이른아침", "구름산", "바람소리", "달그림자", "물안개", "숲속길", "바람결", "고요한산", "별나라", "강둑",
						"작은섬", "바람산", "고요한숲", "햇살속", "별빛길", "나무숲", "바다길", "푸른산", "파란하늘", "구름바람",
						"고요한강", "별빛바람", "산속길", "달빛산", "바다속", "은빛파도", "구름사이길", "별빛속", "바람길", "산속물결",
						"고요한바다", "햇빛숲", "푸른초원", "바람숲", "구름숲", "달빛길", "바람길사이", "햇살속길", "산속고요", "강물소리",
						"푸른바람", "고요한바람", "별빛사이길", "구름사이바람", "바다속길", "햇빛속바람", "고요한길", "은빛길", "푸른숲길", "별빛고요",
						"달빛고요", "산속길사이", "구름속바람", "햇살고요", "별빛속길", "달빛속길", "고요한은빛길", "바람속고요", "산속바람결", "푸른바람길"
				};
				
				// 20240822_원진호_문제를 푸는 횟수 반복
				for(int j = 0; j < 5; j++) {
					
					String korWord = ""; // korArr에서 무작위로 받을 값
					String gameTxt = ""; // korWord 
					String missWord = "없음"; // 오타를 저장할 변수
					
					korWord = korArr[r.nextInt(korArr.length)]; // 랜덤으로 korArr에서 한글을 가져온다.
					gameTxt = korWord;	// 랜덤으로 받은 한글을 gameTxt에 저장한다.
					System.out.println(gameTxt); // 연습할 문제를 콘솔에 출력.
					
					long beforeTime = System.currentTimeMillis(); // 값을 받기전에 시간 
					String userTxt = in.nextLine(); // 값을 입력받을 변수
					long afterTime = System.currentTimeMillis(); // 값을 받은 후에 시간
					// 20240822_원진호_타자속도 측정(값을 받기전에 시간과 받은 후의 시간 차이 계산)
					long secDiffTime = (afterTime - beforeTime)/1000;	// 타이핑 시간 = 입력후 엔터 타이핑 후 현재시간 - 입력전 현재시간.
					questionCnt++;					// 지금까지 풀었던 문제의 갯수.
					accSpeed += secDiffTime;		// 현재 사용자의 총 타이핑 시간.
					accTxt += gameTxt;				// 현재 까지 랜덤으로 받아온 문자열을 누적해서 총 문자열의 길이를 측정할때 사용.
					// 20240822_원진호_점수 계산하는 기능
					if(userTxt.equals(gameTxt)) {	// 사용자가 입력한 문자랑 gameTxt 가 같다면
						score += 20;				// 정답시 현재 사용자가 이 문제에서 획득한 점수는 10점 입니다. 
					}else {
						missWord = "";				// 오타난 문자를 받기위해 저장공간을 비워준다.
						score += 0; 				// 오답시 현재 사용자가 이 문제에서 획득한 점수는 10점 입니다.
					}
					// 20240822_원진호_오답 개수 카운트
					// gameTxt의 길이만큼 반복해서 ---> userTxt중 문자가 gameTxt중 문자랑 같지 않다면 ---> 오답의 갯수를 저장하는 missCnt를 1중가. & 오타난 문자를 missWord에 저장. 
					for(int k = 0; k < gameTxt.length(); k++) {
						if(userTxt.charAt(k) != gameTxt.charAt(k)) {
							missCnt++;
							missWord += userTxt.charAt(k) + " ";	// 비워져 있는 missWord 에 잘못 입력한 문자를 담는다.
						}
					}
					// 현재 사용자의 입력 속도를 측정하는 코드. ( 현재 사용자의 총 타이핑 시간 / 문제의 개수)
					userSpeed[i] = Math.round((accSpeed / questionCnt) * 10) / 10.0; // 소수점 3자리까지 끊어쓰기
					// 현재 사용자의 정확도를 계산하는 코드. 
					userCorrect[i] = Math.round(((1 - (double) missCnt / accTxt.length()) * 100) * 10) / 10.0; // 소수점 3자리까지 끊어쓰기
					// 현재 사용자의 점수를 계산하는 코드.
					userPoint[i] =  score; 									// 사용자 현재 점수
					System.out.print("타이핑 시간 : "+secDiffTime + "초 / ");	// 타자속도 출력.
					System.out.print("오타 : " + missWord + " / ");			// 오타난 부분의 문자 출력.
					System.out.print("현재 점수 : "+ score);				    // 현재 사용자가 지금까지 확득한 점수 출력.
					System.out.println("\n");								// 줄바꿈.
				}
				
			}
		}else {
			// 지용님 만든 파일
			for(int i = 0; i < userCnt; i++) {
				int missCnt = 0; // 오답 카운트
				int score = 0; // 기본 점수
				
				String accTxt = "";
				double questionCnt = 0;
				double accSpeed = 0;
				System.out.println((i+1) + "번째 ID를 입력해주세요");
				userId[i] = in.nextLine();
				String[] korArr = {
						"연못", "강물", "해변", "고요", "바위", "은하수", "산길", "낙엽", "그림자", "사랑",
						"파랑", "노래", "봄바람", "눈꽃", "별빛", "바람결", "햇빛", "하얀", "푸른", "가슴",
						"달빛", "비밀", "가로등", "기억", "연기", "파도", "은빛", "물결", "바다", "나뭇잎",
						"낮", "구름", "길", "여울", "초록", "흰", "노을", "나비", "산책", "아침",
						"빛", "별", "하늘", "가을", "겨울", "봄", "여름", "밤하늘", "꿈", "기다림",
						"추억", "소리", "시간", "달", "하루", "웃음", "돌", "새", "작은", "낮잠",
						"바람", "눈물", "희망", "봄꽃", "고양이", "나무", "햇살", "미소", "초원", "바다새",
						"은하", "무지개", "고요함", "동산", "별님", "달님", "바람개비", "푸르름", "햇빛", "구름사이",
						"여명", "파도소리", "바다빛", "산등성", "고갯길", "아지랑이", "낙조", "별똥별", "해돋이", "산새",
						"풀잎", "꽃향기", "숲속", "돌담", "해오라기", "비바람", "가로수", "석양", "고향", "산들바람",
						"햇살밭", "꽃길", "고드름", "이슬", "바람꽃", "산골", "은빛", "모래사장", "물방울", "새소리",
						"강가", "별무리", "구름다리", "달빛사이", "은하수길", "고요한밤", "하얀구름", "푸른하늘", "햇살길", "아침햇살",
						"이른아침", "구름산", "바람소리", "달그림자", "물안개", "숲속길", "바람결", "고요한산", "별나라", "강둑",
						"작은섬", "바람산", "고요한숲", "햇살속", "별빛길", "나무숲", "바다길", "푸른산", "파란하늘", "구름바람",
						"고요한강", "별빛바람", "산속길", "달빛산", "바다속", "은빛파도", "구름사이길", "별빛속", "바람길", "산속물결",
						"고요한바다", "햇빛숲", "푸른초원", "바람숲", "구름숲", "달빛길", "바람길사이", "햇살속길", "산속고요", "강물소리",
						"푸른바람", "고요한바람", "별빛사이길", "구름사이바람", "바다속길", "햇빛속바람", "고요한길", "은빛길", "푸른숲길", "별빛고요",
						"달빛고요", "산속길사이", "구름속바람", "햇살고요", "별빛속길", "달빛속길", "고요한은빛길", "바람속고요", "산속바람결", "푸른바람길"
				};
				
				String[] signArr = new String[180];
				String sign = "~?!@#$%^&*()-_+=[]{}<>";
				String word2 = "";
				// 특수문자 배열에 집어넣기
				// 20240822_정지용_랜덤으로 특수문자를 중복없이 뽑아오는 기능_수정완료
				for(int j = 0; j < signArr.length; j++) {
					for(int k = 0; k < 3; k++) {
						char t_sign = sign.charAt(r.nextInt(sign.length()));	// 특수문자를 랜덤으로 가져와 저장하기.
						if(k == 0) {						
							word2 += sign.charAt(r.nextInt(sign.length()));
						}
						for(int l = 0; l < word2.length(); l++) {
							if(word2.charAt(l) == t_sign) {							
								if(k != 0) {
									k--;
									break;	
								}
								break;
							}
							if(l == word2.length() - 1) {
								word2 += t_sign;
							}
							if(word2.length() == 3) {
								break;
							}
						}
					}
					signArr[j] = word2;
					word2 = "";
				}
				for(int j = 0; j < 5; j++) {
					
					String korWord = ""; // korArr에서 무작위로 받을 값
					String signWord = ""; // signArr에서 무작위로 받을 값
					String gameTxt = ""; // korWord + signWord
					String randomGameTxt = "";
					String missWord = "없음"; // 오타를 저장할 변수
					
					korWord = korArr[r.nextInt(korArr.length)];
					signWord = signArr[r.nextInt(signArr.length)];
					gameTxt = korWord + signWord;
					// 게임 문자 랜덤으로 조합
					// 20240822_정지용_게임문자열을 중복없이 랜덤으로 뽑아오는 기능_수정완료
					for(int k = 0; k < gameTxt.length(); k++) {
						char t_txt = gameTxt.charAt(r.nextInt(gameTxt.length())); // 첫번째 쓸 변수
						char r_txt = gameTxt.charAt(r.nextInt(gameTxt.length())); // 두번째부터 쓸 변수
						if(randomGameTxt.length() == 0) {
							randomGameTxt += t_txt;
//						System.out.println("첫 단어 : " + randomGameTxt);
						}
//					System.out.println(gameTxt);
						for(int l = 0; l < randomGameTxt.length(); l++) {
//						System.out.println("문자 : " + r_txt);
							if(randomGameTxt.charAt(l) != r_txt) {
//							System.out.println(randomGameTxt.charAt(l) + " 문자가 다름 " + r_txt);
							}else {
								if(k != 0) {
//								System.out.println("같은 랜덤 수 : " + r_txt);
//								System.out.println(randomGameTxt);
									k--;
									break;	
								}
								break;
							}
							if(l == randomGameTxt.length() - 1) {
								randomGameTxt += r_txt;
//							System.out.println(randomGameTxt);
							}
							if(randomGameTxt.length() == gameTxt.length()) {
								break;
							}
						}
					}
					System.out.println(randomGameTxt);
					long beforeTime = System.currentTimeMillis();
					String userTxt = in.nextLine(); // 값을 입력받을 변수
					long afterTime = System.currentTimeMillis();
					long secDiffTime = (afterTime - beforeTime)/1000;
					questionCnt++;
					accSpeed += secDiffTime;
					accTxt += gameTxt;
					// 20240822_정지용_점수 계산
					if(userTxt.equals(randomGameTxt)) {
						score += 10;
					}else {
						missWord = "";
						score += 0;
					}
					// 20240822_정지용_오답 개수 카운트
					for(int k = 0; k < randomGameTxt.length(); k++) {
						if(userTxt.charAt(k) != randomGameTxt.charAt(k)) {
							missCnt++;
							missWord += userTxt.charAt(k) + " ";
						}
					}
					// 20240822_정지용_ 플레이유저의 타자속도, 정확도, 점수 계산 
					userSpeed[i] = Math.round((accSpeed / questionCnt) * 10) / 10.0; // 소수점 3자리까지 끊어쓰기
					userCorrect[i] = Math.round(((1 - (double) missCnt / accTxt.length()) * 100) * 10) / 10.0; // 소수점 3자리까지 끊어쓰기
					userPoint[i] =  score; // 점수
					System.out.print("타이핑 시간 : "+secDiffTime + "초 / ");
					System.out.print("오타 : " + missWord + " / ");
					System.out.print("현재 점수 : "+ score);
					System.out.println("\n");
				}
				
			}
		}
		
		// 20240822_정지용_타자속도 점수 환산
		for(int i = 0; i < userCnt; i++) {
			if(userSpeed[i] < 2) {
				userSpeedScore[i] = 100 * 0.2;
			}else if(userSpeed[i] < 4) {
				userSpeedScore[i] = 80 * 0.2;
			}else if(userSpeed[i] < 6) {
				userSpeedScore[i] = 60 * 0.2;
			}else if(userSpeed[i] < 8) {
				userSpeedScore[i] = 40 * 0.2;
			}else if(userSpeed[i] < 10) {
				userSpeedScore[i] = 20 * 0.2;
			}else {
				userSpeedScore[i] = 0;
			}
		}
		// 20240822_정지용_정확도 점수 환산
		for(int i = 0; i < userCnt; i++) {
			userCorrectScore[i] = Math.round((userCorrect[i] * 0.3) * 10) / 10.0;
		}
		// 20240822_정지용_총점 계산 (점수 * 0.5) + 속도 환산점수 + 정확도 환산점수
		for(int i = 0; i < userCnt; i++) {
			userTotalScore[i] = Math.round(((userPoint[i] * 0.5) + userSpeedScore[i] + userCorrectScore[i]) * 100) / 100.0;			
		}
		// 20240822_원진호_순위를 매기기 위한 반복문
		int [] ranking = new int[userCnt];		// ranking 이라는 int 배열의 길이를 userCnt 만큰 선언한다.
		double max_num = 0;						// max_num 이라는 double 타입의 변수를 선언한다, 이 변수는 사용자 점수 중 최대값을 받기 위함이다.
		int max_index = 0;						// int 타입의 max_index 변수를 선언했다, 이 변수는 최대점수의 인덱스값을 저장하기 위함이다.
		int x = 0;								// ranking 배열의 인덱스값으로 사용하기 위해 만들었다.
		for(int i = 0; i < userCnt; i++) {		// 사용자의 인원수 만큼 반복
			if(userTotalScore[i] > max_num) {	// 모든 사용자의 총점수 중 최대값과 그의 인덱스를 받아온다.
				max_num = userTotalScore[i];	// userTotalScore 중 최대값을 max_num에 대입한다.
				max_index = i;					// 최대 점수의 인덱스를 max_index에 저장한다.
			}
			if(i == userCnt - 1) {				// 
				ranking[x] = max_index;			// userTotalScore배열중 최대값의 인덱스를 ranking 배열의 x번 인덱스의 저장한다.
				userTotalScore[max_index] = 0;	// 기존에 있는 최대값을 0으로 바꾼다. ( 다음 최대값 검색을 위해.)
				max_num = 0;					// 최대값을 0으로 초기화 한다. (두번째 큰 값을 담기 위함니다.)
				max_index = 0;					// 최대값의 인덱스도 0으로 초기화 한다. (두번째 큰 값의 인덱스을 담기 위함니다.)
				x++;							// ranking 배열의 다음 인덱스의 두번째 큰 값을 담기위해, ranking 의 인덱스인 x 를 1중가한다. 
				i = -1;							// i 에 -1를 대입하면 i 가 1중가 될때마다. 반복문이 0부터 시작하기 때문에 무한 반복을 구현할 수 있다.
			}
			if(x == userCnt) {					// ranking 의 인덱스인 x 가 사용자 인원수랑 같을때. (마지막 인원의 점수까지 n번째 큰 최대값으로 받아 왔을때.)
				break;							// 반복문을 빠져나간다.
			}
		}
		// 20240822_원진호_총점이 0이 되버려서 다시 원상복구 작업
		for(int i = 0; i < userCnt; i++) {
			userTotalScore[i] = Math.round(((userPoint[i] * 0.5) + userSpeedScore[i] + userCorrectScore[i]) * 100) / 100.0;			
		}
		// 결과
		System.out.println("총점은 (점수 + 속도 + 정확도)의 환산값 입니다.");
		System.out.println("이름   총점   점수   속도   정확도");
		System.out.println("---------------------------");
		for(int i = 0; i < userCnt; i++) {			
			System.out.println(userId[ranking[i]] + "   " + userTotalScore[ranking[i]] + 
					"  " + userPoint[ranking[i]] + "   " + userSpeed[ranking[i]] + 
					"   " + userCorrect[ranking[i]]);
		}
		

	}

}
