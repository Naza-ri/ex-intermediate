package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Domain.Baseballteam;
import com.example.Repository.BaseballRepository;

@Service
@Transactional
public class BaseballService {
	@Autowired
	private BaseballRepository baseballRepository;
	
	public List<Baseballteam> showList() {
		return baseballRepository.showList();
	}
	
	public Baseballteam showDetail(Integer id) {
		return baseballRepository.showDetail(id);
	}
}
