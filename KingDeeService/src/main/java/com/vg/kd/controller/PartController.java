package com.vg.kd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vg.kd.entity.PartEntity;
import com.vg.kd.entity.PartTmpEntity;
import com.vg.kd.service.IPartService;

 

 

@RestController
@RequestMapping("/part")
public class PartController {
	
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	IPartService partservice;
	@GetMapping("/query")
	 public IPage<PartEntity> QueryPart(Page page){
/*		PartEntity part=new PartEntity();
		part.selectPage(page, new Querywrapper<PartEntity>())*/
		
	/*	 return user.selectPage(new Page<User>(0, 12), null);*/
		return null;
	}
	
	/**  *  ：http://localhost:8080/part/query2?size=1&current=1<br>
	 * 
	 * @param page
	 * @return
	 */
	@GetMapping("/query2")
	public IPage<PartTmpEntity> QueryPartTmp(Page page){
		PartTmpEntity  parttmp=new PartTmpEntity();	 
//		QueryWrapper<PartTmpEntity> wrapper =new QueryWrapper<PartTmpEntity> ();
//		wrapper.orderByAsc("FitemId");
		Page<PartTmpEntity> page1=new Page<PartTmpEntity>(1,1);
		page1.setAscs("FitemID");
		return parttmp.selectPage(page1, null);
//		  return parttmp.selectPage(  new Page<PartTmpEntity>(1, 1),wrapper); 
	}
//	page.setAscs("FItemId");
//	
//	
//	  System.out.println(page);
	
//	@GetMapping("/getpart")
//	public List<PartEntity> test() {
//	partservice.selectOne(new Wrapper<PartEntity>());
//	return	partservice.selectList(new QueryWrapper<PartEntity>().);
//		 
//	}
	@RequestMapping("/index")
	public ModelAndView index() {
		 ModelAndView mv = new ModelAndView("index");
		 String appContext = request.getContextPath();
		String basePath= request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext; 
		 mv.addObject("basePath", basePath);
	     

		 mv.addObject("name", "一引起名管子。。");
	        return mv;
	}

}
