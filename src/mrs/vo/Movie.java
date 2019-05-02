package mrs.vo;

import java.sql.Date;

/*
 * 영화 정보를 가지는 클래스
 */
public class Movie {

	private String title; // 영화 제목
	private String posterPath; // 영화 포스터 경로
	private String rating; // 관람 등급
	private Date openDate; // 개봉일
	private Date closeDate; // 마감일
	private String directorName; // 감독 이름
	private String castNames; // 출연진 이름
	private String genre; // 장르
	private String playTime; // 상영시간
	private String storyline; // 줄거리

	public Movie() {
	}

	public Movie(String title, String posterPath, String rating, Date openDate
			, Date closeDate, String directorName, String castNames, String genre
			, String playTime, String storyline) {
		this.title = title;
		this.posterPath = posterPath;
		this.rating = rating;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.directorName = directorName;
		this.castNames = castNames;
		this.genre = genre;
		this.playTime = playTime;
		this.storyline = storyline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getCastNames() {
		return castNames;
	}

	public void setCastNames(String castNames) {
		this.castNames = castNames;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlayTime() {
		return playTime;
	}

	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}

	public String getStoryline() {
		return storyline;
	}

	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}

	@Override
	public String toString() {
		return "title: " + title + ", posterPath: " + posterPath
				+ ", rating: " + rating + ", openDate: " + openDate
				+ ", closeDate: " + closeDate + ", directorName: " + directorName
				+ ", castNames: " + castNames + ", genre: " + genre
				+ ", playTime: " + playTime + ", storyline: " + storyline;
	}

}
