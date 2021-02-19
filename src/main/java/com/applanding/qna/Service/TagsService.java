package com.applanding.qna.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applanding.qna.DAO.QuestionTagRepository;
import com.applanding.qna.DAO.TagsRepository;
import com.applanding.qna.Model.Tags;
import com.applanding.qna.Request.TagUpdateRequest;

@Service
public class TagsService {

	@Autowired
	private TagsRepository tagsRepo;
	
	@Autowired
	private QuestionTagRepository qTagRepo;
	
	public Tags addTag(Tags tag)
	{
		return tagsRepo.save(tag);
	}
	
	public Iterable<Tags> findAll(){
		return tagsRepo.findAll();
	}
	
	public Tags findById(Long id)
	{
		return tagsRepo.findById(id).get();
	}
	
	public void delete(Long id)
	{
		qTagRepo.updateTagIdUponRemoval(id);
		tagsRepo.deleteById(id);
	}
	
	public Tags update(TagUpdateRequest tagUpdateRequest)
	{
		Tags tag = new Tags();
		if(tagUpdateRequest.getTagId().isPresent())
		{
			tag = tagsRepo.findById(tagUpdateRequest.getTagId().get()).get();
		}
		if(!tagUpdateRequest.getTagName().isEmpty())
		{
			tag.setTagName(tagUpdateRequest.getTagName());
			tagsRepo.save(tag);
		}
		return tag;
	}
}
