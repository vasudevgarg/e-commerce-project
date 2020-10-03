package com.vdg.ecommerce_website.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vdg.ecommerce_website.Model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

	Agent findByUsername(String username);

}
