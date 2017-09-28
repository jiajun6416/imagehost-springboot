package com.jiajun.imagehosting.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.jiajun.imagehosting.dao.AlbumDao;
import com.jiajun.imagehosting.domain.AlbumEntity;
import com.jiajun.imagehosting.service.AlbumService;


@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumDao albumDao;

	@Override
	public AlbumEntity getById(int id) throws Exception {
		return albumDao.selectByPrimaryKey(id);
	}

	@Override
	public void save(AlbumEntity albumEntity) throws Exception {
		Date now = new Date();
		albumEntity.setCreateTime(now);
		albumEntity.setUpdateTime(now);
		albumEntity.setIsSelected(false);
		albumEntity.setIsDelete(false);
		albumDao.insert(albumEntity);
	}

	@Override
	public AlbumEntity getByUserAndName(Integer userId, String albumName) throws Exception {
		Assert.notNull(albumName,"相册名不能为空");
		return albumDao.selectByAlbumNameAndUserId(albumName, userId);
	}

	@Override
	public List<AlbumEntity> getHasAlbumsContainImage(Integer userId) throws Exception {
		return albumDao.selectContainImageByUserId(userId);
	}

	@Override
	@Cacheable(value = "album", key = "'getHasAlbums'+#p0")
	public List<AlbumEntity> getHasAlbums(Integer id) throws Exception {
		return albumDao.selectByUserId(id);
	}

	@Override
	public List<Integer> getHasAlbumIds(Integer userId) throws Exception {
		return albumDao.selectIdsByUserId(userId);
	}

	@Override
	public void updateAlbumAuthority(Integer albumId, int type) throws Exception {
		albumDao.updateAlbumAuthority(albumId, type == 0 ? 1 : 0);
	}

	@Override
	public void delete(Integer albumId) throws Exception {
		AlbumEntity albumEntity = new AlbumEntity();
		Date now = new Date();
		albumEntity.setId(albumId);
		albumEntity.setUpdateTime(now);
		albumEntity.setDeleteTime(now);
		albumEntity.setIsDelete(true);
		albumDao.updateByPrimaryKeySelective(albumEntity);
	}

	@Override
	public void update(AlbumEntity album) throws Exception {
		album.setUpdateTime(new Date());
		albumDao.updateByPrimaryKeySelective(album);
	}

	@Override
	public List<AlbumEntity> getHasAlbumsWithImageNums(Integer userId) throws Exception {
		return albumDao.selectContainImageNumsByUserId(userId);
	}
}
