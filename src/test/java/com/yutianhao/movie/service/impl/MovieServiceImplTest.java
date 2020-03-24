package com.yutianhao.movie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.yutianhao.movie.domain.Movie;
import com.yutianhao.movie.domain.query.MovieQuery;
import com.yutianhao.movie.service.MovieService;
/**
 * 
    * @ClassName: MovieServiceImplTest
    * @Description: 电影类的单元测试类
    * @author thyu
    * @date 2020年3月23日
    *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class MovieServiceImplTest {
	@Resource
	private MovieService movieService;
	/**
	 * 
	    * @Title: testGetMovieList
	    * @Description: 查询电影信息的测试方法
	    * @param     参数
	    * @return void    返回类型
	    * @throws
	 */
	@Test
	public void testGetMovieList() {
		
		  PageInfo<Movie> page = movieService.getMovieList(1, 3, new MovieQuery(),"showDate","desc");
		  List<Movie> movieList = page.getList(); 
		  for (Movie movie : movieList) { 
			  System.out.println(movie);
		  }
		 
	}

}
