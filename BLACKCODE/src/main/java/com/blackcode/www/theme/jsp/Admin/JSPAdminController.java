package com.blackcode.www.theme.jsp.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	// 해당경로 이하의 파일을 리턴
public class JSPAdminController {
	private String path = "/theme/jsp/admin/";
	
	@GetMapping("/theme/jsp/admin")
	public String themeIndex() {
		// return 기본경로 : src/main/resource/static
		System.out.println("타임리프 적용 전 경로 : src/main/resource/static"+path+"/index.html");
		System.out.println("타임리프 적용 후 경로 : src/main/resources/templates/"+path+"/index.html");
		return path+"index";
	}
	
}
