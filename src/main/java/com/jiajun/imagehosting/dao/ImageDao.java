package com.jiajun.imagehosting.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jiajun.common.base.BaseDao;
import com.jiajun.imagehosting.domain.ImageEntity;

@Repository
public class ImageDao extends BaseDao<ImageEntity> {

	@Override
	protected String getNamespace() {
		return "imageEntityMapper";
	}

	public ImageEntity selectByUnique(String uniqueName) {
		return (ImageEntity) selectObject("selectByUnique", uniqueName);
	}

	public List<ImageEntity> selectByAlbumId(Integer albumId) {
		return selectList("selectByAlbumId", albumId);
	}

	public int selectCountByAlbumId(Integer albumId) {
		return (int) selectObject("selectCountByAlbumId", albumId);
	}

	public List<Integer> selectIdsByUserId(Integer userId) {
		return selectList("selectIdsByUserId", userId);
	}
}
