package com.bootdo.system.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.controller.ExcelExportUtil4DIY;
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

import com.bootdo.system.domain.JerryDO;
import com.bootdo.system.service.JerryService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-06-23 15:54:20
 */
 
@Controller
@RequestMapping("/system/jerry")
public class JerryController {
	@Autowired
	private JerryService jerryService;
	
	@GetMapping()
	@RequiresPermissions("system:jerry:jerry")
	String Jerry(){
	    return "system/jerry/jerry";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:jerry:jerry")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<JerryDO> jerryList = jerryService.list(query);
		int total = jerryService.count(query);
		PageUtils pageUtils = new PageUtils(jerryList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:jerry:add")
	String add(){
	    return "system/jerry/add";
	}

	@GetMapping("/edit/{jid}")
	@RequiresPermissions("system:jerry:edit")
	String edit(@PathVariable("jid") Integer jid,Model model){
		JerryDO jerry = jerryService.get(jid);
		model.addAttribute("jerry", jerry);
	    return "system/jerry/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:jerry:add")
	public R save( JerryDO jerry){
		if(jerryService.save(jerry)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:jerry:edit")
	public R update( JerryDO jerry){
		jerryService.update(jerry);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:jerry:remove")
	public R remove( Integer jid){
		if(jerryService.remove(jid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:jerry:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] jids){
		jerryService.batchRemove(jids);
		return R.ok();
	}


	/**
	 * 导出
	 * @param request
	 * @param response
	 * @author 小帅丶
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/exportExcel")
	public void exportExcel(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String filename = "测试导出功能"+format.format(new Date().getTime())+".xls";
		response.setContentType("application/ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes(),"iso-8859-1"));
		OutputStream out = response.getOutputStream();
		try {
			Query query = new Query(params);
			String type = request.getParameter("type");
			//导出当前页面数据
			if(type.equals("1")){
				List<JerryDO> XxxDOs = jerryService.list(query);
				ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
			}
			//导出全部数据
			if(type.equals("2")){
				List<JerryDO> XxxDOs = jerryService.list(null);
				ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
			}
			//导出符合条件的全部数据
			if(type.equals("3")){
				query.remove("offset");
				query.remove("limit");
				List<JerryDO> XxxDOs = jerryService.list(query);
				ExcelExportUtil4DIY.exportToFile(XxxDOs,out);
			}
		} catch (Exception e) {
			e.printStackTrace();
//			logger.info("exportExcel出错"+e.getMessage());
		}finally{
			out.close();
		}
	}
}
