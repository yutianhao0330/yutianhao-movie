package com.yutianhao.movie.domain.query;


/**
 * 
    * @ClassName: MovieQuery
    * @Description: 封装电影查询信息的mojo类
    * @author thyu
    * @date 2020年3月23日
    *
 */
public class MovieQuery {
	private String name;
	private String director;
	private Integer legend;
	private String startTime;
	private String endTime;
	private Double lowerPrice;
	private Double upperPrice;
	private Integer lowerLength;
	private Integer upperLength;
	public MovieQuery() {
		super();
	}
	public MovieQuery(String name, String director, Integer legend, String startTime, String endTime, Double lowerPrice,
			Double upperPrice, Integer lowerLength, Integer upperLength) {
		super();
		this.name = name;
		this.director = director;
		this.legend = legend;
		this.startTime = startTime;
		this.endTime = endTime;
		this.lowerPrice = lowerPrice;
		this.upperPrice = upperPrice;
		this.lowerLength = lowerLength;
		this.upperLength = upperLength;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getLegend() {
		return legend;
	}
	public void setLegend(Integer legend) {
		this.legend = legend;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Double getLowerPrice() {
		return lowerPrice;
	}
	public void setLowerPrice(Double lowerPrice) {
		this.lowerPrice = lowerPrice;
	}
	public Double getUpperPrice() {
		return upperPrice;
	}
	public void setUpperPrice(Double upperPrice) {
		this.upperPrice = upperPrice;
	}
	public Integer getLowerLength() {
		return lowerLength;
	}
	public void setLowerLength(Integer lowerLength) {
		this.lowerLength = lowerLength;
	}
	public Integer getUpperLength() {
		return upperLength;
	}
	public void setUpperLength(Integer upperLength) {
		this.upperLength = upperLength;
	}
	@Override
	public String toString() {
		return "MovieQuery [name=" + name + ", director=" + director + ", legend=" + legend + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", lowerPrice=" + lowerPrice + ", upperPrice=" + upperPrice
				+ ", lowerLength=" + lowerLength + ", upperLength=" + upperLength + "]";
	}
	
}
