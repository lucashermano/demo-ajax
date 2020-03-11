package com.mballem.demoajax.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mballem.demoajax.domain.SocialMetaTag;
import com.mballem.demoajax.service.SocialMetaTagService;

@Controller
@RequestMapping("/meta")
public class SocialMetaTagController {

	@Autowired
	private SocialMetaTagService service;

	@PostMapping("/info")
	public ResponseEntity<SocialMetaTag> getDadisViaUrl(@RequestParam("url") String url) {
		SocialMetaTag socialMetaTag = service.getOpenGraphByUrl(url);
		return socialMetaTag != null ? ResponseEntity.ok(socialMetaTag) : ResponseEntity.notFound().build();
	}

}