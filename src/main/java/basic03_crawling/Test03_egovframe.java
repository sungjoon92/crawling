package basic03_crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test03_egovframe {

	public static void main(String[] args) {

		// 참조 http://pretyimo.cafe24.com/lectureRead.do?lectureno=333
		// 개인 혹은 단체에서 필요한 데이터가 있는 웹(web)페이지의 구조를 분석하고 파악하여 긁어온다
		// 예) https://www.daum.net/robots.txt
		// https://www.naver.com/robots.txt
		// http://world.kbs.co.kr/robots.txt
		// http://ytn.co.kr/robots.txt

		// https://www.choongang.co.kr/

		// 프레임워크의 공지사항 웹페이지 소스 가져오기
		try {

			String URL = "https://www.egovframe.go.kr/home/ntt/nttList.do";
			String params = "?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=0";
			// 공지사항 THML 페이지 1~23 페이지 소스 가져오기
			for (int p = 0; p <= 220; p += 10) {
				String page = "&pagerOffset=" + p;
//				System.out.println(params+page);
				Document doc = Jsoup.connect(URL + params + page).get();
				System.out.println(doc.toString());
			} // for end

//			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=0
//			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=10
//			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=20
//			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=30
//			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=40
//			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=210
//			https://www.egovframe.go.kr/home/ntt/nttList.do?searchKey=&searchValue=&menuNo=74&bbsId=6&pagerOffset=220
		} catch (Exception e) {
			System.out.println("크롤링 실패: " + e);
		} // try ~ catch end

	}// main end
}// class end
