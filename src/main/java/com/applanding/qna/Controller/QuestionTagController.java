package com.applanding.qna.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.applanding.qna.Model.Tags;
import com.applanding.qna.Request.TagUpdateRequest;
import com.applanding.qna.Service.TagsService;

@RestController
@RequestMapping("/api/tag")
public class QuestionTagController {

	@Autowired
	private TagsService tagService;
	
	@PostMapping("/add")
	public ResponseEntity<Tags> addTag(@RequestBody  Tags tag)
	{
		return new ResponseEntity<Tags>(tagService.addTag(tag),HttpStatus.CREATED);
	}
	
	
	@GetMapping("")
	public Iterable<Tags> findAll(){
		return tagService.findAll();
	}
	
	@GetMapping("/{tagId}")
	public Tags findById(@PathVariable Long tagId)
	{
		return tagService.findById(tagId);
	}
	
	@PostMapping("/delete")
	public HttpStatus delete(@RequestBody Map<String,Long> deleteRequest)
	{
		tagService.delete(deleteRequest.get("id"));
		return HttpStatus.OK;
	}
	
	@PostMapping("/update")
	public HttpStatus update(@RequestBody TagUpdateRequest tagUpdateRequest)
	{
		tagService.update(tagUpdateRequest);
		return HttpStatus.OK;
	}
}
