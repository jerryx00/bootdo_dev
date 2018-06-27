package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.TomDO;
import com.bootdo.system.service.TomService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-23 20:06:42
 */
 
@Controller
@RequestMapping("/system/tom")
public class TomController {
	@Autowired
	private TomService tomService;
	
	@GetMapping()
	@RequiresPermissions("system:tom:tom")
	String Tom(){
	    return "system/tom/tom";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:tom:tom")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TomDO> tomList = tomService.list(query);
		int total = tomService.count(query);
		PageUtils pageUtils = new PageUtils(tomList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:tom:add")
	String add(){
	    return "system/tom/add";
	}

	@GetMapping("/edit/{tid}")
	@RequiresPermissions("system:tom:edit")
	String edit(@PathVariable("tid") Integer tid,Model model){
		TomDO tom = tomService.get(tid);
		model.addAttribute("tom", tom);
	    return "system/tom/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:tom:add")
	public R save( TomDO tom){
		if(tomService.save(tom)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:tom:edit")
	public R update( TomDO tom){
		tomService.update(tom);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:tom:remove")
	public R remove( Integer tid){
		if(tomService.remove(tid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:tom:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] tids){
		tomService.batchRemove(tids);
		return R.ok();
	}
	
}
