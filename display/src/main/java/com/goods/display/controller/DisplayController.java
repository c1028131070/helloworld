package com.goods.display.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.goods.display.api.DTO.HistoryPriceResponseDTO;
import com.goods.display.api.DTO.SearchResponseDTO;
import com.goods.search.api.DTO.HistoryPriceRequestDTO;
import com.goods.search.api.DTO.SearchRequestDTO;
import com.goods.search.entity.Product;
import com.goods.search.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>类名: ProductController</pre>
 * <pre>描述: 展示模块控制器</pre>
 * <pre>版权: 浙江理工大学信息学院</pre>
 * <pre>日期: 2019/1/20 20:58</pre>
 * <pre>作者: chenwb</pre>
 */
@Controller
public class DisplayController {
	private static Logger logger = LoggerFactory.getLogger(DisplayController.class);

	@Reference
	SearchService searchService;

	@Value("${diff.display.cxfs}")
	private String cxfs;

	/**
	 * @param
	 * @return 输出参数
	 * @Description: 测试
	 * @author chenwb
	 * @date 2019/1/21 10:13
	 */
	@RequestMapping("/index")
	public String toIndex(ModelMap map) {
		return "index";
	}

	@RequestMapping("/result")
	public String toResult(ModelMap map) {
		return "result";
	}

	@RequestMapping("/result1")
	public void toResult1() {
		System.out.println(cxfs);
	}

	/**
	 * @param searchRequestDTO
	 * @return SearchResponseDTO
	 * @Description: 分页查询商品信息
	 * @author chenwb
	 * @date 2019/2/22 13:26
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public SearchResponseDTO search(@RequestBody SearchRequestDTO searchRequestDTO) {
		SearchResponseDTO searchResponseDTO = new SearchResponseDTO();
		try {
			searchResponseDTO = searchService.search(searchRequestDTO);
		} catch (NullPointerException e) {
			logger.error("Dubbo服务调用失败，请确认zookeeper是否启动，或重启服务");
		}

		if (searchResponseDTO.getTotal() == 0) {
			return searchResponseDTO;
		}
		for (Product product : searchResponseDTO.getProducts()) {
			product.setProductImg(product.getProductImg().split(",")[0]);
		}
		logger.info("商品数量{}", searchResponseDTO.getProducts().size());
		return searchResponseDTO;
	}

	/**
	 * @param historyPriceRequestDTO
	 * @return HistoryPriceResponseDTO
	 * @Description: 查询商品历史价格信息
	 * @author chenwb
	 * @date 2019/2/22 13:26
	 */
	@RequestMapping(value = "/historyPrice", method = RequestMethod.POST)
	@ResponseBody
	public HistoryPriceResponseDTO search(@RequestBody HistoryPriceRequestDTO historyPriceRequestDTO) {
		HistoryPriceResponseDTO historyPriceResponseDTO = searchService.historyPrice(historyPriceRequestDTO);
		//时间显示格式转换
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		List<String> dateStringList = new ArrayList<String>();
		for (Date date : historyPriceResponseDTO.getDateList()) {
			dateStringList.add(simpleDateFormat.format(date));
		}
		historyPriceResponseDTO.setDateListString(dateStringList);
		return historyPriceResponseDTO;
	}

}
