package com.neusoft.ht.fee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.ht.fee.model.HeatingPriceModel;
import com.neusoft.ht.fee.service.IHeatingPriceService;
import com.neusoft.ht.message.ResultMessage;

@RestController
@RequestMapping(value="/heatingprice")
public class HeatingPriceController {
	@Autowired
	private IHeatingPriceService heatingPriceService = null;
		
	//增加
	@PostMapping("/add")
	public ResultMessage<HeatingPriceModel> add(HeatingPriceModel heatingPriceModel ) throws Exception {
			
		try {
			heatingPriceService.add(heatingPriceModel);
		}catch (Exception e) {
			return new ResultMessage<HeatingPriceModel>("ERROR",heatingPriceModel.getHeatingyear()+"年度供热价格已存在");
		}			
			return new ResultMessage<HeatingPriceModel>("OK","增加年度供热价格成功");	
	}

	//修改
	@PostMapping("/modify")
	public ResultMessage<HeatingPriceModel> modify(HeatingPriceModel heatingPriceModel ) throws Exception {
		heatingPriceService.modify(heatingPriceModel);
		return new ResultMessage<HeatingPriceModel>("OK","修改年度供热价格信息成功");
	
	}

	//删除
	@PostMapping("/delete")
	public ResultMessage<HeatingPriceModel> delete(HeatingPriceModel heatingPriceModel) throws Exception {
		heatingPriceService.delete(heatingPriceModel);
		return new ResultMessage<HeatingPriceModel>("OK","删除年度供热价格信息成功");
	}

	//取得指定的年度供热价格信息
	@GetMapping("/get")
	public HeatingPriceModel getByYear(String heatingyear) throws Exception{
		return heatingPriceService.getByYear(heatingyear);
	}
		
	//取得所有列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<HeatingPriceModel> getListByAllWitPage(@RequestParam(required = false,defaultValue ="4") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
			
		ResultMessage<HeatingPriceModel> result=new ResultMessage<HeatingPriceModel>("OK","取得年度供热价格信息列表分页模式成功");
		result.setCount(heatingPriceService.getCountByAll());
		result.setPageCount(heatingPriceService.getPagaCountByAll(rows));
		result.setList(heatingPriceService.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
			
		return result;
	}
		
	//取得所有列表，无分页
	@GetMapping(value="/list/all")
	public List<HeatingPriceModel> getListByAllWithPriceAndDay() throws Exception{
		return heatingPriceService.getListByAllWithPriceAndDay();
	}
}
