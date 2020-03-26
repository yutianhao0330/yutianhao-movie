package com.yutianhao.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.yutianhao.movie.domain.Movie;
import com.yutianhao.movie.domain.query.MovieQuery;
import com.yutianhao.movie.service.MovieService;
/**
 * 
    * @ClassName: MovieController
    * @Description: 电影的控制器,处理movie类相关请求
    * @author thyu
    * @date 2020年3月23日
    *
 */
@Controller
@RequestMapping("movie")
public class MovieController {
	@Autowired
	private MovieService movieService;
	/**
	 * 
	    * @Title: list
	    * @Description: 多条件分页查询电影信息并排序
	    * @param @param model
	    * @param @param pageNum 页码值，默认为1
	    * @param @param pageSize 每页条数，默认为5条
	    * @param @param name 影片名称，模糊查询条件
	    * @param @param startTime 上映起始时间
	    * @param @param endTime 上映终点时间
	    * @param @param director 导演名，模糊查询条件
	    * @param @param lowerPrice 价格最低值
	    * @param @param upperPrice 价格最高值
	    * @param @param legend 电影年代，精确查询条件(非模糊查询)
	    * @param @param lowerLength 电影时长最小值
	    * @param @param upperLength 电影时长最大值
	    * @param @param condition 排序条件，默认按时间排序
	    * @param @param order 排序方式，默认为降序
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping("list")
	public String list(Model model,
			@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "5")int pageSize,
			String name,String startTime,String endTime,String director,
			Double lowerPrice,Double upperPrice,Integer legend,
			Integer lowerLength,Integer upperLength,@RequestParam(defaultValue = "showDate")String condition,@RequestParam(defaultValue = "desc")String order) {
		MovieQuery query = new MovieQuery(name, director, legend, startTime, endTime, lowerPrice, upperPrice, lowerLength, upperLength);
		PageInfo<Movie> page = movieService.getMovieList(pageNum, pageSize,query,condition,order);
		model.addAttribute("page", page);
		model.addAttribute("movieList", page.getList());
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("query", query);
		model.addAttribute("condition", condition);
		model.addAttribute("order", order);
		return "list";
	}
	/**
	 * 
	    * @Title: convert
	    * @Description: 切换电影的上架/下架状态
	    * @param @param id
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	@RequestMapping("convert")
	@ResponseBody
	public boolean convert(int id) {
		return movieService.convertState(id);
	}
	/**
	 * 
	    * @Title: delete
	    * @Description: 批量删除电影信息
	    * @param @param ids
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	@RequestMapping("delete")
	@ResponseBody
	public boolean delete(Integer[] ids) {
		return movieService.deleteMovie(ids);
	}
	/**
	 * 
	    * @Title: query
	    * @Description: 跳转到查询页面前，将上一次的查询条件放入作用域，方便回显
	   * @param @param model
	    * @param @param pageNum 页码值，默认为1
	    * @param @param pageSize 每页条数，默认为5条
	    * @param @param name 影片名称，模糊查询条件
	    * @param @param startTime 上映起始时间
	    * @param @param endTime 上映终点时间
	    * @param @param director 导演名，模糊查询条件
	    * @param @param lowerPrice 价格最低值
	    * @param @param upperPrice 价格最高值
	    * @param @param legend 电影年代，精确查询条件(非模糊查询)
	    * @param @param lowerLength 电影时长最小值
	    * @param @param upperLength 电影时长最大值
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@GetMapping("query")
	public String query(Model model,String name,String startTime,String endTime,String director,
			Double lowerPrice,Double upperPrice,Integer legend,
			Integer lowerLength,Integer upperLength) {
		MovieQuery query = new MovieQuery(name, director, legend, startTime, endTime, lowerPrice, upperPrice, lowerLength, upperLength);
		model.addAttribute("query", query);
		return "query";
	}
}
