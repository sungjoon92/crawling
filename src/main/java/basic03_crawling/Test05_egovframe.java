package basic03_crawling;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.print.Doc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test05_egovframe {

	public static void main(String[] args) {

		// 전자정부 프레임워크 제목만 크롤링해서
		// egovtrame.txt 파일에 저장하기

		try {
			String fileName = "D:/java202307/workspace/basic03_crawling/src/main/java/basic03_crawling/egovframe.txt";
			FileWriter fw=new FileWriter(fileName, true); //추가모드
			PrintWriter out=new PrintWriter(fw, true);
			
			
			
			String URL = "https://www.egovframe.go.kr/home/ntt/nttList.do";
			String params = "?searchKey=&searchValue=&menuNo=74&bbsId=6";

			// 공지사항 THML 페이지 1~23 페이지 소스 가져오기
			for (int p = 0; p <= 220; p += 10) {
				String page = "&pagerOffset=" + p;
//				System.out.println(params+page);
				Document doc = Jsoup.connect(URL + params).get();
				// System.out.println(doc.toString());

				// 공지사항 제목만 빼고 크롤링하기
				Elements elements = doc.select(".lnk");

				elements.select(".a1").remove(); // class="a1" 요소 제거하기
				for (Element element : elements) {
					System.out.println(element.text());
					out.println(element.text());
				} // for end
			} // for end
			
			
			out.close();
			fw.close();
			
			System.out.println("----------egovframe.txt 공지사항 제목 저장 완료!!");

			
			

		} catch (Exception e) {
			System.out.println("크롤링 실패: " + e);
		} // try ~ catch end

	}// main end
}// class end
