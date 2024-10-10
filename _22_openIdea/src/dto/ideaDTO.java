package dto;

public class ideaDTO {
	private int num = 0;
	private String subject = null;
	private String content = null;
	private String writer  = null;
	private String indate  = null;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "num=[" + num + "] subject=[" + subject + "] content=[" + content + "] writer=[" + writer
				+ "] indate=[" + indate + "]";
	}
	
}
