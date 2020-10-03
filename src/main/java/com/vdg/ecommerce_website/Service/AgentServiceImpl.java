package com.vdg.ecommerce_website.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdg.ecommerce_website.DAO.AgentRepository;
import com.vdg.ecommerce_website.Model.Agent;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public void save(Agent theAgent) {
		
		agentRepository.save(theAgent);
	}

	@Override
	public Agent findByUsername(String username) {
		return agentRepository.findByUsername(username);
	}

	
}
