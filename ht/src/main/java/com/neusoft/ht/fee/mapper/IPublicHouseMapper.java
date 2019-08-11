package com.neusoft.ht.fee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.ht.fee.model.PublicHouseModel;
/**模块：供热缴费管理
 * 供热公建管理的Mapper接口
 * @author 黄宇德
 *
 */
public interface IPublicHouseMapper {
	//C
	public void insert(PublicHouseModel publicHouseModel) throws Exception;
	//U
	public void update(PublicHouseModel publicHouseModel) throws Exception;
	//R
	public List<PublicHouseModel> selectListByAll() throws Exception;
	//R2
	public PublicHouseModel selectByNo(int houseno) throws Exception;
	//R3
	public List<PublicHouseModel> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//D
	public void delete(PublicHouseModel publicHouseModel) throws Exception;
	//取得对象的个数(可选）
	public int selectCountByAll() throws Exception;
}
