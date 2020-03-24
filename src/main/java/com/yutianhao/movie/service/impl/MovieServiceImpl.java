package com.yutianhao.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yutianhao.movie.dao.MovieDao;
import com.yutianhao.movie.domain.Movie;
import com.yutianhao.movie.domain.query.MovieQuery;
import com.yutianhao.movie.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDao movieDao;

	@Override
	public PageInfo<Movie> getMovieList(int pageNum,int pageSize, MovieQuery query, String condition, String order) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Movie> movieList = movieDao.getMovieList(query,condition,order);
		PageInfo<Movie> page = new PageInfo<Movie>(movieList);
		if(!page.isHasPreviousPage()) {
			page.setPrePage(1);
		}
		if(!page.isHasNextPage()) {
			page.setNextPage(page.getPages());
		}
		return page;
	}

	@Override
	public boolean convertState(int id) {
		// TODO Auto-generated method stub
		try {
			return movieDao.convertState(id)>0;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("影片切换状态失败!");
		}
		
	}

	@Override
	public boolean deleteMovie(Integer[] ids) {
		// TODO Auto-generated method stub
		try {
			if(null!=ids && ids.length>0) {
				return movieDao.deleteMovie(ids)>0;
			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("批量删除失败!");
		}
		
	}
	
}
