package basic03_crawling;

import javax.print.Doc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test04_egovframe {

	public static void main(String[] args) {

		//
		// 전자정부프레임워크의 공지사항 제목만 크롤링하기
		try {

			String URL = "https://www.egovframe.go.kr/home/ntt/nttList.do";
			String params = "?searchKey=&searchValue=&menuNo=74&bbsId=6";

			// 공지사항 THML 페이지 1~23 페이지 소스 가져오기
			for (int p = 0; p <= 220; p += 10) {
				String page = "&pagerOffset=" + p;
//				System.out.println(params+page);
				Document doc = Jsoup.connect(URL + params).get();
				// System.out.println(doc.toString());

				// 공지사항 제목만 크롤링하기
				/*
				 * //HTML 문서에서 class="ink" 적용된 요소 가져오기 Elements elements = doc.select(".lnk");
				 * 
				 * for(Element element : elements) { //for 개별요소 : 덩어리
				 * System.out.println(element.text()); }//for end
				 */

				// 공지사항 제목만 빼고 크롤링하기
				Elements elements = doc.select(".list_item");
				elements.select(".a1").remove();   //class="a1" 요소 제거하기
				for (Element element : elements) {
					System.out.println(element.text());
				} // for end

			} // for end

		} catch (Exception e) {
			System.out.println("크롤링 실패: " + e);
		} // try ~ catch end

	}// main end
}// class end
