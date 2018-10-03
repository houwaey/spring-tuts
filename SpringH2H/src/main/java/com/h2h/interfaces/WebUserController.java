package com.h2h.interfaces;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.h2h.dto.ResponseEntity;
import com.h2h.model.WebUser;

public interface WebUserController {

	public ResponseEntity<Void> createWebUser(WebUser user, BindingResult result);
	
	public ResponseEntity<WebUser> updateWebUser(WebUser user);
	
	public ResponseEntity<Void> activateWebUser(WebUser user);
	
	public ResponseEntity<Void> deactivateWebUser(WebUser user);
	
	public ResponseEntity<Void> unlockWebUser(WebUser user);
	
	public ResponseEntity<WebUser> findWebUserById(long id);
	
	public ResponseEntity<WebUser> findWebUserByUsername(String username);
	
	public ResponseEntity<List<WebUser>> findAllWebUsers();
	
}
