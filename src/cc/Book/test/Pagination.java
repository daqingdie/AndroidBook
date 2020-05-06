package cc.Book.test;

public class Pagination {

	/**
	 * @param pageNum      当前页数
	 * @param pageCount    总页数
	 * @param recordCount  总记录数
	 * @param pageUrl      页面 URL
	 * @return
	 */
	public static String getPagination(int pageNum, int pageCount,
			int recordCount, String pageUrl) {

		String url = pageUrl.contains("?") ? pageUrl : pageUrl + "?";
		if(!url.endsWith("?") && !url.endsWith("&")){
			url += "&";
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("第 " + pageNum + "/" + pageCount + " 页 共 " + recordCount
				+ " 记录 ");

		buffer.append(pageNum == 1 ? " 第一页 " : " <a href='" + url
				+ "pageNum=1'>第一页</a> ");
		buffer.append(pageNum == 1 ? " 上一页 " : " <a href='" + url + "pageNum="
				+ (pageNum - 1) + "'>上一页</a> ");
		buffer.append(pageNum == pageCount ? " 下一页 " : " <a href='" + url
				+ "pageNum=" + (pageNum + 1) + "'>下一页</a> ");
		buffer.append(pageNum == pageCount ? " 最后一页 " : " <a href='" + url
				+ "pageNum=" + pageCount + "'>最后一页</a> ");
		
		return buffer.toString();
	}
}

