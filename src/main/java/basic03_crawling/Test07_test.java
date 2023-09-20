package basic03_crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test07_test {

	public static void main(String[] args) {

		// 전자정부 프레임워크 제목만 크롤링해서
		// egovtrame.txt 파일에 저장하기
//		https://www.itwill.co.kr/cmn/board/BBSMSTR_000000000071/bbsList.do
		try {

			String URL = "https://movie.daum.net/moviedb/grade";
			String params = "?movieId=163887";
//			페이로드 주소  =   bbsId=BBSMSTR_000000000071&currentMenuNo=1031100&pageIndex=1&searchCondition=0&searchKeyword=
		
			for (int p = 1; p <= 5; p++) {
				String page = "&pageIndex=" + p;
//				System.out.println(params + page); //?bbsId=BBSMSTR_000000000071&currentMenuNo=1031100&searchCondition=0&searchKeyword=&pageIndex=1
																// &pageIndex=   &이후값은 어디를들어가든 상관이없다
				Document doc = Jsoup.connect(URL + params + page).get();
//				System.out.println(doc.toString());

				Elements elements = doc.select("#mainContent > div > div.box_detailinfo > div.tabmenu_wrap > ul > li:nth-child(1) > a > span");

				for (Element element : elements) {
					System.out.println(element.text());	
				} // for end

			} // for end

		} catch (Exception e) {
			System.out.println("크롤링 실패: " + e);
		} // try ~ catch end

	}// main end
}// class end
