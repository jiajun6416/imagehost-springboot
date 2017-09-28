package com.jiajun.imagehosting.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiajun.common.bo.Page;
import com.jiajun.imagehosting.dao.ImageDao;
import com.jiajun.imagehosting.domain.ImageEntity;
import com.jiajun.imagehosting.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public void save(ImageEntity imageEntity) throws Exception {
		Date now = new Date();
		imageEntity.setCreateTime(now);
		imageEntity.setUpdateTime(now);
		imageEntity.setIsDelete(false);
		imageDao.insert(imageEntity);
	}

	@Override
	public ImageEntity getByUniqueName(String uniqueName) throws Exception {
		return imageDao.selectByUnique(uniqueName);
	}

	@Override
	public void updateImageName(Integer pId, String pName) throws Exception {
		ImageEntity imageEntity = new ImageEntity();
		imageEntity.setId(pId);
		imageEntity.setFileName(pName);
		imageEntity.setUpdateTime(new Date());
		imageDao.updateByPrimaryKeySelective(imageEntity);
	}

	@Override
	public void deleteImage(Integer pId) throws Exception {
		ImageEntity imageEntity = new ImageEntity();
		imageEntity.setId(pId);
		Date now = new Date();
		imageEntity.setUpdateTime(now);
		imageEntity.setDeleteTime(now);
		imageEntity.setIsDelete(true);
		imageDao.updateByPrimaryKeySelective(imageEntity);
	}

	@Override
	public List<ImageEntity> getByAlbumId(Integer albumId) throws Exception {
		return imageDao.selectByAlbumId(albumId);
	}

	@Override
	public int getCountByAlbumId(Integer albumId) throws Exception {
		return imageDao.selectCountByAlbumId(albumId);
	}

	@Override
	public void getPage(Page<ImageEntity> page) throws Exception {
		imageDao.page(page);
	}

	@Override
	public List<Integer> getIdsByUId(int userId) throws Exception {
		return imageDao.selectIdsByUserId(userId);
	}
}
