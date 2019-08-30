package com.da.service;

import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MyPipeline implements Pipeline {
	private ZLService service = new ZLService();

	@Override
	public void process(ResultItems resultItems, Task task) {
		Map<String, Object> map = resultItems.getAll();
		if (map.get("detailPlace") != null)
			service.saveZLData(map);
	}

}
