package com.h2h.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2h.dto.ResponseEntity;
import com.h2h.interfaces.WebUserController;
import com.h2h.model.WebUser;
import com.h2h.service.UserService;
import com.h2h.util.Constant;

@RestController
@RequestMapping("/user")
public class UserController implements WebUserController {

	@Autowired
	private UserService<WebUser> webUserService;

	@Override
	@PostMapping("/web/create")
	public ResponseEntity<Void> createWebUser(@Valid @RequestBody WebUser user, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED, result.getFieldErrors());
		}

		boolean created = webUserService.create(user);
		if (!created) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/web/update")
	public ResponseEntity<WebUser> updateWebUser(@RequestBody WebUser user) {
		WebUser temp = webUserService.findOneById(user.getId());
		if (temp == null) {
			return new ResponseEntity<WebUser>(HttpStatus.NOT_FOUND);
		}
		
		boolean updated = webUserService.update(user);
		if (!updated) {
			return new ResponseEntity<WebUser>(HttpStatus.PRECONDITION_FAILED, "Failed to update");
		}
		
		return new ResponseEntity<WebUser>(user, HttpStatus.OK, "Successfully updated");
	}

	@Override
	@PutMapping("/web/activate")
	public ResponseEntity<Void> activateWebUser(@RequestBody WebUser user) {
		WebUser tempUser = webUserService.findOneById(user.getId());
		if (tempUser == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		if (Constant.ACTIVE.equals(tempUser.getStatus())) {
			return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED, "Account is already active");
		}
		
		user.setStatus(Constant.ACTIVE);
		
		boolean updated = webUserService.updateStatus(user);
		if (!updated) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED, "Failed to activate");
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK, "Successfully activated");
	}
	
	@Override
	@PutMapping("/web/deactivate")
	public ResponseEntity<Void> deactivateWebUser(WebUser user) {
		WebUser tempUser = webUserService.findOneById(user.getId());
		if (tempUser == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		if (Constant.INACTIVE.equals(tempUser.getStatus())) {
			return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED, "Account is already inactive");
		}
		
		user.setStatus(Constant.INACTIVE);
		
		boolean updated = webUserService.updateStatus(user);
		if (!updated) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED, "Failed to deactivate");
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK, "Successfully deactivated");
	}

	@Override
	@PutMapping("/web/unlock")
	public ResponseEntity<Void> unlockWebUser(WebUser user) {
		WebUser tempUser = webUserService.findOneById(user.getId());
		if (tempUser == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		if (Constant.ACTIVE.equals(tempUser.getStatus())) {
			return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED, "Account is already unlocked/active");
		}
		
		user.setStatus(Constant.ACTIVE);
		
		boolean updated = webUserService.updateStatus(user);
		if (!updated) {
			return new ResponseEntity<Void>(HttpStatus.PRECONDITION_FAILED, "Failed to unlock");
		}
		
		return new ResponseEntity<Void>(HttpStatus.OK, "Successfully unlocked");
	}

	@Override
	@GetMapping("/web/id/{id}")
	public ResponseEntity<WebUser> findWebUserById(@PathVariable("id") long id) {
		WebUser user = webUserService.findOneById(id);
		if (user == null) {
			return new ResponseEntity<WebUser>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<WebUser>(user, HttpStatus.FOUND);
	}

	@Override
	@GetMapping("/web/username/{username}")
	public ResponseEntity<WebUser> findWebUserByUsername(@PathVariable("username") String username) {
		WebUser user = webUserService.findOneByKeyVal(Constant.USERNAME, username);
		if (user == null) {
			return new ResponseEntity<WebUser>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<WebUser>(user, HttpStatus.OK, HttpStatus.FOUND.getReasonPhrase());
	}

	@Override
	@GetMapping("/web/all")
	public ResponseEntity<List<WebUser>> findAllWebUsers() {
		List<WebUser> users = webUserService.findAll();
		if (users.size() <= 0) {
			return new ResponseEntity<List<WebUser>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<WebUser>>(users, HttpStatus.OK);
	}
	
}
