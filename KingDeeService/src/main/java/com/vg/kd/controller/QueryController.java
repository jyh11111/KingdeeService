package com.vg.kd.controller;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vg.kd.entity.PartTmpEntity;
import com.vg.kd.entity.QueryResultEntity;
import com.vg.kd.mapper.PartTmpMapper;
 
import com.vg.kd.service.IPartTmpService;
import com.vg.kd.service.IQueryService;

import com.vg.kd.utils.LayuiTable;

@RestController
@RequestMapping("/query")

 
public class QueryController {
 
	 
	@Autowired
	private IPartTmpService parTmpService;

	@GetMapping("/page")

	public Map<String, Object> QueryPartTmp(Page page, PartTmpEntity part, String FShortNumber, String supply,
			String supplyord) {
		if (part.getFnumber() == null)
			return null;
		PartTmpEntity parttmp = new PartTmpEntity();
		// Page<PartTmpEntity> page1=new Page<PartTmpEntity>(1,1);
		page.setAscs("FitemID");
		QueryWrapper<PartTmpEntity> wrapper = new QueryWrapper<>();

		if (part.getFnumber() != null && part.getFnumber().length() != 0) {
			wrapper.likeRight("FNumber", part.getFnumber() + ".");
		}
		if (part.getPtype() != null && part.getPtype().length() != 0) {
			wrapper.eq("ptype", part.getPtype());
		}
		if (part.getV1() != null && part.getV1().length() != 0) {
			wrapper.like("V1", part.getV1().trim());
			wrapper.eq("F1", part.getF1());
		}
		if (part.getV2() != null && part.getV2().length() != 0) {
			wrapper.like("V2", part.getV2().trim());
			wrapper.eq("F2", part.getF2());
		}
		if (part.getV3() != null && part.getV3().length() != 0) {
			wrapper.like("V3", part.getV3().trim());
			wrapper.eq("F3", part.getF3());
		}
		if (part.getV4() != null && part.getV4().length() != 0) {
			wrapper.like("V4", part.getV4().trim());
			wrapper.eq("F4", part.getF4());
		}
		if (part.getV5() != null && part.getV5().length() != 0) {
			wrapper.like("V5", part.getV5().trim());
			wrapper.eq("F5", part.getF5());
		}
		if (part.getV6() != null && part.getV6().length() != 0) {
			wrapper.like("V6", part.getV6().trim());
			wrapper.eq("F6", part.getF6());
		}
		if (FShortNumber != "" && FShortNumber.length() != 0) {
			wrapper.like("FNumber", FShortNumber);
		}
		if (supply != "" && supply.length() != 0) {
			String lstr = supply;
			if (supplyord != "") {
				lstr = supply + supplyord + "__";
			} else {
				lstr = supply + "____";
			}

			wrapper.likeLeft("FNumber", lstr);

		}

		IPage<PartTmpEntity> pagepart = parttmp.selectPage(page, wrapper);

		// System.out.println( parTmpService.QueryPart(pagepart));
		page.setRecords(parTmpService.QueryPart(pagepart));
		return LayuiTable.tableData(page);
		// return LayuiTable.tableData(parTmpService.QueryPart(pagepart),
		// pagepart.getTotal());
		// LayuiTable.tableData(pagepart)
		// return parttmp.selectPage( new Page<PartTmpEntity>(1, 1),wrapper);
	}

	private void FillParamMap(Map paramMap, PartTmpEntity part) {
		Class clazz = part.getClass();
		Field[] fields = part.getClass().getDeclaredFields();// 得到属性
		for (Field field : fields) {
			PropertyDescriptor pd;
			try {
				pd = new PropertyDescriptor(field.getName(), clazz);
				Method getMethod = pd.getReadMethod();// 获得get方法
				Object val = getMethod.invoke(part);// 此处为执行该Object对象的get方法
				if (val instanceof String) {
					String val_str = (String) val;
					if (val_str != null && val_str.trim().length() != 0)
						paramMap.put(field.getName(), val_str.trim());
				} else if (val != null)
					paramMap.put(field.getName(), val);
			} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Method setMethod = pd.getWriteMethod();//获得set方法
			// setMethod.invoke(obj,"参数");//此处为执行该Object对象的set方法
		}

	}

//	@Autowired
//	private QueryResultMapper qMapper;
	//这个下面继续改！
//	@Autowired 
//	private IQueryService qMapperService;
	@Autowired
	@Qualifier("syQueryResultService")
	private IQueryService syQueryResultService;
	@Autowired
	@Qualifier("mcQueryResultService")
	private IQueryService mcQueryResultService;
	@Autowired
	@Qualifier("vgQueryResultService")
	private IQueryService vgQueryResultService;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/page2") // 这个可排序
	 
	public Map<String, Object> QueryPart(Page page, QueryResultEntity param, String ascField, String descField,String datasource) {
	 
		 
		if (param == null || param.getFNumber() == null)
			return null;
		// throw new Exception("没有传递任何参数！");
		if (ascField != null && ascField.length() > 0) {
			page.setAscs(ascField);
		}
		if (descField != null && descField.length() > 0) {
			page.setDescs(descField);
		}
		if ((ascField == null || ascField.length() <= 0) && (descField == null || descField.length() <= 0))
			page.setAscs("FItemId");
		// System.out.println(qMapper.selectQueryPage(page, param));
		// System.out.println(page);
		  if (datasource.equals("master")) 
		  {page.setRecords(mcQueryResultService.selectQueryPage(page, param)); }
		  else if (datasource.equals("db1"))
		  { page.setRecords(syQueryResultService.selectQueryPage(page, param));}
		  else if (datasource.equals("db2"))
		  {page.setRecords(vgQueryResultService.selectQueryPage(page, param));}
		  
//		page.setRecords(qMapperService.selectQueryPage(page, param));
//		page.setRecords(qMapper.selectQueryPage(page, param));
		return LayuiTable.tableData(page);
	}

	@GetMapping("/show")
	 
	public ModelAndView ShowPart(String fnumber,String datasource) {
		ModelAndView mv = new ModelAndView("partview");
		  if (datasource.equals("master")) 
		  {mv.addObject("part",mcQueryResultService.selectbyPartNumber(fnumber)); }
		  else if (datasource.equals("db1"))
		  { mv.addObject("part",syQueryResultService.selectbyPartNumber(fnumber)); }
		  else if (datasource.equals("db2"))
		  {mv.addObject("part",vgQueryResultService.selectbyPartNumber(fnumber)); }
		  
//		mv.addObject("part",qMapperService.selectbyPartNumber(fnumber));
//		mv.addObject("part", qMapper.selectbyPartNumber(fnumber));
		return mv;

	}

	  // 更改当前的DataSource 详见application.yml配置 master: #MC正式数据库 db1:
						// #SY正式数据库AIS20161208124844 db2: #VG正式数据库
 

}
