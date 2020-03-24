package com.yutianhao.movie.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 
    * @ClassName: Movie
    * @Description: 电影的mojo类
    * @author thyu
    * @date 2020年3月23日
    *
 */
public class Movie {
	private Integer id;
	private String name;
	private String director;
	private Double price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date showDate;
	private Integer timeLength;
	private String typeName;
	private Integer legend;
	private String area;
	private Integer state;
	public Movie() {
		super();
	}
	public Movie(Integer id, String name, String director, Double price, Date showDate, Integer timeLength,
			String typeName, Integer legend, String area, Integer state) {
		super();
		this.id = id;
		this.name = name;
		this.director = director;
		this.price = price;
		this.showDate = showDate;
		this.timeLength = timeLength;
		this.typeName = typeName;
		this.legend = legend;
		this.area = area;
		this.state = state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public Integer getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(Integer timeLength) {
		this.timeLength = timeLength;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getLegend() {
		return legend;
	}
	public void setLegend(Integer legend) {
		this.legend = legend;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", price=" + price + ", showDate="
				+ showDate + ", timeLength=" + timeLength + ", typeName=" + typeName + ", legend=" + legend + ", area="
				+ area + ", state=" + state + "]";
	}
	
}
