package com.yutianhao.movie.service;

import com.github.pagehelper.PageInfo;
import com.yutianhao.movie.domain.Movie;
import com.yutianhao.movie.domain.query.MovieQuery;
/**
 * 
    * @ClassName: MovieService
    * @Description: 电影类的service接口
    * @author thyu
    * @date 2020年3月23日
    *
 */
public interface MovieService {
	/**
	 * 
	    * @Title: getMovieList
	    * @Description: 查询电影信息
	    * @param @param pageNum  页码值
	    * @param @param pageSize  每页条数
	    * @param @param query  封装了查询条件的类
	    * @param @param condition  排序条件
	    * @param @param order 升序/降序
	    * @param @return    参数
	    * @return List<Movie>   查询到的电影结果
	    * @throws
	 */
	PageInfo<Movie> getMovieList(int pageNum,int pageSize, MovieQuery query, String condition, String order);
	/**
	 * 
	    * @Title: convertState
	    * @Description: 转化电影上架/下架状态
	    * @param @param 电影的id
	    * @param @return    参数
	    * @return boolean    受影响的记录数
	    * @throws
	 */
	boolean convertState(int id);
	/**
	 * 
	    * @Title: deleteMovie
	    * @Description: 批量删除电影信息
	    * @param @param 要删除的电影id值的数组
	    * @param @return    参数
	    * @return int    受影响的记录数
	    * @throws
	 */
	boolean deleteMovie(Integer[] ids);
}
