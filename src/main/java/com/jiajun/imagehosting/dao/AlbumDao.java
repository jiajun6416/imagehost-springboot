package com.jiajun.imagehosting.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jiajun.common.base.BaseDao;
import com.jiajun.imagehosting.domain.AlbumEntity;

@Repository
public class AlbumDao extends BaseDao<AlbumEntity> {

	@Override
	protected String getNamespace() {
		return "albumEntityMapper";
	}
	
	public AlbumEntity selectByAlbumNameAndUserId(String albumName, Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", albumName);
		params.put("userId", userId);
		return (AlbumEntity)selectObject("selectByUserAndName", params);
	}
	
	public List<AlbumEntity> selectContainImageByUserId(Integer id) {
		return selectList("selectContainImageByUserId", id);
	}
	
	public List<AlbumEntity> selectByUserId(Integer userId) {
		return selectList("selectByUserId", userId);
	}
	
	public List<Integer> selectIdsByUserId(Integer userId) {
		return selectList("selectIdsByUserId",userId);
	}
	
	public void updateAlbumAuthority(Integer albumId, int isPublic) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", albumId);
		params.put("isPublic", isPublic);
		params.put("updateTime", new Date());
		update("updateAlbumAuthority", params);
	}
	
	public List<AlbumEntity> selectContainImageNumsByUserId(Integer userId) {
		return selectList("selectContainImageNumsByUserId", userId);
	}
}
